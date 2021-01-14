package com.fh.shop.dao;

import com.fh.shop.entity.po.ShopProperty;
import com.fh.shop.entity.vo.ShopPropertyParms;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ShopPropertyDao {

    public Integer  selectShopPropertyCount(ShopPropertyParms parms);

    public List<ShopProperty> selectShopPropertyData(ShopPropertyParms parms);


    void addShopProperty(ShopProperty shopProperty);

    void updateShopProperty(ShopProperty shopProperty);

    @Update("update s_shop_property set isDel=1  where id=#{id}")
    void deleteShopPropertyById(Integer id);
}
