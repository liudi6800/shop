package com.fh.shop.controller;

import com.fh.shop.entity.po.Menu;
import com.fh.shop.entity.po.User;
import com.fh.shop.entity.vo.ResponseData;
import com.fh.shop.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/userLogin/")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @PostMapping("addUser")
    public ResponseData addUser(User user){
        Map map=userLoginService.addUser(user);
        return ResponseData.success(map);
    }


    @PostMapping("toLoginUser")
    public ResponseData toLoginUser(String name,String password){
        Map map=userLoginService.toLoginUser(name,password);
        return ResponseData.success(map);
    }

    @GetMapping("selectUserMeunData")
    public ResponseData selectUserMeunData(String name){
        List<Menu> list=userLoginService.selectUserMeunData(name);
        return ResponseData.success(list);
    }






}
