package com.tiagoramirez_portfolio.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tiagoramirez_portfolio.portfolio.security.model.User;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Getter
@Setter
@Entity
@Table(name = "user_social_media")
public class UserSocialMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "id_user", updatable = false)
    private Integer userId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private User user;

    @Column(name = "id_social_media")
    private Integer id_social_media;

    @ManyToOne
    @JoinColumn(name = "id_social_media", insertable = false, updatable = false)
    private SocialMedia social_media;

    @Column(name = "link")
    private String link;
}
