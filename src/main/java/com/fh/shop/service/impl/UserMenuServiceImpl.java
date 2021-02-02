package com.fh.shop.service.impl;

import com.fh.shop.dao.UserMenuDao;
import com.fh.shop.entity.po.Menu;
import com.fh.shop.service.UserMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
