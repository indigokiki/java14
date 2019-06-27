package com.cskaoyan.bean.material;

import java.util.Date;

/**
 * @Author IL-M
 * @Date:2019/6/27 15:12
 */
public class MaterialReceives {
    private String receiveId;

    private String materialId;

    private Material material;

    private int amount;

    private Date receiveDate;

    private String sender;

    private String receiver;

    private String note;

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "MaterialReceives{" +
                "receiveId='" + receiveId + '\'' +
                ", materialId='" + materialId + '\'' +
                ", material=" + material +
                ", amount=" + amount +
                ", receiveDate=" + receiveDate +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
