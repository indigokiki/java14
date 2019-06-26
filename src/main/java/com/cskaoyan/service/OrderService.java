package com.cskaoyan.service;

import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.Page;



public interface OrderService {

    Page<Order> selectOrdersByPage(int pagenum, int rows);
}
