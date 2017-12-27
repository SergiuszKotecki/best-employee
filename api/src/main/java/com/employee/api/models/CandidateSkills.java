package com.employee.api.models;

import javax.validation.constraints.NotNull;

public class CandidateSkills {

    @NotNull
    String skillName;

    @NotNull
    Integer skillLevel;
}
