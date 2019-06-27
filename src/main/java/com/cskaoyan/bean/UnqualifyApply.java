package com.cskaoyan.bean;




import java.sql.Timestamp;

public class UnqualifyApply {

    private Timestamp applyDate;
    private Timestamp assemblyDate;
    private String empId;
    private String empName;
    private String note;
    private String productId;
    private String productName;
    private String unqualifyApplyId;
    private int unqualifyCount;
    private String unqualifyItem;


    public Timestamp getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Timestamp applyDate) {
        this.applyDate = applyDate;
    }

    public Timestamp getAssemblyDate() {
        return assemblyDate;
    }

    public void setAssemblyDate(Timestamp assemblyDate) {
        this.assemblyDate = assemblyDate;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnqualifyApplyId() {
        return unqualifyApplyId;
    }

    public void setUnqualifyApplyId(String unqualifyApplyId) {
        this.unqualifyApplyId = unqualifyApplyId;
    }

    public int getUnqualifyCount() {
        return unqualifyCount;
    }

    public void setUnqualifyCount(int unqualifyCount) {
        this.unqualifyCount = unqualifyCount;
    }

    public String getUnqualifyItem() {
        return unqualifyItem;
    }

    public void setUnqualifyItem(String unqualifyItem) {
        this.unqualifyItem = unqualifyItem;
    }
}
