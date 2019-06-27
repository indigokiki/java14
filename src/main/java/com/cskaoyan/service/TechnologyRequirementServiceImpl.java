package com.cskaoyan.service;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.bean.TechnologyRequirementExample;
import com.cskaoyan.mapper.TechnologyRequirementMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YangShuo
 * @date 2019-06-26 23:02
 */
@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {

    @Autowired
    TechnologyRequirementMapper requirementMapper;

    @Override
    public List<TechnologyRequirement> selectTechReqs() {
        TechnologyRequirementExample example = new TechnologyRequirementExample();
        List<TechnologyRequirement> technologyRequirements = requirementMapper.selectByExample(example);
        return technologyRequirements;
    }

    @Override
    public Page<TechnologyRequirement> selectTechReqPage(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<TechnologyRequirement> technologyRequirements = requirementMapper.selectAll();
        Page<TechnologyRequirement> techReqPage = new Page<>();
        techReqPage.setRows(technologyRequirements);
        techReqPage.setTotal(technologyRequirements.size());
        return techReqPage;
    }
}
