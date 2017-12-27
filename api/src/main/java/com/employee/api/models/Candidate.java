package com.employee.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CANDIDATE_TABLE")
public class Candidate {

    @Id
    @GeneratedValue
    @Column(name = "UUID", unique = true, length = Integer.MAX_VALUE)
    long id;

    @NotNull
    @Column(name = "FIRST_NAME")
    String firstName;

    @NotNull
    @Column(name = "LAST_NAME")
    String lastName;

    @NotNull
    @Column(name = "EMAIL")
    String email;

    @NotNull
    @Column(name = "DESIRED_POSITION")
    String desiredPosition;

    @NotNull
    @Column(name = "SKILL_LEVEL")
    Integer skillLevel;

    @NotNull
    @Column(name = "CITY")
    String city;

    @NotNull
    @Column(name = "IS_REMOTE")
    boolean remote;

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
