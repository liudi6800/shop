package com.fh.shop.dao;

import com.fh.shop.entity.po.User;
import com.fh.shop.entity.vo.ShopBrandParms;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {

    Integer selectUserCount(ShopBrandParms parms);

    List<User> selectUserData(ShopBrandParms parms);

    @Update("update u_user set realName=#{realName},sex=#{sex},phone=#{phone},email=#{email},idCard=#{idCard},birthday=#{birthday},imgUrl=#{imgUrl},eduId=#{eduId},deptId=#{deptId} " +
            "where id=#{id} ")
    void updateUser(User user);
}
