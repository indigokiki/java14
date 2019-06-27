package com.cskaoyan.bean.material;

import com.cskaoyan.bean.Work;

import java.util.Date;

/**
 * @Author IL-M
 * @Date:2019/6/27 17:16
 */
public class MaterialConsumes {
    private String consumeId;

    private Material material;

    private Work work;

    private String workId;

    private String materialId;

    private Integer consumeAmount;

    private Date consumeDate;

    private String sender;

    private String receiver;

    private String note;

    public String getConsumeId() {
        return consumeId;
    }

    public void setConsumeId(String consumeId) {
        this.consumeId = consumeId;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public Integer getConsumeAmount() {
        return consumeAmount;
    }

    public void setConsumeAmount(Integer consumeAmount) {
        this.consumeAmount = consumeAmount;
    }

    public Date getConsumeDate() {
        return consumeDate;
    }

    public void setConsumeDate(Date consumeDate) {
        this.consumeDate = consumeDate;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "MaterialConsumes{" +
                "consumeId='" + consumeId + '\'' +
                ", material=" + material +
                ", work=" + work +
                ", workId='" + workId + '\'' +
                ", materialId='" + materialId + '\'' +
                ", consumeAmount=" + consumeAmount +
                ", consumeDate=" + consumeDate +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
