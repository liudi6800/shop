package com.fh.shop.service.impl;

import com.fh.shop.dao.ShopTypeDao;
import com.fh.shop.entity.po.ShopType;
import com.fh.shop.service.ShopTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ShopTypeServiceImpl implements ShopTypeService {
    @Resource
    private ShopTypeDao shopTypeDao;


    @Override
    public List<ShopType> selectShopType() {
        return shopTypeDao.selectShopType();
    }

    @Override
    public List<ShopType> selectShopTypeByPid(Integer pid) {

        return shopTypeDao.selectShopTypeByPid(pid);
    }

    @Override
    public Integer addShopType(ShopType shopType) {
        shopType.setCreateDate(new Date());
        shopType.setIsDel(0);
        shopTypeDao.addShopType(shopType);
        return shopType.getId() ;

    }

    @Override
    public void updateShopType(ShopType shopType) {
        shopType.setUpdateDate(new Date());
        shopTypeDao.updateShopType(shopType);
    }
}
