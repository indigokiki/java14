package com.cskaoyan.bean.schemedprogress;

import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.technology.Process;
import com.cskaoyan.bean.Product;

public class WorkRow {


    private String  workId;

    private Process process;

    private String processNumber;

    private Device device;

    private Product product;

    private int rating;

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public String getProcessNumber() {
        return processNumber;
    }

    public void setProcessNumber(String processNumber) {
        this.processNumber = processNumber;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "WorkRow{" +
                "workid='" + workId + '\'' +
                ", process=" + process +
                ", processNumber='" + processNumber + '\'' +
                ", device=" + device +
                ", product=" + product +
                ", rating=" + rating +
                '}';
    }
}
