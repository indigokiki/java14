package com.cskaoyan.bean.devman;

import java.util.List;

public class DeviceCheckManager {
    private Integer total;

    private List<DeviceCheck> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<DeviceCheck> getRows() {
        return rows;
    }

    public void setRows(List<DeviceCheck> rows) {
        this.rows = rows;
    }
}
