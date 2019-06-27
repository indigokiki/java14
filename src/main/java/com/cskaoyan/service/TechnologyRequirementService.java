package com.cskaoyan.service;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.TechnologyRequirement;

import java.util.List;

/**
 * @author YangShuo
 * @date 2019-06-26 23:00
 */
/*工艺监控二、工艺要求*/
public interface TechnologyRequirementService {

    List<TechnologyRequirement> selectTechReqs();

    Page<TechnologyRequirement> selectTechReqPage(int page, int rows);

    Page<TechnologyRequirement> searchTechReqPageById(String technologyRequirementId);

    Page<TechnologyRequirement> searchTechReqPageByTechnologyName(String technologyName, int page, int rows);

}
