package com.fh.shop.dao;

import com.fh.shop.entity.po.ShopBrand;

import com.fh.shop.entity.vo.ShopBrandParms;


import java.util.List;

public interface ShopBrandDao {


    public Integer selectShopBrandCount(ShopBrandParms parms);

    public List<ShopBrand> selectShopBrandData(ShopBrandParms parms);

    public void  addShopBrand(ShopBrand shopBrand);

    public void  updateShopBrand(ShopBrand shopBrand);

}
