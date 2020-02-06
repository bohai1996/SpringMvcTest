package com.bohai.service.impl;

import com.bohai.dao.RoleDao;
import com.bohai.domain.Role;
import com.bohai.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;
    public List<Role> list() {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    public void save(Role role) {
        roleDao.save(role);
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
