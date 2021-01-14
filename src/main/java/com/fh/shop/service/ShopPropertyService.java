package com.fh.shop.service;

import com.fh.shop.entity.vo.ShopPropertyParms;

import java.util.Map;

public interface ShopPropertyService {
    Map selectShopPropertyByParma(ShopPropertyParms parms);
}
