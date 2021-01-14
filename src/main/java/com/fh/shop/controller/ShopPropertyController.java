package com.fh.shop.controller;

import com.fh.shop.entity.po.ShopProperty;
import com.fh.shop.entity.vo.ResponseData;
import com.fh.shop.entity.vo.ShopPropertyParms;
import com.fh.shop.service.ShopPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("add")
    public ResponseData addShopProperty(ShopProperty shopProperty){
        shopPropertyService.addShopProperty(shopProperty);
        return ResponseData.success(null);
    }


    @PostMapping("update")
    public ResponseData updateShopProperty(ShopProperty shopProperty){
        if(shopProperty.getId()==null){
            return ResponseData.error(400,"非法请求");
        }
        shopPropertyService.updateShopProperty(shopProperty);
        return ResponseData.success(null);
    }




}
