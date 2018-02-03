package com.employee.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "CANDIDATE_TABLE_SKILLS")
public class CandidateSkills implements Serializable{

    @Id
    @GeneratedValue
    private int id;

    private String skillName;

    private int skillLevel;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @ManyToMany(mappedBy = "skills")
    @ApiModelProperty(hidden = true)
    private List<Candidate> candidates;

    public CandidateSkills(String skillName, int skillLevel) {
        this.skillName = skillName;
        this.skillLevel = skillLevel;
    }
}
