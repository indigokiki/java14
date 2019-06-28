package com.cskaoyan.bean.technology;


import java.sql.Timestamp;

public class TechnologyPlan {
    private String technologyPlanId;

    private String technologyId;

    private Integer batchAmount;

    private Timestamp startPlan;

    private Timestamp endPlan;

    private Timestamp commitPlan;

    private Timestamp technologyPlanStart;

    private Timestamp technologyPlanEnd;

    //增加一个成员变量technologyName,用于对应的jsp
    private String technologyName;

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }


    public String getTechnologyPlanId() {
        return technologyPlanId;
    }

    public void setTechnologyPlanId(String technologyPlanId) {
        this.technologyPlanId = technologyPlanId == null ? null : technologyPlanId.trim();
    }

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId == null ? null : technologyId.trim();
    }

    public Integer getBatchAmount() {
        return batchAmount;
    }

    public void setBatchAmount(Integer batchAmount) {
        this.batchAmount = batchAmount;
    }

    public Timestamp getStartPlan() {
        return startPlan;
    }

    public void setStartPlan(Timestamp startPlan) {
        this.startPlan = startPlan;
    }

    public Timestamp getEndPlan() {
        return endPlan;
    }

    public void setEndPlan(Timestamp endPlan) {
        this.endPlan = endPlan;
    }

    public Timestamp getCommitPlan() {
        return commitPlan;
    }

    public void setCommitPlan(Timestamp commitPlan) {
        this.commitPlan = commitPlan;
    }

    public Timestamp getTechnologyPlanStart() {
        return technologyPlanStart;
    }

    public void setTechnologyPlanStart(Timestamp technologyPlanStart) {
        this.technologyPlanStart = technologyPlanStart;
    }

    public Timestamp getTechnologyPlanEnd() {
        return technologyPlanEnd;
    }

    public void setTechnologyPlanEnd(Timestamp technologyPlanEnd) {
        this.technologyPlanEnd = technologyPlanEnd;
    }
}