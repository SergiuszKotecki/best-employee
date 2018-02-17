package com.employee.api.model;

import com.employee.api.config.LocalDateTimeConverter;
import com.employee.api.model.enums.SkillLevelEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = { "authorities" })
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Candidate implements UserDetails {

    private static final long serialVersionUID = 3709949243021685681L;

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

    @Column(nullable = false, unique = true)
    @Email(message = "Incorrect email format")
    private String email;


    @NotNull
    private String desiredPosition;

    @NotNull
    private SkillLevelEnum devLevel;

    @Embedded
    private Location location;

    @NotNull
    private boolean remote;

    @Column
    private boolean isAccountNonExpired;

    @Column
    private boolean isAccountNonLocked;

    @Column
    private boolean isCredentialsNonExpired;

    @Column
    private boolean isEnabled;

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

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "appuser_role",
            joinColumns = @JoinColumn(name = "appuser_id"),
            inverseJoinColumns = @JoinColumn(name = "approle_id"))
    private List<Role> authorities;

    @Column(nullable = false)
    @Size(min = 4, max = 100, message = "Password must be at least 4 characters long")
    private String password;

    @Column(nullable = false, unique = true, length = 25)
    @Size(min = 3, max = 25, message = "Username must be between 3 and 20 characters long")
    private String username;

}
