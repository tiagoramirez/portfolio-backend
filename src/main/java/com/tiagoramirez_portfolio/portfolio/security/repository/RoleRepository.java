package com.tiagoramirez_portfolio.portfolio.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiagoramirez_portfolio.portfolio.security.enums.RoleNames;
import com.tiagoramirez_portfolio.portfolio.security.model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByRoleName(RoleNames roleName);

    Boolean existsByRoleName(RoleNames roleName);
}
