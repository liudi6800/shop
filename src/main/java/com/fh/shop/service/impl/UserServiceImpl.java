package com.fh.shop.service.impl;

import com.fh.shop.dao.UserDao;

import com.fh.shop.entity.po.User;
import com.fh.shop.entity.vo.ShopBrandParms;
import com.fh.shop.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public Map getData(ShopBrandParms parms) {
        Map map=new HashMap();
        Integer integer = userDao.selectUserCount(parms);
        parms.setStartIndex((parms.getPage()-1)*parms.getLimit());
        List<User> shopBrands = userDao.selectUserData(parms);
        map.put("count",integer);
        map.put("data",shopBrands);
        return map;
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
