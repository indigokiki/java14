package com.cskaoyan.service.technology;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.technology.TechnologyRequirement;

import java.util.List;

/**
 * @author YangShuo
 * @date 2019-06-26 23:00
 */
/*工艺监控二、工艺要求*/
public interface TechnologyRequirementService {

    List<TechnologyRequirement> selectTechReqs();

    Page<TechnologyRequirement> selectTechReqPage(int page, int rows);

    Page<TechnologyRequirement> searchTechReqPageByVagueId(String vagueRequirementId,int page, int rows);

    Page<TechnologyRequirement> searchTechReqPageByVagueTechnologyName(String vagueTechnologyName, int page, int rows);

    //插入功能
    int insertRequirement(TechnologyRequirement requirement);

    //修改功能
    int updateRequirement(TechnologyRequirement requirement);

    //删除功能
    int deleteRequirementById(String technologyRequirementId);

    //只修改requrirement成员变量的功能
    int updateRequirementOnlyById(String technologyRequirementId, String requirement);

}
