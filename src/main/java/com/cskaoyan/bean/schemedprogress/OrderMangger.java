package com.cskaoyan.bean.schemedprogress;

import java.math.BigDecimal;
import java.util.List;

public class OrderMangger {

    private int total;

    private List<OrderRow> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<OrderRow> getRows() {
        return rows;
    }

    public void setRows(List<OrderRow> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "OrderMangger{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
