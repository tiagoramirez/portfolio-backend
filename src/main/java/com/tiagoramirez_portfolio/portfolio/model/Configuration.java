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
@Table(name = "configuration")
public class Configuration {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "id_person", unique = true)
    private Integer personId;

    @Column(name = "show_photo")
    private Boolean show_photo;

    @Column(name = "show_banner")
    private Boolean show_banner;

    @Column(name = "show_birthday")
    private Boolean show_birthday;

    @Column(name = "show_location")
    private Boolean show_location;

    @Column(name = "show_phone")
    private Boolean show_phone;
}