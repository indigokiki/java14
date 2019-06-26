package com.cskaoyan.bean;

import java.math.BigDecimal;

public class Order {

    private String order_id;

    private String custom_id;

    private String product_name;

    private int quantity;

    private BigDecimal unit_price;

    private String unit;

    private int status;

    private String order_date;

    private String request_date;

    private String file;

    private String image;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getCustom_id() {
        return custom_id;
    }

    public void setCustom_id(String custom_id) {
        this.custom_id = custom_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getRequest_date() {
        return request_date;
    }

    public void setRequest_date(String request_date) {
        this.request_date = request_date;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", custom_id='" + custom_id + '\'' +
                ", product_name='" + product_name + '\'' +
                ", quantity=" + quantity +
                ", unit_price=" + unit_price +
                ", unit='" + unit + '\'' +
                ", status=" + status +
                ", order_date='" + order_date + '\'' +
                ", request_date='" + request_date + '\'' +
                ", file='" + file + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
