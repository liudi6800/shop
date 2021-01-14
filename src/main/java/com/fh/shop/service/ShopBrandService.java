package com.fh.shop.service;


import com.fh.shop.entity.po.ShopBrand;
import com.fh.shop.entity.vo.ShopBrandParms;


import java.util.Map;

public interface ShopBrandService {

    Map getData(ShopBrandParms parms);

    void addShopBrand(ShopBrand shopBrand);

    void updateShopBrand(ShopBrand shopBrand);
}
