package com.fh.shop.service;

import com.fh.shop.entity.po.Menu;

import java.util.List;

public interface UserMenuService {
    List<Menu> selectMenuData();

    void addMenu(Menu menu);

    void updateMenu(Menu menu);

    Menu selectMenuDataById(Integer id);
}
