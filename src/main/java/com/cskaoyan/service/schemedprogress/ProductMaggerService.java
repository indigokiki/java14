package com.cskaoyan.service.schemedprogress;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.Product;
import com.cskaoyan.bean.schemedprogress.ProductMagger;

import java.util.List;

public interface ProductMaggerService {

    ProductMagger selectProducrsByPage(String page, String rows);

    Product getProductById(String id);

    int delete_batch(String[] ids);

    List<Product> search_custom_by_productId(String searchValue, String page, String rows);

    List<Product> search_product_by_productName(String searchValue, String page, String rows);

    List<Product> search_product_by_productType(String searchValue, String page, String rows);

    int insert(Product product);

    int update(Product product);
}
