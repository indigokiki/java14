package com.cskaoyan.service.schemedprogress.impl;

import com.cskaoyan.bean.Product;
import com.cskaoyan.bean.ProductExample;
import com.cskaoyan.bean.schemedprogress.ProductMagger;
import com.cskaoyan.mapper.ProductMapper;
import com.cskaoyan.service.schemedprogress.ProductMaggerService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMaggerServiceImpl implements ProductMaggerService {

    @Autowired
    ProductMapper productMapper;
    @Override
    public ProductMagger selectProducrsByPage(String page, String rows) {
        ProductExample productExample = new ProductExample();
        int l = (int) productMapper.countByExample(productExample);
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<Product> products = productMapper.selectByExample(productExample);
        ProductMagger productMagger = new ProductMagger();
        productMagger.setTotal(l);
        productMagger.setRows(products);
        return productMagger;
    }
}
