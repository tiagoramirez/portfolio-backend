package com.tiagoramirez_portfolio.portfolio.model;

import java.io.File;
import java.sql.Date;

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
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "mail")
    private String mail;

    @Column(name = "description")
    private String description;

    @Column(name = "photo")
    private File photo;

    @Column(name = "banner")
    private File banner;
}
