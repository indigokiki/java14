package com.cskaoyan.bean.schemedprogress;

import com.cskaoyan.bean.Task;

import java.util.List;

public class TaskMagger {

    private int total;

    private List<Task> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Task> getRows() {
        return rows;
    }

    public void setRows(List<Task> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "TaskMagger{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
