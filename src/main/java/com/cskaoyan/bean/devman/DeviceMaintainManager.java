package com.cskaoyan.bean.devman;

import java.util.List;

public class DeviceMaintainManager {
    private Integer total;

    private List<DeviceMaintain> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<DeviceMaintain> getRows() {
        return rows;
    }

    public void setRows(List<DeviceMaintain> rows) {
        this.rows = rows;
    }
}
