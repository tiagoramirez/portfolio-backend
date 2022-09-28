package com.tiagoramirez_portfolio.portfolio.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiagoramirez_portfolio.portfolio.security.enums.RoleNames;
import com.tiagoramirez_portfolio.portfolio.security.model.Role;
import com.tiagoramirez_portfolio.portfolio.security.repository.RoleRepository;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role getByRoleName(RoleNames roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
