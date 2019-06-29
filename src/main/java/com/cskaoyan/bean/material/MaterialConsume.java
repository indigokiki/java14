package com.cskaoyan.bean.material;

import java.sql.Timestamp;
import java.util.Date;

public class MaterialConsume {
    private String consumeId;

    private String workId;

    private String materialId;

    private Integer consumeAmount;

    private Timestamp consumeDate;

    private String sender;

    private String receiver;

    private String note;

    public MaterialConsume() {
    }

    public MaterialConsume(String consumeId, String note) {
        this.consumeId = consumeId;
        this.note = note;
    }

    public String getConsumeId() {
        return consumeId;
    }

    public void setConsumeId(String consumeId) {
        this.consumeId = consumeId == null ? null : consumeId.trim();
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    public Integer getConsumeAmount() {
        return consumeAmount;
    }

    public void setConsumeAmount(Integer consumeAmount) {
        this.consumeAmount = consumeAmount;
    }

    public Timestamp getConsumeDate() {
        return consumeDate;
    }

    public void setConsumeDate(Timestamp consumeDate) {
        this.consumeDate = consumeDate;
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
}