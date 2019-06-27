package com.cskaoyan.service;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyExample;
import com.cskaoyan.mapper.TechnologyMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangShuo
 * @date 2019-06-26 20:20
 */
@Service
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    TechnologyMapper technologyMapper;

    @Override
    public Technology selectTechnologyById(String technologyId) {
        Technology technology = technologyMapper.selectByPrimaryKey(technologyId);
        return technology;
    }

    @Override
    public List<Technology> selectTechnologys() {
        TechnologyExample technologyExample = new TechnologyExample();
        List<Technology> technologyList = technologyMapper.selectByExample(technologyExample);
        return technologyList;
    }

    @Override
    public Page<Technology> selectTechnologyPage(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Technology> technologyList = technologyMapper.selectAll();
        Page<Technology> techPage = new Page<>();
        techPage.setRows(technologyList);
        techPage.setTotal(technologyList.size());

        return techPage;
    }

    //工艺编号搜索做精确查询：虽然是分页，但technologyId是主键，只能查出来1或0个结果。
    @Override
    public Page<Technology> searchTechPageById(String technologyId) {
        Technology technology = technologyMapper.selectByPrimaryKey(technologyId);
        List<Technology> technologyList = new ArrayList<>();
        technologyList.add(technology);

        Page<Technology> technologyPage = new Page<>();
        technologyPage.setTotal(technologyList.size());
        technologyPage.setRows(technologyList);
        return technologyPage;
    }

    //工艺名称搜索做模糊查询
    @Override
    public Page<Technology> searchTechPageByVagueName(String vagueTechnologyName, int page, int rows) {
        TechnologyExample technologyExample = new TechnologyExample();
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        vagueTechnologyName = "%" + vagueTechnologyName + "%";
        criteria.andTechnologyNameLike(vagueTechnologyName);

        PageHelper.startPage(page,rows);
        List<Technology> technologyList = technologyMapper.selectByExample(technologyExample);

        Page<Technology> technologyPage = new Page<>();
        technologyPage.setTotal(technologyList.size());
        technologyPage.setRows(technologyList);
        return technologyPage;
    }

    @Override
    public int insertTechnology(Technology technology) {
        int insert = technologyMapper.insert(technology);
        return insert;
    }


}
