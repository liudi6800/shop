package com.fh.shop.controller;

import com.fh.shop.entity.po.ShopType;
import com.fh.shop.entity.vo.ResponseData;
import com.fh.shop.service.ShopTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/type/")
public class ShopTypeController {


    @Autowired
    private ShopTypeService shopTypeService;

    @GetMapping("getData")
    public ResponseData getData(){

        List<ShopType> list=shopTypeService.selectShopType();

        return  ResponseData.success(list);
    }


    @GetMapping("getDataByPid")
    public ResponseData getDataByPid(Integer pid){

        if(pid==null){
            return ResponseData.error(400,"非法请求异常");
        }
        List<ShopType> list=shopTypeService.selectShopTypeByPid(pid);
        return  ResponseData.success(list);
    }


    @PostMapping("add")
    public ResponseData addShopType(ShopType shopType){
        if(shopType.getName()==null && shopType.getPid()==null){
            return ResponseData.error(400,"非法请求异常");
        }
        Integer id=shopTypeService.addShopType(shopType);
        return  ResponseData.success(id);
    }

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
