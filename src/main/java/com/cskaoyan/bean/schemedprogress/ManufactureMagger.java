package com.cskaoyan.bean.schemedprogress;

import java.util.List;

public class ManufactureMagger {

    private int total;

    private List<ManufactureRow> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int totll) {
        this.total = totll;
    }

    public List<ManufactureRow> getRows() {
        return rows;
    }

    public void setRows(List<ManufactureRow> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "ManufactureMagger{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
