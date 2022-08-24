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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tiagoramirez_portfolio.portfolio.security.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_technologies")
public class UserTechnologies {
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

    @Column(name = "id_technologie")
    private Integer id_technologie;

    @ManyToOne
    @JoinColumn(name = "id_technologie", insertable = false, updatable = false)
    private Technologie technologie;

    @Column(name = "percentage")
    private Integer percentage;
}
