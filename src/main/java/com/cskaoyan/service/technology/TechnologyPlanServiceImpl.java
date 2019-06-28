package com.cskaoyan.service.technology;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.technology.TechnologyPlan;
import com.cskaoyan.bean.technology.TechnologyPlanExample;
import com.cskaoyan.mapper.technology.TechnologyPlanMapper;
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

    @Autowired
    TechnologyService technologyService;

    @Override
    public Page<TechnologyPlan> selectTechPlanPage(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<TechnologyPlan> technologyPlans = planMapper.selectAllWithTechnologyName();
        Page<TechnologyPlan> technologyPlanPage = new Page<>();
        technologyPlanPage.setRows(technologyPlans);


        int count = (int) planMapper.countByExample(new TechnologyPlanExample());
        technologyPlanPage.setTotal(count);
        return technologyPlanPage;
    }

    @Override
    public TechnologyPlan selectTechPlanById(String technologyPlanId) {
        TechnologyPlan technologyPlan = planMapper.selectByPrimaryKey(technologyPlanId);
        return technologyPlan;
    }

    @Override
    public int insertPlan(TechnologyPlan technologyPlan) {
        int i = planMapper.insert(technologyPlan);
        return i;
    }

    @Override
    public int updatePlan(TechnologyPlan technologyPlan) {
        int i = planMapper.updateByPrimaryKey(technologyPlan);
        return i;
    }

    @Override
    public int deletePlan(String technologyPlanId) {
        int i = planMapper.deleteByPrimaryKey(technologyPlanId);
        return i;
    }

    @Override
    public Page<TechnologyPlan> searchPlanPageByVagueId(String vaguePlanId, int page, int rows) {
        TechnologyPlanExample planExample = new TechnologyPlanExample();
        TechnologyPlanExample.Criteria criteria = planExample.createCriteria();

        vaguePlanId = "%" + vaguePlanId + "%";
        criteria.andTechnologyPlanIdLike(vaguePlanId);

        PageHelper.startPage(page,rows);
        List<TechnologyPlan> planList = planMapper.selectByExample(planExample);

        for (TechnologyPlan technologyPlan : planList){
            String technologyName = technologyService.selectTechnologyNameById(technologyPlan.getTechnologyId());
            technologyPlan.setTechnologyName(technologyName);
        }

        Page<TechnologyPlan> planPage = new Page<>();
        planPage.setRows(planList);


        int count = (int) planMapper.countByExample(planExample);
        planPage.setTotal(count);
        return planPage;
    }

    @Override
    public Page<TechnologyPlan> searchTechReqPageByVagueTechnologyName(String vagueTechnologyName, int page, int rows) {
        List<String> technologyIds = technologyService.selectTechnologyIdByVagueName(vagueTechnologyName);

        PageHelper.startPage(page,rows);
        List<TechnologyPlan> planList = planMapper.selectByTechnologyIds(technologyIds);

        Page<TechnologyPlan> planPage = new Page<TechnologyPlan>();
        planPage.setRows(planList);

        int count = planMapper.selectByTechnologyIds(technologyIds).size();
        planPage.setTotal(count);

        return planPage;
    }
}
