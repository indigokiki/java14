package com.cskaoyan.service.schemedprogress;

import com.cskaoyan.bean.schemedprogress.ProductMagger;

public interface ProductMaggerService {

    ProductMagger selectProducrsByPage(String page, String rows);
}
