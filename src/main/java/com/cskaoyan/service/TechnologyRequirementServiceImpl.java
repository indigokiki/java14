package com.cskaoyan.service;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.bean.TechnologyRequirementExample;
import com.cskaoyan.mapper.TechnologyMapper;
import com.cskaoyan.mapper.TechnologyRequirementMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangShuo
 * @date 2019-06-26 23:02
 */
@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {

    @Autowired
    TechnologyRequirementMapper requirementMapper;

    @Autowired
    TechnologyMapper technologyMapper;

    @Override
    public List<TechnologyRequirement> selectTechReqs() {
        TechnologyRequirementExample example = new TechnologyRequirementExample();
        List<TechnologyRequirement> technologyRequirements = requirementMapper.selectByExample(example);
        return technologyRequirements;
    }

    @Override
    public Page<TechnologyRequirement> selectTechReqPage(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<TechnologyRequirement> technologyRequirements = requirementMapper.selectAllWithTechnologyName();
        Page<TechnologyRequirement> techReqPage = new Page<>();
        techReqPage.setRows(technologyRequirements);
        techReqPage.setTotal(technologyRequirements.size());
        return techReqPage;
    }

    //工艺要求编号搜索：精确查询
    @Override
    public Page<TechnologyRequirement> searchTechReqPageById(String technologyRequirementId) {
        TechnologyRequirement technologyRequirement = requirementMapper.selectByPrimaryKey(technologyRequirementId);
        List<TechnologyRequirement> requirementList = new ArrayList<>();
        requirementList.add(technologyRequirement);

        Page<TechnologyRequirement> requirementPage = new Page<>();
        requirementPage.setTotal(requirementList.size());
        requirementPage.setRows(requirementList);
        return requirementPage;

    }

    @Override
    public Page<TechnologyRequirement> searchTechReqPageByTechnologyName(String technologyName, int page, int rows) {
        //用technologyName在technology表里查technologyId,再用technologyId在requirement表里查technologyRequirement
        String[] technologyIds = technologyMapper.selectTechnologyIdByName(technologyName);



        return null;
    }
}
