package com.fh.shop.controller;

import com.fh.shop.entity.po.Shop;
import com.fh.shop.entity.po.ShopTypeData;
import com.fh.shop.entity.vo.ResponseData;
import com.fh.shop.entity.vo.ShopParms;
import com.fh.shop.service.ShopService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/shop/")
public class ShopController {

    @Autowired
    private ShopService shopService;
    /*
    *
    *http://localhost:8083/api/shop/selectShop  路径
    *
    * get 请求
    *
    * page  当前页  limit  每页条数   这两个必填项
    *
    *
    * */
    @GetMapping("selectShop")
    public ResponseData selectShop(ShopParms  parms){
        if(parms.getPage()==null){
            return ResponseData.error(400,"非法请求");
        }
        if(parms.getLimit()==null){
            return ResponseData.error(400,"非法请求");
        }

        Map map=shopService.selectShop(parms);
        return ResponseData.success(map);
    }






    /*
     *
     *   http://localhost:8083/api/shop/addShop  路径
     *
     * post 请求
     *    前台表单验证  名称  标题  图片 必填项
     *
     *
     * */
    @PostMapping("addShop")
    public ResponseData addShop(Shop  shop,String proData ,String skuData){
         shopService.addShop(shop,proData,skuData);
        return ResponseData.success("");
    }

    /*
     *
     *http://localhost:8083/api/shop/updateShop  路径
     *
     * post 请求
     *
     *      id 必填 必填项
     *
     *
     * */
    @PostMapping("updateShop")
    public ResponseData updateShop(Shop  shop){
        shopService.updateShop(shop);
        return ResponseData.success("");
    }

    /*
     *
     *http://localhost:8083/api/shop/delShop  路径
     *
     * get 请求
     *
     *  假删除  相当于上下架  前台给个开关最好
     *  相当于展示
     *
     * */
    @DeleteMapping("delShop")
    public ResponseData delShop(Integer isDel,Integer id){
        shopService.delShop(isDel,id);
        return ResponseData.success("");
    }




}
