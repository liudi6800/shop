package com.fh.shop.dao;

import com.fh.shop.entity.po.ProValue;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProValueDao {


    @Select({"select * from u_shop_provalue where proId=#{proId}"})
    List<ProValue> selectProValueByproId(Integer proId);


}
