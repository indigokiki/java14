package com.cskaoyan.bean.schemedprogress;

import com.cskaoyan.bean.Technology;

public class ManufactureRow {

    private String manufactureSn;

    private Order cOrder;

    private Technology technology;

    private int launchQuantity;

    private String beginDate;

    private String endDate;

    public String getManufactureSn() {
        return manufactureSn;
    }

    public void setManufactureSn(String manufactureSn) {
        this.manufactureSn = manufactureSn;
    }

    public Order getcOrder() {
        return cOrder;
    }

    public void setcOrder(Order cOrder) {
        this.cOrder = cOrder;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    public int getLaunchQuantity() {
        return launchQuantity;
    }

    public void setLaunchQuantity(int launchQuantity) {
        this.launchQuantity = launchQuantity;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
