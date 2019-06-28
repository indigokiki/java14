package com.cskaoyan.service.technology;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.technology.Technology;

import java.util.List;

/**
 * @author YangShuo
 * @date 2019-06-26 20:18
 */
/*工艺监控一、工艺管理*/
public interface TechnologyService {

    Technology selectTechnologyById(String technologyId);

    List<Technology> selectTechnologys();

    String selectTechnologyNameById(String technologyId);

    Page<Technology> selectTechnologyPage(int page, int rows);

    Page<Technology> searchTechPageByVagueId(String vagueTechnologyId, int page, int rows);

    Page<Technology> searchTechPageByVagueName(String vagueTechnologyName, int page, int rows);

    //工艺管理-插入功能
    int insertTechnology(Technology technology);

    //工艺管理-修改功能
    int updateTechnology(Technology technology);

    //工艺管理-删除功能
    int deleteTechnologyById(String technologyId);

    //二、工艺计划搜索使用
    List<String> selectTechnologyIdByVagueName(String vagueTechnologyName);



}
