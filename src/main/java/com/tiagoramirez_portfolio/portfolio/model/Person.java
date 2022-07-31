package com.tiagoramirez_portfolio.portfolio.model;

import java.time.LocalDate;

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
    private LocalDate birthday;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "mail")
    private String mail;

    @Column(name = "description")
    private String description;

    @Column(name = "location_state")
    private String location_state;

    @Column(name = "location_country")
    private String location_country;

    @Column(name = "id_photo")
    private Integer id_photo;

    @Column(name = "id_banner")
    private Integer id_banner;
}
