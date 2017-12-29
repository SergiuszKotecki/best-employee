package com.employee.api.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@Table(name = "CANDIDATE_TABLE")
public class Candidate {

    @Id
    @GeneratedValue
    //@GenericGenerator(name = "uuid2", strategy = "uuid2")
    @ApiModelProperty(hidden = true)
    @Column(name = "UUID", unique = true, length = Integer.MAX_VALUE)
    private Long uuid;

    @NotNull
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotNull
    @Column(name = "LAST_NAME")
    private String lastName;

    @NotNull
    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @Column(name = "DESIRED_POSITION")
    private String desiredPosition;

    @NotNull
    @Column(name = "SKILL_LEVEL")
    private Integer skillLevel;

    @NotNull
    @Column(name = "CITY")
    private String city;

    @NotNull
    @Column(name = "IS_REMOTE")
    private boolean remote;

    public Candidate(String firstName, String lastName, String email, String desiredPosition, Integer skillLevel, String city, boolean remote) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.desiredPosition = desiredPosition;
        this.skillLevel = skillLevel;
        this.city = city;
        this.remote = remote;
    }
}
