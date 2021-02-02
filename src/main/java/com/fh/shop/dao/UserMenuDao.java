package com.fh.shop.dao;

import com.fh.shop.entity.po.Menu;
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
}
