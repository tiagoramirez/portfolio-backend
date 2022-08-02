package com.tiagoramirez_portfolio.portfolio.security.service;

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

    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public Boolean existsByMail(String mail) {
        return userRepository.existsByMail(mail);
    }

    public void addNew(User user) {
        userRepository.save(user);
    }
}
