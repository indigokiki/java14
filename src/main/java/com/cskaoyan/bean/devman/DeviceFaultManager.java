package com.cskaoyan.bean.devman;

import java.util.List;

public class DeviceFaultManager {
    private Integer total;
    private List<DeviceFault> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<DeviceFault> getRows() {
        return rows;
    }

    public void setRows(List<DeviceFault> rows) {
        this.rows = rows;
    }
}
