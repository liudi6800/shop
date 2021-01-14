package com.fh.shop.dao;

import com.fh.shop.entity.po.ShopProperty;
import com.fh.shop.entity.vo.ShopPropertyParms;

import java.util.List;

public interface ShopPropertyDao {

    public Integer  selectShopPropertyCount(ShopPropertyParms parms);

    public List<ShopProperty> selectShopPropertyData(ShopPropertyParms parms);


}
