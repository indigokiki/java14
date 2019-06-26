package com.cskaoyan.service;

import com.cskaoyan.bean.TechnologyRequirement;

import java.util.List;

/**
 * @author YangShuo
 * @date 2019-06-26 23:00
 */
/*工艺监控二、工艺要求*/
public interface TechnologyRequirementService {

    List<TechnologyRequirement> selectTechReqs();
}
