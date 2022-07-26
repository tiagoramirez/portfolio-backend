package com.tiagoramirez_portfolio.portfolio.security.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoramirez_portfolio.portfolio.dto.ResponseMessage;
import com.tiagoramirez_portfolio.portfolio.model.AboutMe;
import com.tiagoramirez_portfolio.portfolio.model.Configuration;
import com.tiagoramirez_portfolio.portfolio.model.Profile;
import com.tiagoramirez_portfolio.portfolio.security.dto.JwtDto;
import com.tiagoramirez_portfolio.portfolio.security.dto.LoginUser;
import com.tiagoramirez_portfolio.portfolio.security.dto.NewUser;
import com.tiagoramirez_portfolio.portfolio.security.enums.RoleNames;
import com.tiagoramirez_portfolio.portfolio.security.jwt.JwtProvider;
import com.tiagoramirez_portfolio.portfolio.security.model.Role;
import com.tiagoramirez_portfolio.portfolio.security.model.User;
import com.tiagoramirez_portfolio.portfolio.security.service.RoleService;
import com.tiagoramirez_portfolio.portfolio.security.service.UserService;
import com.tiagoramirez_portfolio.portfolio.service.AboutMeService;
import com.tiagoramirez_portfolio.portfolio.service.ConfigurationService;
import com.tiagoramirez_portfolio.portfolio.service.ProfileService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private JwtProvider jwtProvider;

    // START Project logic
    @Autowired
    private ProfileService profileService;

    @Autowired
    private ConfigurationService configurationService;

    @Autowired
    private AboutMeService aboutMeService;
    // END Project logic

    @PostMapping("/register")
    public ResponseEntity<?> addNew(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Datos invalidos"), HttpStatus.BAD_REQUEST);
        }
        if (userService.existsByUsername(newUser.getUsername())) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("El usuario ya existe"),
                    HttpStatus.BAD_REQUEST);
        }
        if (userService.existsByMail(newUser.getMail())) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("El mail ya existe"),
                    HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setUsername(newUser.getUsername());
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setFull_name(newUser.getFull_name());
        user.setBirthday(newUser.getBirthday());
        user.setMail(newUser.getMail());
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getByRoleName(RoleNames.ROLE_USER));
        if (newUser.getRoles().contains("admin")) {
            roles.add(roleService.getByRoleName(RoleNames.ROLE_ADMIN));
        }
        user.setRoles(roles);
        Integer newUserId = userService.addNew(user);
        // START Project logic
        Integer newProfileId = profileService.addNew(Profile.emptyProfile(newUserId));
        configurationService.addNew(Configuration.emptyConfiguration(newProfileId));
        aboutMeService.addNew(AboutMe.emptyAboutMe(newProfileId));
        // END Project logic
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("Usuario creado correctamente", newUserId),
                HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Datos invalidos"),
                    HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto();
        jwtDto.setToken(jwt);
        jwtDto.setUsername(userDetails.getUsername());
        jwtDto.setAuthorities(userDetails.getAuthorities());
        Integer userId = userService.getByUsername(userDetails.getUsername()).getId();
        jwtDto.setUserId(userId);
        return new ResponseEntity<JwtDto>(jwtDto, HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/user/{username}")
    public User getByUsername(@PathVariable String username) {
        return userService.getByUsername(username);
    }
}
