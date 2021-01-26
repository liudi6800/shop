package com.fh.shop.dao;

import com.fh.shop.entity.po.ShopProperty;
import com.fh.shop.entity.vo.ProParmValue;
import com.fh.shop.entity.vo.ShopPropertyParms;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface ShopPropertyDao {

    public Integer  selectShopPropertyCount(ShopPropertyParms parms);

    public List<ShopProperty> selectShopPropertyData(ShopPropertyParms parms);


    void addShopProperty(ShopProperty shopProperty);

    void updateShopProperty(ShopProperty shopProperty);

    @Update("update s_shop_property set isDel=#{isDel}  where id=#{id}")
    void deleteShopPropertyById(Map map);

    @Select("select * from s_shop_property")
    List<ShopProperty> getAllData();

    @Select("select * from s_shop_property where typeId=#{typeId}  and  isDel=0")
    List<ShopProperty> selectShopProByTypeId(Integer typeId);


    @Select("select * from s_shop_property where typeId=#{typeId}")
    List<ProParmValue> selectShopProData(Integer typeId);

}
