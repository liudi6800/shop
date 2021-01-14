package com.fh.shop.dao;

import com.fh.shop.entity.po.ShopType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopTypeDao {


    @Select("select * from s_shoptype where isDel=0")
    List<ShopType> selectShopType();

    @Select("select * from s_shoptype  where pid=#{pid}  and isDel=0")
    List<ShopType> selectShopTypeByPid(Integer pid);


    int addShopType(ShopType shopType);

    void updateShopType(ShopType shopType);
}
