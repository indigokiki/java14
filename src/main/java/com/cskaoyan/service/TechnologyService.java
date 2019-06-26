package com.cskaoyan.service;

import com.cskaoyan.bean.Technology;

import java.util.List;

/**
 * @author YangShuo
 * @date 2019-06-26 20:18
 */
/*工艺监控一、工艺管理*/
public interface TechnologyService {

    Technology selectTechnologyById(String technologyId);

    List<Technology> selectTechnologys();
}
