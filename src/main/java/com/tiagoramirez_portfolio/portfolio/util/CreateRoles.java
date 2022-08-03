package com.tiagoramirez_portfolio.portfolio.util;

import com.tiagoramirez_portfolio.portfolio.security.enums.RoleNames;
import com.tiagoramirez_portfolio.portfolio.security.model.Role;
import com.tiagoramirez_portfolio.portfolio.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        // Role roleAdmin = new Role();
        // roleAdmin.setRoleName(RoleNames.ROLE_ADMIN);
        // Role roleUser = new Role();
        // roleUser.setRoleName(RoleNames.ROLE_USER);
        // roleService.addNew(roleAdmin);
        // roleService.addNew(roleUser);
    }
}
