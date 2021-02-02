package com.fh.shop.service.impl;

import com.fh.shop.dao.RoleDao;
import com.fh.shop.entity.po.Role;
import com.fh.shop.service.RoleService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;


    @Override
    public List<Role> selectRole() {
        return roleDao.queryRoleData();
    }

    @Override
    public void addRole(Role role) {
        Date da=new Date();
        role.setCreateDate(da);
        roleDao.addRole(role);
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }

    @Override
    public void delRole(Integer id, Integer isDel) {
        roleDao.isDelRole(id,isDel);
    }
}
