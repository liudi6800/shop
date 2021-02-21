package com.fh.shop.service.impl;

import com.fh.shop.dao.UserMenuDao;
import com.fh.shop.entity.po.Menu;
import com.fh.shop.entity.po.Role;
import com.fh.shop.entity.po.RoleMenu;
import com.fh.shop.service.UserMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserMenuServiceImpl implements UserMenuService {

    @Resource
    private UserMenuDao userMenuDao;

    @Override
    public List<Menu> selectMenuData() {

        return userMenuDao.selectMenuData();
    }

    @Override
    public void addMenu(Menu menu) {
        menu.setCreateDate(new Date());
        userMenuDao.addMenu(menu);
    }

    @Override
    public void updateMenu(Menu menu) {
        userMenuDao.updateMenu(menu);
    }

    @Override
    public Menu selectMenuDataById(Integer id) {

        return userMenuDao.selectMenuDataById(id);
    }

    @Override
    public void addRoleMenu(Integer rid, String menus) {
        userMenuDao.delUserRoleByRid(rid);
        List<RoleMenu>list=new ArrayList<>();
        String[] split = menus.split(",");
        for (int i = 0; i <split.length ; i++) {
            RoleMenu rm=new RoleMenu();
            rm.setRid(rid);
            rm.setMid(Integer.parseInt(split[i]));
            list.add(rm);
        }
        userMenuDao.addRoleMenu(list);
    }

    @Override
    public List<RoleMenu> selectRoleMenuDataByRid(Integer rid) {
        List<RoleMenu>list=  userMenuDao.selectRoleMenuDataByRid(rid);
        return list;
    }

}
