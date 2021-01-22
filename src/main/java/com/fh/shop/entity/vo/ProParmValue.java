package com.fh.shop.entity.vo;

import java.lang.reflect.Array;

public class ProParmValue {
    private Integer id;

    private String name;

    private String nameCH;

    private Integer typeId;

    private Integer type;

    private Integer isSku;

    private Integer IsDel;

    private Object values;

    private Object isCheck;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCH() {
        return nameCH;
    }

    public void setNameCH(String nameCH) {
        this.nameCH = nameCH;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsSku() {
        return isSku;
    }

    public void setIsSku(Integer isSku) {
        this.isSku = isSku;
    }

    public Integer getIsDel() {
        return IsDel;
    }

    public void setIsDel(Integer isDel) {
        IsDel = isDel;
    }

    public Object getValues() {
        return values;
    }

    public void setValues(Object values) {
        this.values = values;
    }

    public Object getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Object isCheck) {
        this.isCheck = isCheck;
    }
}
