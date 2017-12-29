package com.employee.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

}
