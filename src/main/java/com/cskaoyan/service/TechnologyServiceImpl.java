package com.cskaoyan.service;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyExample;
import com.cskaoyan.mapper.TechnologyMapper;
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
}
