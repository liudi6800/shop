package com.fh.shop.service;

import com.fh.shop.entity.po.User;
import com.fh.shop.entity.po.UserRole;
import com.fh.shop.entity.vo.ShopBrandParms;

import java.util.List;
import java.util.Map;

public interface UserService {
    Map getData(ShopBrandParms parms);

    void updateUser(User user);

    void addUserRole(Integer uid, String rid);

    List<UserRole> selectUserRoleByUid(Integer uid);
}
