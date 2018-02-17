package com.employee.api.service;

import com.employee.api.model.Role;
import com.employee.api.model.enums.RoleEnum;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role findByAuthority(RoleEnum authority);

    Role findOne(Long id);

    Role save(Role role);

    Role createRoleIfNotFound(RoleEnum roleEnum);
}
