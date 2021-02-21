package com.fh.shop.dao;

import com.fh.shop.entity.po.Menu;
import com.fh.shop.entity.po.RoleMenu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserMenuDao {

    @Select("select * from u_menu")
    List<Menu> selectMenuData();

    @Insert("insert into u_menu (pid,name,url,type,isDel,createDate,author) value (#{pid},#{name},#{url},#{type},#{isDel},#{createDate},#{author})")
    void addMenu(Menu menu);


    @Update("update u_menu set name=#{name},url=#{url},type=#{type},isDel=#{isDel} where id=#{id}")
    void updateMenu(Menu menu);

    @Select("select * from u_menu where id=#{id}")
    Menu selectMenuDataById(Integer id);

    @Delete("delete from u_rolemenu where rid=#{rid}")
    void delUserRoleByRid(Integer rid);

    void addRoleMenu(List<RoleMenu> list);

    @Select("select * from u_rolemenu where rid=#{rid}")
    List<RoleMenu> selectRoleMenuDataByRid(Integer rid);
}
