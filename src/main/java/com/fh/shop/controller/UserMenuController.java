package com.fh.shop.controller;

import com.fh.shop.entity.po.Menu;
import com.fh.shop.entity.po.RoleMenu;
import com.fh.shop.entity.vo.ResponseData;
import com.fh.shop.service.UserMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/menu/")
public class UserMenuController {
    @Autowired
    private UserMenuService  userMenuService;


    /*查询权限表所有数据
     * 请求路径 http://localhost:8083/api/menu/selectMenuData
     * 返回值   {code:200,message:"处理成功",data:UserRole的List集合}
     * */
    @GetMapping("selectMenuData")
    public ResponseData selectMenuData(){
        List<Menu> list=userMenuService.selectMenuData();
        return ResponseData.success(list);
    }

    /*新增权限表数据
     * 请求路径 http://localhost:8083/api/menu/addMenu
     * 返回值   {code:200,message:"处理成功",data:null}
     * */
    @PostMapping("addMenu")
    public ResponseData addMenu(Menu menu){
        userMenuService.addMenu(menu);
        return ResponseData.success(null);
    }

    /*修改权限表数据
     * 请求路径 http://localhost:8083/api/menu/selectMenuDataById
     * 返回值   {code:200,message:"处理成功",data:menu}
     * */
    @GetMapping("selectMenuDataById")
    public ResponseData selectMenuDataById(Integer  id){
        Menu menu=userMenuService.selectMenuDataById(id);
        return ResponseData.success(menu);
    }

    /*修改权限表数据
     * 请求路径 http://localhost:8083/api/menu/updateMenu
     * 返回值   {code:200,message:"处理成功",data:null}
     * */
    @PostMapping("updateMenu")
    public ResponseData updateMenu(Menu menu){
        userMenuService.updateMenu(menu);
        return ResponseData.success(null);
    }

    /*角色赋权限
     * 请求路径 http://localhost:8083/api/menu/addRoleMenu
     * 返回值   {code:200,message:"处理成功",data:null}
     * */
    @PostMapping("addRoleMenu")
    public ResponseData addRoleMenu(Integer  rid,String  menus){
        userMenuService.addRoleMenu(rid,menus);
        return ResponseData.success(null);
    }

    /*角色赋权限
     * 请求路径 http://localhost:8083/api/menu/selectRoleMenuDataByRid
     * 返回值   {code:200,message:"处理成功",data:null}
     * */
    @GetMapping("selectRoleMenuDataByRid")
    public ResponseData selectRoleMenuDataByRid(Integer  rid){
       List<RoleMenu> list=userMenuService.selectRoleMenuDataByRid(rid);
        return ResponseData.success(list);
    }





}
