package com.fh.shop.controller;

import com.fh.shop.entity.po.Role;
import com.fh.shop.entity.vo.ResponseData;
import com.fh.shop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/role/")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /*
     *
     *
     * 接口   http://localhost:8083/api/role/selectRole
     *
     *
     *
     * */
    @GetMapping("selectRole")
    public ResponseData selectRole(){
        List<Role> list=roleService.selectRole();
        return ResponseData.success(list);
    }
    /*
     *
     *
     * 接口   http://192.168.1.224:8083/api/role/addRole
     *
     *
     *
     * */
    @PostMapping("addRole")
    public ResponseData addRole(Role role){
        roleService.addRole(role);
        return ResponseData.success("");
    }
    /*
     *
     *
     * 接口   http://192.168.1.224:8083/api/role/updateRole
     *
     *
     *
     * */
    @PostMapping("updateRole")
    public ResponseData updateRole(Role role){
        roleService.updateRole(role);
        return ResponseData.success("");
    }

    /*
     *
     *
     * 接口   http://192.168.1.224:8083/api/role/delRole
     *
     *
     *
     * */
    @DeleteMapping("delRole")
    public ResponseData delRole(Integer id, Integer isDel){
        roleService.delRole(id,isDel);
        return ResponseData.success("");
    }
}
