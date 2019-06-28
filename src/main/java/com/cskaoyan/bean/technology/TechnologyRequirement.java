package com.cskaoyan.bean.technology;

import java.sql.Timestamp;
import java.util.Date;

public class TechnologyRequirement {
    private String technologyRequirementId;

    private String technologyId;

    private String requirement;

    private Timestamp addTime;

    private Timestamp reviseTime;

    //增加一个成员变量technologyName,用于对应的jsp
    private String technologyName;

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    public String getTechnologyRequirementId() {
        return technologyRequirementId;
    }

    public void setTechnologyRequirementId(String technologyRequirementId) {
        this.technologyRequirementId = technologyRequirementId == null ? null : technologyRequirementId.trim();
    }

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId == null ? null : technologyId.trim();
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement == null ? null : requirement.trim();
    }

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public Timestamp getReviseTime() {
        return reviseTime;
    }

    public void setReviseTime(Timestamp reviseTime) {
        this.reviseTime = reviseTime;
    }
}