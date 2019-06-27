package com.cskaoyan.bean.devman;

import java.util.List;

public class DeviceManager {
    private Integer total;
    private List<Device> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Device> getRows() {
        return rows;
    }

    public void setRows(List<Device> rows) {
        this.rows = rows;
    }
}
