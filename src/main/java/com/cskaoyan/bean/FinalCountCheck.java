package com.cskaoyan.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class FinalCountCheck {
    private String fCountCheckId;

    private String orderId;

    private String checkItem;

    private Integer sample;

    private Integer checkNumber;

    private Integer unqualify;

    private BigDecimal qualify;

    private Timestamp cdate;

    private String measureData;

    private String empId;

    private String result;

    private String note;

    private String empName;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getfCountCheckId() {
        return fCountCheckId;
    }

    public void setfCountCheckId(String fCountCheckId) {
        this.fCountCheckId = fCountCheckId == null ? null : fCountCheckId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getCheckItem() {
        return checkItem;
    }

    public void setCheckItem(String checkItem) {
        this.checkItem = checkItem == null ? null : checkItem.trim();
    }

    public Integer getSample() {
        return sample;
    }

    public void setSample(Integer sample) {
        this.sample = sample;
    }

    public Integer getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(Integer checkNumber) {
        this.checkNumber = checkNumber;
    }

    public Integer getUnqualify() {
        return unqualify;
    }

    public void setUnqualify(Integer unqualify) {
        this.unqualify = unqualify;
    }

    public BigDecimal getQualify() {
        return qualify;
    }

    public void setQualify(BigDecimal qualify) {
        this.qualify = qualify;
    }

    public Timestamp getCdate() {
        return cdate;
    }

    public void setCdate(Timestamp cdate) {
        this.cdate = cdate;
    }

    public String getMeasureData() {
        return measureData;
    }

    public void setMeasureData(String measureData) {
        this.measureData = measureData == null ? null : measureData.trim();
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}