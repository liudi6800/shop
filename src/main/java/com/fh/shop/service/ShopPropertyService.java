package com.fh.shop.service;

import com.fh.shop.entity.po.ShopProperty;
import com.fh.shop.entity.vo.ShopPropertyParms;

import java.util.List;
import java.util.Map;

public interface ShopPropertyService {
    Map selectShopPropertyByParma(ShopPropertyParms parms);

    void addShopProperty(ShopProperty shopProperty);

    void updateShopProperty(ShopProperty shopProperty);

    void deleteShopPropertyById(Integer id, Integer isDel);

    List<ShopProperty> getAllData();

    List<ShopProperty> selectShopProByTypeId(Integer typeId);


}
