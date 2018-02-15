package com.employee.api.model;

import com.employee.api.config.LocalDateTimeConverter;
import com.employee.api.model.enums.SkillLevel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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
            inverseJoinColumns = @JoinColumn(name = "candidate_skills_id")
    )
    private Set<CandidateSkill> skills = new HashSet<>();

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String desiredPosition;

    @NotNull
    private SkillLevel devLevel;

    @Embedded
    private Location location;

    @NotNull
    private boolean remote;

    @CreatedDate
    @ApiModelProperty(hidden = true)
    @Convert(converter = LocalDateTimeConverter.class)
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    @Convert(converter = LocalDateTimeConverter.class)
    @ApiModelProperty(hidden = true)
    private LocalDateTime updatedAt;

}
