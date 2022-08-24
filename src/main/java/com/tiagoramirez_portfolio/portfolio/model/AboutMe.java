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
@Table(name = "about_me")
public class AboutMe {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "id_profile")
    private Integer profileId;

    @Column(name = "about_me")
    private String about_me;

    public static AboutMe emptyAboutMe(Integer profileId) {
        AboutMe aboutMe = new AboutMe();
        aboutMe.setProfileId(profileId);
        aboutMe.setAbout_me("");
        return aboutMe;
    }
}