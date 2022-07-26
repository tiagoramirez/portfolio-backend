package com.tiagoramirez_portfolio.portfolio.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiagoramirez_portfolio.portfolio.security.model.User;
import com.tiagoramirez_portfolio.portfolio.security.repository.UserRepository;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public Boolean existsByMail(String mail) {
        return userRepository.existsByMail(mail);
    }

    public Integer addNew(User user) {
        User newUser = userRepository.save(user);
        return newUser.getId();
    }
}
