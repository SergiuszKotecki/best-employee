package com.employee.api.service.impl;

import com.employee.api.model.Role;
import com.employee.api.model.enums.RoleEnum;
import com.employee.api.repository.RoleRepository;
import com.employee.api.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
    @Override
    public Role findByAuthority(@NotNull RoleEnum authority) {
        return roleRepository.findByAuthority(authority.toString());
    }

    @Override
    public Role findOne(@NotNull Long id) {
        return roleRepository.findOne(id);
    }

    @Override
    public Role save(@NotNull Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role createRoleIfNotFound(RoleEnum roleEnum) {
        Role role = this.findByAuthority(roleEnum.toString());
        if (role == null) {
            role = new Role(roleEnum);
            this.save(role);
        }
        return role;
    }

    private Role findByAuthority(@NotNull String authority) {
        return roleRepository.findByAuthority(authority);
    }

}
