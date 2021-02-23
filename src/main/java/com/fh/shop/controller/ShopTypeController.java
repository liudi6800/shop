package com.fh.shop.controller;

import com.fh.shop.entity.po.ShopType;
import com.fh.shop.entity.vo.ResponseData;
import com.fh.shop.service.ShopTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/type/")
public class ShopTypeController {


    @Autowired
    private ShopTypeService shopTypeService;
    /*
     * 接口    http://192.168.1.224:8083/api/type/getData
     *
     * 参数  null
     *
     * 返回值 List集合
     * */
    @GetMapping("getData")
    public ResponseData getData(){

        List<ShopType> list=shopTypeService.selectShopType();

        return  ResponseData.success(list);
    }

    /*
     * 接口    http://192.168.1.224:8083/api/type/getDataByPid
     *
     * 参数  pid 必传
     *
     * 返回值 List集合
     * */
    @GetMapping("getDataByPid")
    public ResponseData getDataByPid(Integer pid){

        if(pid==null){
            return ResponseData.error(400,"非法请求异常");
        }
        List<ShopType> list=shopTypeService.selectShopTypeByPid(pid);
        return  ResponseData.success(list);
    }

    /*
     * 接口    http://192.168.1.224:8083/api/type/add
     *
     * 参数  详情看ShopType类 必传
     *
     * 返回值 null
     * */
    @PostMapping("add")
    public ResponseData addShopType(ShopType shopType){
        if(shopType.getName()==null && shopType.getPid()==null){
            return ResponseData.error(400,"非法请求异常");
        }
        Integer id=shopTypeService.addShopType(shopType);
        return  ResponseData.success(id);
    }
    /*
     * 接口    http://192.168.1.224:8083/api/type/update
     *
     * 参数  详情看ShopType类 必传
     *
     * 返回值 null
     * */
    @PostMapping("update")
    public ResponseData updateShopType(ShopType shopType){
        if(shopType.getId()==null){
            return ResponseData.error(400,"非法请求异常");
        }

        if(shopType==null){
            return ResponseData.error(400,"非法请求异常");
        }
         shopTypeService.updateShopType(shopType);
        return  ResponseData.success("");
    }




}
