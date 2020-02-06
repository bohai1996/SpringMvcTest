package com.bohai.dao.impl;

import com.bohai.dao.RoleDao;
import com.bohai.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RoleDaoImpl implements RoleDao {
    private JdbcTemplate jdbcTemplate;
    public List<Role> findAll() {
        String sql="select * from sys_role";
        List<Role> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Role>(Role.class));
        return list;
    }

    public void save(Role role) {
        String sql = "insert into sys_role values(?,?,?)";
        jdbcTemplate.update(sql,null,role.getRoleName(),role.getRoleDesc());
    }

    public List<Role> findRoleByUserId(Long id) {
        String sql="select * from sys_user_role ur,sys_role r where ur.roleId=r.id and ur.userId=?";
        List<Role> roles = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Role>(Role.class), id);

        return roles;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
