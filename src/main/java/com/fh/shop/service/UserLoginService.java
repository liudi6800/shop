package com.fh.shop.service;

import com.fh.shop.entity.po.Menu;
import com.fh.shop.entity.po.User;

import java.util.List;
import java.util.Map;

public interface UserLoginService {
    Map addUser(User user);

    Map toLoginUser(String name, String password);

    List<Menu> selectUserMeunData(String name);
}
