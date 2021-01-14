package com.fh.shop.controller;

import com.fh.shop.entity.vo.ResponseData;
import com.fh.shop.entity.vo.ShopPropertyParms;
import com.fh.shop.service.ShopPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/property/")
public class ShopPropertyController {

    @Autowired
    private ShopPropertyService shopPropertyService;

    @GetMapping("getData")
    public ResponseData selectShopPropertyByParma(ShopPropertyParms parms){
        if(parms.getPage()==null){
            return  ResponseData.error(400,"非法请求");
        }
        if(parms.getLimit()==null){
            return  ResponseData.error(400,"非法请求");
        }
        Map map= shopPropertyService.selectShopPropertyByParma(parms);
        return ResponseData.success(map);
    }



}
