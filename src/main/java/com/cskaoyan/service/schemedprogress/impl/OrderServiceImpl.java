package com.cskaoyan.service.schemedprogress.impl;

import com.cskaoyan.bean.schemedprogress.OrderMangger;
import com.cskaoyan.bean.schemedprogress.OrderRow;
import com.cskaoyan.mapper.schemedprogress.OrderMapper;
import com.cskaoyan.service.schemedprogress.OrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public OrderMangger selectOrdersByPage(String page, String rows) {
        OrderMangger orderMangger = new OrderMangger();
        int count = orderMapper.OrdersCount();
        orderMangger.setTotal(count);
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<OrderRow> allOrders = orderMapper.findAllOrders();
        orderMangger.setRows(allOrders);
        return orderMangger;
    }
}
