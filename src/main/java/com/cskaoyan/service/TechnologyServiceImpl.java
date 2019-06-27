package com.cskaoyan.service;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyExample;
import com.cskaoyan.mapper.TechnologyMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
