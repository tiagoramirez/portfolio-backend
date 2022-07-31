package com.tiagoramirez_portfolio.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Getter
@Setter
@Entity
@Table(name = "my_social_media")
public class MySocialMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "id_person")
    private Integer personId;

    @Column(name = "id_social_media")
    private Integer id_social_media;

    @ManyToOne
    @JoinColumn(name = "id_social_media", insertable = false, updatable = false)
    private SocialMedia social_media;

    @Column(name = "link")
    private String link;
}
