package com.fh.shop.service.impl;

import com.fh.shop.dao.ProValueDao;
import com.fh.shop.dao.ShopPropertyDao;
import com.fh.shop.entity.po.ProValue;
import com.fh.shop.entity.po.ShopProperty;
import com.fh.shop.entity.vo.ProParmValue;
import com.fh.shop.entity.vo.ShopPropertyParms;
import com.fh.shop.service.ShopPropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.*;

@Service
public class ShopPropertyServiceImpl implements ShopPropertyService {

    @Resource
    private ShopPropertyDao shopPropertyDao;

    @Resource
    private ProValueDao proValueDao;
    @Override
    public Map selectShopPropertyByParma(ShopPropertyParms parms) {
        Map map=new HashMap();
        Integer count = shopPropertyDao.selectShopPropertyCount(parms);
        parms.setStartIndex((parms.getPage()-1)*parms.getLimit());
        List<ShopProperty> shopProperties = shopPropertyDao.selectShopPropertyData(parms);
        map.put("count",count);
        map.put("data",shopProperties);
        return map;
    }

    @Override
    public void addShopProperty(ShopProperty shopProperty) {
        shopProperty.setIsDel(0);
        shopProperty.setCreateDate(new Date());
        shopPropertyDao.addShopProperty(shopProperty);
    }

    @Override
    public void updateShopProperty(ShopProperty shopProperty) {
        shopProperty.setUpdateDate(new Date());
        shopPropertyDao.updateShopProperty(shopProperty);
    }

    @Override
    public void deleteShopPropertyById(Integer id, Integer isDel) {
        Map map=new HashMap();
        map.put("id",id);
        map.put("isDel",isDel);
        shopPropertyDao.deleteShopPropertyById(map);
    }

    @Override
    public List<ShopProperty> getAllData() {
        ;
        return shopPropertyDao.getAllData();
    }

    @Override
    public List<ShopProperty> selectShopProByTypeId(Integer typeId) {
        return shopPropertyDao.selectShopProByTypeId(typeId);
    }

    @Override
    public Map selectShopProDataByTypeId(Integer typeId) {

        Map map=new HashMap();

        List<ProParmValue> list=shopPropertyDao.selectShopProIsSku(typeId);
        for (int i = 0; i <list.size() ; i++) {
            List<ProValue> proValues = proValueDao.selectProValueDataByproId(list.get(i).getId());
            list.get(i).setValues(proValues);
            List list3=new ArrayList();
            list.get(i).setIsCheck(list3);
        }

        List<ProParmValue> list2=shopPropertyDao.selectShopProNoIsSku(typeId);

        for (ProParmValue proParmValue : list2) {
            List<ProValue> proValues = proValueDao.selectProValueDataByproId(proParmValue.getId());
            proParmValue.setValues(proValues);
            List list4=new ArrayList();
            proParmValue.setIsCheck(list4);
        }


        map.put("skuDatas",list);
        map.put("noSkuData",list2);
        return map;
    }


}
