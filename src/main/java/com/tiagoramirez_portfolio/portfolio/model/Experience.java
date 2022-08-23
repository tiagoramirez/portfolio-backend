package com.tiagoramirez_portfolio.portfolio.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tiagoramirez_portfolio.portfolio.security.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "experience")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "id_user")
    private Integer userId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private User user;

    @Column(name = "position")
    private String position;

    @Column(name = "type")
    private String type;
    
    @Column(name = "company_name")
    private String company_name;
    
    @Column(name = "location")
    private String location;

    @Column(name = "isActual")
    private Boolean isActual;

    @Column(name = "start_date")
    private LocalDate start_date;

    @Column(name = "end_date")
    private LocalDate end_date;

}
