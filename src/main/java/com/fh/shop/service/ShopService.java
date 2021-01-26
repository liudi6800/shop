package com.fh.shop.service;

import com.fh.shop.entity.po.Shop;
import com.fh.shop.entity.vo.ShopParms;

import java.util.Map;

public interface ShopService {
    Map selectShop(ShopParms parms);

    void addShop(Shop shop, String proData, String skuData);

    void updateShop(Shop shop);

    void delShop(Integer isDel, Integer id);



}
