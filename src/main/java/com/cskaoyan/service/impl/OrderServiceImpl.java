package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.Page;
import com.cskaoyan.mapper.OrderMapper;
import com.cskaoyan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public Page<Order> selectOrdersByPage(int pagenum, int rows) {
        Page<Order> page = new Page<>();
        page.setPageSize(rows);
        page.setTotalRecordsNum(orderMapper.OrdersCount());
        page.setCurrentPageNum(pagenum);
        page.setTotalPageNum(page.getTotalRecordsNum() % rows == 0 ? page.getTotalRecordsNum() / rows : page.getTotalRecordsNum() / rows + 1);
        page.setList(orderMapper.findAllOrders(rows, (pagenum - 1) * rows));
        page.setNextPageNum(pagenum + 1);
        page.setPrevPageNum(pagenum - 1);
        return page;
    }
}
