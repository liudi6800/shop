package com.fh.shop.dao;

import com.fh.shop.entity.po.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RoleDao {

    @Select("select * from u_role")
    public List<Role> queryRoleData();

    @Insert("insert into u_role(name,isDel,createDate,author) " +
            "value(#{name},#{isDel},#{createDate},#{author})")
    public void addRole(Role role);

    @Update("update u_role set name=#{name},author=#{author}  where id=#{id}")
    public void updateRole(Role role);

    @Update("update u_role set isDel=#{isDel} where id=#{id}")
    public void isDelRole(@Param("id")Integer id, @Param("isDel")Integer isDel);



}
