package com.cskaoyan.service.technology;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.technology.TechnologyPlan;

/**
 * @author YangShuo
 * @date 2019-06-26 23:24
 */
/*工艺监控三、工艺计划*/
public interface TechnologyPlanService {

    Page<TechnologyPlan> selectTechPlanPage(int page, int rows);

    //用于工序管理（第四项）
    TechnologyPlan selectTechPlanById(String technologyPlanId);

    //插入功能
    int insertPlan(TechnologyPlan technologyPlan);

    //修改功能
    int updatePlan(TechnologyPlan technologyPlan);

    //删除功能
    int deletePlan(String technologyPlanId);

    //工艺计划编号搜索，模糊搜索
    Page<TechnologyPlan> searchPlanPageByVagueId(String vaguePlanId, int page, int rows);

    //工艺名称查询
    Page<TechnologyPlan> searchTechReqPageByVagueTechnologyName(String vagueTechnologyName, int page, int rows);
}
