package com.tiagoramirez_portfolio.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Column(name = "id_person")
    private Integer id_person;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_person", insertable = false, updatable = false)
    private Person person;

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