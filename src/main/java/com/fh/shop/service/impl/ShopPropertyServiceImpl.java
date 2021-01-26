package com.fh.shop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fh.shop.dao.ProValueDao;
import com.fh.shop.dao.ShopPropertyDao;
import com.fh.shop.dao.ShopTypeDataDao;
import com.fh.shop.entity.po.ProValue;
import com.fh.shop.entity.po.ShopProperty;
import com.fh.shop.entity.po.ShopTypeData;
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

    @Resource
    private ShopTypeDataDao shopTypeDataDao;
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

        return shopPropertyDao.getAllData();
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

    @Override
    public Map selectShopProByproId(Integer proId) {
        Map data=new HashMap();
        List<ShopTypeData> productAttrDatas = shopTypeDataDao.selectTypeDataByShopId(proId);
        Map skuData=new HashMap();
        Map attrData=new HashMap();
        List <JSONObject> tableList=new ArrayList<>();
        //遍历所有数据
        for (int i = 0; i <productAttrDatas.size() ; i++) {
            //得到具体的一个属性数据
            ShopTypeData shopTypeData = productAttrDatas.get(i);
            //判断此属性为那种属性
            if(shopTypeData.getPrices()!=null){ //是sku属性   这种判断不严谨
                //得到对应数据的json字符串 {"memsize":"32G","pricess":111,"color":"红色","netType":"联通","storcks":111}
                //得到对应数据的json字符串 {"memsize":"32G","pricess":111,"color":"红色","netType":"联通","storcks":111}
                //将字符串转为json对象  引入fastjson工具类
                JSONObject jsonObject = JSONObject.parseObject(shopTypeData.getAttrData());
                //遍历jsonobject
                Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
                for (Map.Entry<String, Object> entry : entries) {
                    String key=entry.getKey();//color
                    //判断skuData中是否有此属性
                    Set values = (Set) skuData.get(key);
                    if(values!=null){
                        values.add(entry.getValue());
                    }else{
                        //创建一个set 集合
                        Set valuesSet =new HashSet();
                        valuesSet.add(entry.getValue());
                        skuData.put(key,valuesSet);
                    }
                }
                //表格属性放入list
                tableList.add(jsonObject);

            }else {
                //得到对应数据的json字符串  {"factory":"苹果尝试"}
                JSONObject obj=JSONObject.parseObject(shopTypeData.getAttrData());
                Set<Map.Entry<String, Object>> entries = obj.entrySet();
                for (Map.Entry<String, Object> entry : entries) {
                    attrData.put(entry.getKey(),entry.getValue());
                }
            }


        }
        //将sku 和attr 放入返回值中
        data.put("skudata",skuData);
        data.put("attrdata",attrData);
        data.put("tableData",tableList);
        return data;
    }


}
