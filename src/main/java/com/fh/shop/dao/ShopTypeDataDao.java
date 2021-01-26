package com.fh.shop.dao;

import com.fh.shop.entity.po.ShopTypeData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopTypeDataDao {


    @Insert("<script> " +
            "insert into s_shop_typedata (shopId,attrData,storcks,prices) " +
            "values <foreach  collection='list' item='a'  separator=','> " +
            "(#{a.shopId},#{a.attrData},#{a.storcks},#{a.prices})" +
            "</foreach></script>")
    void addShopTypeData(List<ShopTypeData> list);

    @Select("select * from s_shop_typedata where shopId=#{shopId}")
    List<ShopTypeData> selectTypeDataByShopId(Integer shopId);
}
