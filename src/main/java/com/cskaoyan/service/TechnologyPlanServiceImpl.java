package com.cskaoyan.service;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.bean.TechnologyPlanExample;
import com.cskaoyan.mapper.TechnologyPlanMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YangShuo
 * @date 2019-06-26 23:54
 */
@Service
public class TechnologyPlanServiceImpl implements TechnologyPlanService {

    @Autowired
    TechnologyPlanMapper planMapper;

    @Override
    public Page<TechnologyPlan> selectTechPlanPage(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<TechnologyPlan> technologyPlans = planMapper.selectAll();
        Page<TechnologyPlan> technologyPlanPage = new Page<>();
        technologyPlanPage.setRows(technologyPlans);
        technologyPlanPage.setTotal(technologyPlans.size());
        return technologyPlanPage;
    }

    @Override
    public TechnologyPlan selectTechPlanById(String technologyPlanId) {
        TechnologyPlan technologyPlan = planMapper.selectByPrimaryKey(technologyPlanId);
        return technologyPlan;
    }
}
