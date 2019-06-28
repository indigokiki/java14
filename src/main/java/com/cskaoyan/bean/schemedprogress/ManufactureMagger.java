package com.cskaoyan.bean.schemedprogress;

import java.util.List;

public class ManufactureMagger {

    private int totll;

    private List<ManufactureRow> manufactureRows;

    public int getTotll() {
        return totll;
    }

    public void setTotll(int totll) {
        this.totll = totll;
    }

    public List<ManufactureRow> getManufactureRows() {
        return manufactureRows;
    }

    public void setManufactureRows(List<ManufactureRow> manufactureRows) {
        this.manufactureRows = manufactureRows;
    }

    @Override
    public String toString() {
        return "ManufactureMagger{" +
                "totll=" + totll +
                ", manufactureRows=" + manufactureRows +
                '}';
    }
}
