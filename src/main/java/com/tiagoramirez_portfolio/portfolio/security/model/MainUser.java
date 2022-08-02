package com.tiagoramirez_portfolio.portfolio.security.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainUser implements UserDetails {
    private String username;

    private String password;

    private String full_name;

    private LocalDate birthday;

    private String mail;

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static MainUser build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName().name())).collect(Collectors.toList());
        MainUser ret = new MainUser();
        ret.setUsername(user.getUsername());
        ret.setPassword(user.getPassword());
        ret.setFull_name(user.getFull_name());
        ret.setBirthday(user.getBirthday());
        ret.setMail(user.getMail());
        ret.setAuthorities(authorities);
        return ret;
    }
}
