package com.cskaoyan.bean.schemedprogress;

import com.cskaoyan.bean.Custom;

import java.util.List;

public class CustomMagger {

    private int total;

    private List<Custom> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Custom> getRows() {
        return rows;
    }

    public void setRows(List<Custom> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "CustomMagger{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
