package com.fh.shop.service;

import com.fh.shop.entity.po.Role;

import java.util.List;

public interface RoleService {
    List<Role> selectRole();

    void addRole(Role role);

    void updateRole(Role role);

    void delRole(Integer id, Integer isDel);
}
