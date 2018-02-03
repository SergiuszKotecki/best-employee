package com.employee.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Candidate implements Serializable {

    @Id
    @ApiModelProperty(hidden = true)
    @GeneratedValue(generator = "uuid")
    @Column(name = "uuid", unique = true)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String uuid;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "skill",
            joinColumns = @JoinColumn(name = "candidate_uuid"),
            inverseJoinColumns = @JoinColumn(name = "Candidate_Skills_id")
    )
    private List<CandidateSkills> skills;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String desiredPosition;

    @NotNull
    private Integer devLevel;

    @NotNull
    private String city;

    @NotNull
    private boolean remote;

    @CreatedDate
    //@ApiModelProperty(hidden = true) TODO:Add DTO and uncomment this
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    //@ApiModelProperty(hidden = true) TODO:Add DTO and uncomment this
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

}
