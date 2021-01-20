package com.fh.shop.dao;

import com.fh.shop.entity.po.Shop;
import com.fh.shop.entity.vo.ShopParms;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface ShopDao {

    public Long selectShopCount(ShopParms parms);

    public List<Shop> selectShopData(ShopParms parms);

    @Insert("insert into s_shop (name,title,bandId,productdecs,imgPath,price,stocks,sortNum,createDate,updateDate,author,isDel)" +
            " value(#{name},#{title},#{bandId},#{productdecs},#{imgPath},#{price},#{stocks},#{sortNum},#{createDate},#{updateDate},#{author},#{isDel})")
    public void addShop(Shop shop);

    @Update("update s_shop set name=#{name},title=#{title},bandId=#{bandId},productdecs=#{productdecs},imgPath=#{imgPath},price=#{price},stocks=#{stocks},sortNum=#{sortNum},createDate=#{createDate},updateDate=#{updateDate},author=#{author},isDel=#{isDel}" +
            "  where id=#{id}")
    public void updataShop(Shop shop);
    @Update("update s_shop set isDel=#{isDel}  where id=#{id}")
    public void delShop(Map map);

}
