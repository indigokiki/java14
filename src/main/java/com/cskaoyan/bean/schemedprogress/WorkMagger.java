package com.cskaoyan.bean.schemedprogress;

import com.cskaoyan.bean.Work;

import java.util.List;

public class WorkMagger {

    private int total;

    private List<WorkRow> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<WorkRow> getRows() {
        return rows;
    }

    public void setRows(List<WorkRow> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "WorkMagger{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
