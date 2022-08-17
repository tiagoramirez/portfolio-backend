package com.tiagoramirez_portfolio.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "description")
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "id_profile")
    private Integer profileId;
    
    @Column(name = "id_project")
    private Integer projectId;
    
    @Column(name = "id_education")
    private Integer educationId;
    
    @Column(name = "id_experience")
    private Integer experienceId;

    @Column(name = "description")
    private String description;
}
