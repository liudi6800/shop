package com.fh.shop.dao;

import com.fh.shop.entity.po.Menu;
import com.fh.shop.entity.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserLoginDao {
    @Select("select * from u_user where name=#{name}")
    User selectUserByName(String name);

    @Insert("insert into u_user(name,password,realName,sex,phone,email,idCard,birthday,imgUrl,eduId,deptId,createDate,updateDate) " +
            "value(#{name},#{password},#{realName},#{sex},#{phone},#{email},#{idCard},#{birthday},#{imgUrl},#{eduId},#{deptId},#{createDate},#{updateDate})")
    void addUser(User user);

    @Select("SELECT DISTINCT d.* FROM  u_userrole b  LEFT JOIN u_rolemenu c ON b.rid = c.rid LEFT JOIN u_menu d ON c.mid=d.id  WHERE b.uid=#{id}  and d.id is not null")
    List<Menu> selectUserMeunData(Integer id);
}
