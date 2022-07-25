package com.tiagoramirez_portfolio.portfolio.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiagoramirez_portfolio.portfolio.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
    
}
