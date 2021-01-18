package com.fh.shop.service.impl;


import com.fh.shop.dao.ShopBrandDao;
import com.fh.shop.entity.po.ShopBrand;

import com.fh.shop.entity.vo.ShopBrandParms;
import com.fh.shop.service.ShopBrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ShopBrandServiceImpl implements ShopBrandService {

    @Resource
    private ShopBrandDao  shopBrandDao;



    @Override
    public Map getData(ShopBrandParms parms) {
        Map map=new HashMap();
        Integer integer = shopBrandDao.selectShopBrandCount(parms);
        parms.setStartIndex((parms.getPage()-1)*parms.getLimit());
        List<ShopBrand> shopBrands = shopBrandDao.selectShopBrandData(parms);
        map.put("count",integer);
        map.put("data",shopBrands);
        return map;
    }

    @Override
    public List<ShopBrand> getAllBandData() {
        return shopBrandDao.getAllBandData();
    }


    @Override
    public void addShopBrand(ShopBrand shopBrand) {
        shopBrand.setCreateDate(new Date());
        shopBrandDao.addShopBrand(shopBrand);
    }

    @Override
    public void updateShopBrand(ShopBrand shopBrand) {
        shopBrand.setUpdateDate(new Date());
        shopBrandDao.updateShopBrand(shopBrand);
    }



}
