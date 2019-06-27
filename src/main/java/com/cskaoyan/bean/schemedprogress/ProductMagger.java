package com.cskaoyan.bean.schemedprogress;

import com.cskaoyan.bean.Product;

import java.util.List;

public class ProductMagger {

    private int total;

    private List<Product> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Product> getRows() {
        return rows;
    }

    public void setRows(List<Product> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "ProductMagger{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
