package com.fh.shop.service;

import com.fh.shop.entity.po.User;
import com.fh.shop.entity.vo.ShopBrandParms;

import java.util.Map;

public interface UserService {
    Map getData(ShopBrandParms parms);

    void updateUser(User user);
}
