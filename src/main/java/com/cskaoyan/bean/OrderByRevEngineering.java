package com.cskaoyan.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class OrderByRevEngineering {
    private String orderId;

    private String customId;

    private String productId;

    private Timestamp orderDate;

    private Timestamp requestDate;

    private String note;

    private Integer quantity;

    private BigDecimal unitPrice;

    private String unit;

    private String image;

    private String file;

    private Integer status;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Timestamp getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Timestamp requestDate) {
        this.requestDate = requestDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderByRevEngineering{" +
                "orderId='" + orderId + '\'' +
                ", customId='" + customId + '\'' +
                ", productId='" + productId + '\'' +
                ", orderDate=" + orderDate +
                ", requestDate=" + requestDate +
                ", note='" + note + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", unit='" + unit + '\'' +
                ", image='" + image + '\'' +
                ", file='" + file + '\'' +
                ", status=" + status +
                '}';
    }
}