package com.bohai.service;

import com.bohai.domain.Role;

import java.util.List;

public interface RoleService {

    public List<Role> list();

    void save(Role role);
}
