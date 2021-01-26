package com.fh.shop.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fh.shop.dao.ProValueDao;
import com.fh.shop.dao.ShopDao;
import com.fh.shop.dao.ShopPropertyDao;
import com.fh.shop.dao.ShopTypeDataDao;
import com.fh.shop.entity.po.ProValue;
import com.fh.shop.entity.po.Shop;
import com.fh.shop.entity.po.ShopTypeData;
import com.fh.shop.entity.vo.ProParmValue;
import com.fh.shop.entity.vo.ShopParms;
import com.fh.shop.service.ShopService;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopDao shopDao;

    @Resource
    private ShopTypeDataDao shopTypeDataDao;

    @Resource
    private ShopPropertyDao shopPropertyDao;

    @Resource
    private ProValueDao proValueDao;


    public ShopServiceImpl() {
    }

    @Override
    public Map selectShop(ShopParms parms) {
        Map map=new HashMap();
        Long aLong = shopDao.selectShopCount(parms);
        parms.setStartIndex((parms.getPage()-1)*parms.getLimit());
        List<Shop> shops = shopDao.selectShopData(parms);
        map.put("count",aLong);
        map.put("data",shops);
        return map;
    }

    @Override
    @Transactional
    public void addShop(Shop shop, String proData, String skuData) {
        Date now=new Date();
        shop.setCreateDate(now);
        shop.setUpdateDate(now);
        shopDao.addShop(shop);
        List<ShopTypeData> list=new ArrayList<>();

        JSONArray objects = JSONObject.parseArray(proData);
        for (int i = 0; i <objects.size() ; i++) {
            ShopTypeData std=new ShopTypeData();
            std.setShopId(shop.getId());
            std.setAttrData(objects.get(i).toString());
            list.add(std);
        }

        JSONArray obSku = JSONObject.parseArray(skuData);
        for (int i = 0; i <obSku.size() ; i++) {
             JSONObject o= (JSONObject) obSku.get(i);
             ShopTypeData sh=new ShopTypeData();
             sh.setPrices(o.getDouble("prices"));
             sh.setStorcks(o.getInteger("storcks"));
             sh.setShopId(shop.getId());
             o.remove("prices");
             o.remove("storcks");
             sh.setAttrData(obSku.get(i).toString());
            list.add(sh);
        }

        shopTypeDataDao.addShopTypeData(list);

    }

    @Override
    public void updateShop(Shop shop) {
        Date now=new Date();
        shop.setUpdateDate(now);
        shopDao.updataShop(shop);
    }

    @Override
    public void delShop(Integer isDel, Integer id) {
        Map map=new HashMap();
        map.put("isDel",isDel);
        map.put("id",id);
        shopDao.delShop(map);

    }



}
