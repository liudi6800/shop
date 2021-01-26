package com.fh.shop.entity.po;

public class ShopTypeData {
    private Integer id;

    private Integer shopId;

    private String attrData;

    private Integer storcks;

    private Double prices;
    public Integer getId() {
        return id;

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getAttrData() {
        return attrData;
    }

    public void setAttrData(String attrData) {
        this.attrData = attrData;
    }

    public Integer getStorcks() {
        return storcks;
    }

    public void setStorcks(Integer storcks) {
        this.storcks = storcks;
    }

    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }
}
