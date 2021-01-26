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

        List<ProParmValue> attrs=shopPropertyDao.selectShopProData(typeId);

        List<Object> skuDats=new ArrayList<>();
        //声明attrDatas
        List<Object> attrDatas=new ArrayList<>();
        //遍历所有的属性数据
        for (int i = 0; i <attrs.size() ; i++) {
            //得到具体的一个属性
            ProParmValue proParmValue = attrs.get(i);
            //判断此属性是否为sku
            if(proParmValue.getIsSku()==0){
                //判断此属性的类型   如果是input 没有values
                if(proParmValue.getType()!=3){
                    //查询此属性 对应的选项值
                    List<ProValue> proValues = proValueDao.selectProValueDataByproId(proParmValue.getId());
                    proParmValue.setValues(proValues);
                }
                skuDats.add(proParmValue);
            }else{//是sku数据
                //判断此属性的类型   如果是input 没有values
                if(proParmValue.getType()!=3){
                    //查询此属性 对应的选项值
                    List<ProValue> proValues = proValueDao.selectProValueDataByproId(proParmValue.getId());
                    proParmValue.setValues(proValues);
                }
                attrDatas.add(proParmValue);
            }
        }

        map.put("skuDatas",skuDats);
        map.put("noSkuData",attrDatas);
        return map;
    }


}
