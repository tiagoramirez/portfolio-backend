package com.tiagoramirez_portfolio.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "id_profile", unique = true)
    private Integer profileId;

    @Column(name = "show_photo")
    private Boolean show_photo;

    @Column(name = "show_banner")
    private Boolean show_banner;

    @Column(name = "show_location")
    private Boolean show_location;

    @Column(name = "show_phone")
    private Boolean show_phone;

    public static Configuration emptyConfiguration(Integer profileId) {
        Configuration config = new Configuration();
        config.setProfileId(profileId);
        config.setShow_photo(false);
        config.setShow_banner(false);
        config.setShow_location(false);
        config.setShow_phone(false);
        return config;
    }
}