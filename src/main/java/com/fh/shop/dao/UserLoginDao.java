package com.fh.shop.dao;

import com.fh.shop.entity.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserLoginDao {
    @Select("select * from u_user where name=#{name}")
    User selectUserByName(String name);

    @Insert("insert into u_user(name,password,realName,sex,phone,email,idCard,birthday,imgUrl,eduId,deptId,createDate,updateDate) " +
            "value(#{name},#{password},#{realName},#{sex},#{phone},#{email},#{idCard},#{birthday},#{imgUrl},#{eduId},#{deptId},#{createDate},#{updateDate})")
    void addUser(User user);
}
