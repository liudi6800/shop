package com.fh.shop.controller;

import com.fh.shop.entity.po.User;
import com.fh.shop.entity.vo.ResponseData;
import com.fh.shop.entity.vo.ShopBrandParms;
import com.fh.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/user/")
public class UserController {


    @Autowired
    private UserService userService;


    /*
     *
     *
     * 接口   http://192.168.1.224:8083/api/user/getData
     *
     * 参数  page当前页数  limit条数  必传
     *
     * */
    @GetMapping("getData")
    public ResponseData getData(ShopBrandParms parms){
        if(parms.getPage()==null){
            return ResponseData.error(400,"非法请求");
        }
        if(parms.getLimit()==null){
            return ResponseData.error(400,"非法请求");
        }
        Map map=userService.getData(parms);
        return ResponseData.success(map);
    }


    /*
     *
     *
     * 接口   http://192.168.1.224:8083/api/user/updateUser
     *
     * 参数  page当前页数  limit条数  必传
     *
     * */
    @PostMapping("updateUser")
    public ResponseData getData(User user){
          userService.updateUser(user);
        return ResponseData.success(null);
    }
}
