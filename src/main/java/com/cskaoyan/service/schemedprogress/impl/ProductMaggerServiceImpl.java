package com.cskaoyan.service.schemedprogress.impl;

import com.cskaoyan.bean.ProcessExample;
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

    @Override
    public Product getProductById(String id) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductIdEqualTo(id);
        List<Product> products = productMapper.selectByExample(productExample);
        Product product = products.get(0);
        return product;
    }

    @Override
    public int delete_batch(String[] ids) {
        int status = 1;
        for (String id : ids) {
            int delete = productMapper.deleteByPrimaryKey(id);
            if(delete == 0){
                status = 0;
            }
        }

        return status;
    }

    @Override
    public List<Product> search_custom_by_productId(String searchValue, String page, String rows) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductIdEqualTo(searchValue);
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<Product> products = productMapper.selectByExample(productExample);
        return products;
    }

    @Override
    public List<Product> search_product_by_productName(String searchValue, String page, String rows) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductNameEqualTo(searchValue);
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<Product> products = productMapper.selectByExample(productExample);
        return products;
    }

    @Override
    public List<Product> search_product_by_productType(String searchValue, String page, String rows) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductTypeEqualTo(searchValue);
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<Product> products = productMapper.selectByExample(productExample);
        return products;
    }

    @Override
    public int insert(Product product) {
        int insert = productMapper.insert(product);
        return insert;
    }

    @Override
    public int update(Product product) {
        int update = productMapper.updateByPrimaryKey(product);
        return update;
    }
}
