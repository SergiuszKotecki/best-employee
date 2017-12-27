package com.employee.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CANDIDATE_TABLE")
public class Candidate {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID", unique = true, length = Integer.MAX_VALUE)
    long id;

    @NotNull
    @Column(name = "firstName")
    String firstName;

    @NotNull
    @Column(name = "lastName")
    String lastName;

    @NotNull
    @Column(name = "email")
    String email;

    @NotNull
    @Column(name = "desiredPosition")
    String desiredPosition;

    @NotNull
    @Column(name = "skillLevel")
    Integer skillLevel;

    @NotNull
    @Column(name = "city")
    String city;

    @NotNull
    @Column(name = "remotfirstNamee")
    boolean remote;

}
