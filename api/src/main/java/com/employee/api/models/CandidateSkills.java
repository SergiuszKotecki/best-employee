package com.employee.api.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CANDIDATE_TABLE_SKILLS")
public class CandidateSkills {


    private String skillName;

    private int skillLevel;

}
