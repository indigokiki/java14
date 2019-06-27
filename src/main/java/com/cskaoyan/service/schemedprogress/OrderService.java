package com.cskaoyan.service.schemedprogress;

import com.cskaoyan.bean.schemedprogress.OrderMangger;

import java.util.List;


public interface OrderService {

    OrderMangger selectOrdersByPage(String page, String rows);
}
