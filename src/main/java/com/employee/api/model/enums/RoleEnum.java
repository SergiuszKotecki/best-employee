package com.employee.api.model.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {
    ADMIN("admin"), CANDIDATE("Candidate"), RECRUITER("recruiter");

    String role;

    RoleEnum(String role) {
        this.role = role;
    }

}
