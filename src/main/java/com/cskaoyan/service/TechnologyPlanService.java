package com.cskaoyan.service;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.TechnologyPlan;

/**
 * @author YangShuo
 * @date 2019-06-26 23:24
 */
/*工艺监控三、*/
public interface TechnologyPlanService {

    Page<TechnologyPlan> selectTechPlanPage(int page, int rows);

    //用于工序管理（第四项）
    TechnologyPlan selectTechPlanById(String technologyPlanId);
}
