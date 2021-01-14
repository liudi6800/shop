package com.fh.shop.service;

import com.fh.shop.entity.po.ShopType;

import java.util.List;

public interface ShopTypeService {

    List<ShopType> selectShopType();

    List<ShopType> selectShopTypeByPid(Integer pid);

    Integer addShopType(ShopType shopType);


    void updateShopType(ShopType shopType);
}
