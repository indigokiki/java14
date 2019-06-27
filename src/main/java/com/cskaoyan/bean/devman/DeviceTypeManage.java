package com.cskaoyan.bean.devman;

import java.util.List;

public class DeviceTypeManage {
    private Integer total;
    private List<DeviceType> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<DeviceType> getRows() {
        return rows;
    }

    public void setRows(List<DeviceType> rows) {
        this.rows = rows;
    }
}
