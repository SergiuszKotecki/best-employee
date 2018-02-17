package com.employee.api.model.enums;

import lombok.Getter;

@Getter
public enum SkillLevelEnum {
    JUNIOR("junior"), REGULAR("regular"), SENIOR("senior");

    String skillLevel;

    SkillLevelEnum(String skillLevel){
        this.skillLevel = skillLevel;
    }
}
