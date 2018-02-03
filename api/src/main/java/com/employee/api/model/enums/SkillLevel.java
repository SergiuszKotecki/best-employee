package com.employee.api.model.enums;

import lombok.Getter;

@Getter
public enum SkillLevel {
    JUNIOR("junior"), REGULAR("regular"), SENIOR("senior");

    String skillLevel;

    SkillLevel(String skillLevel){
        this.skillLevel = skillLevel;
    }
}
