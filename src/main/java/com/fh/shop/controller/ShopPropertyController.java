package com.fh.shop.controller;

import com.fh.shop.entity.po.ShopProperty;
import com.fh.shop.entity.vo.ResponseData;
import com.fh.shop.entity.vo.ShopPropertyParms;
import com.fh.shop.service.ShopPropertyService;
import com.fh.shop.utils.FileText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/property/")
public class ShopPropertyController {

    @Autowired
    private ShopPropertyService shopPropertyService;
        /*
        * 接口   http://192.168.1.224:8083/api/property/getData
        *
        * 参数  page当前页数  limit条数  必传
        *
        * */
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

    /*
     * 接口   http://192.168.1.224:8083/api/property/add
     *
     * 参数   详情看ShopProperty封装类
     *
     * */
    @PostMapping("add")
    public ResponseData addShopProperty(ShopProperty shopProperty){
        shopPropertyService.addShopProperty(shopProperty);
        return ResponseData.success(null);
    }

    /*
     * 接口   http://192.168.1.224:8083/api/property/update
     *
     * 参数   详情看ShopProperty封装类   id必传
     *
     * */
    @PostMapping("update")
    public ResponseData updateShopProperty(ShopProperty shopProperty){
        if(shopProperty.getId()==null){
            return ResponseData.error(400,"非法请求");
        }
        shopPropertyService.updateShopProperty(shopProperty);
        return ResponseData.success(null);
    }

    /*
     * 接口   http://192.168.1.224:8083/api/property/delete
     *
     * 参数    id必传
     *
     * */
    @DeleteMapping("delete")
    public ResponseData deleteShopPropertyById(Integer  id,Integer isDel){
        if(id==null){
            return ResponseData.error(400,"非法请求");
        }
        shopPropertyService.deleteShopPropertyById(id,isDel);
        return ResponseData.success(null);
    }



}
