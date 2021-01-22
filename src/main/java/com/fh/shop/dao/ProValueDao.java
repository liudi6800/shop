package com.fh.shop.dao;

import com.fh.shop.entity.po.ProValue;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProValueDao {


    @Select({"select * from u_shop_provalue where proId=#{proId}"})
    List<ProValue> selectProValueByproId(Integer proId);


    @Insert("insert into u_shop_provalue (name,nameCH,proId)" +
            "value (#{name},#{nameCH},#{proId})")
    void addProValue(ProValue proValue);


    @Update("update u_shop_provalue set name=#{name} where id=#{id}")
    void updateProValue(ProValue proValue);

    void delProValue(Integer id);

    @Select("select * from u_shop_provalue where proId=#{id}")
    List<ProValue> selectProValueDataByproId(Integer id);
}
