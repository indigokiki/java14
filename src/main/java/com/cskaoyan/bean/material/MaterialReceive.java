package com.cskaoyan.bean.material;

import java.sql.Timestamp;
import java.util.Date;

public class MaterialReceive {
    private String receiveId;

    private String materialId;

  /*  private Material material;*/

    private Integer amount;

    private Timestamp receiveDate;

    private String sender;

    private String receiver;

    private String note;


    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId == null ? null : receiveId.trim();
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Timestamp getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Timestamp receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }



    public MaterialReceive() {
    }

    public MaterialReceive(String receiveId, String note) {
        this.receiveId = receiveId;
        this.note = note;
    }

    public MaterialReceive(String receiveId, String materialId, Integer amount, Timestamp receiveDate, String sender, String receiver, String note) {
        this.receiveId = receiveId;
        this.materialId = materialId;
        this.amount = amount;
        this.receiveDate = receiveDate;
        this.sender = sender;
        this.receiver = receiver;
        this.note = note;
    }
}