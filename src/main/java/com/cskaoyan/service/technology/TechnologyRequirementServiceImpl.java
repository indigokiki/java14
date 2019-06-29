package com.cskaoyan.service.technology;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.technology.TechnologyRequirement;
import com.cskaoyan.bean.technology.TechnologyRequirementExample;
import com.cskaoyan.mapper.technology.TechnologyRequirementMapper;
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

    @Autowired
    TechnologyService technologyService;

    @Override
    public List<TechnologyRequirement> selectTechReqs() {
        List<TechnologyRequirement> technologyRequirements = requirementMapper.selectAllWithTechnologyName();
        return technologyRequirements;
    }

    @Override
    public Page<TechnologyRequirement> selectTechReqPage(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<TechnologyRequirement> technologyRequirements = requirementMapper.selectAllWithTechnologyName();
        Page<TechnologyRequirement> techReqPage = new Page<>();
        techReqPage.setRows(technologyRequirements);

        int count = (int) requirementMapper.countByExample(new TechnologyRequirementExample());

        techReqPage.setTotal(count);
        return techReqPage;
    }



    //工艺要求编号搜索：模糊查询
    @Override
    public Page<TechnologyRequirement> searchTechReqPageByVagueId(String vagueRequirementId, int page, int rows) {
        TechnologyRequirementExample requirementExample = new TechnologyRequirementExample();
        TechnologyRequirementExample.Criteria criteria = requirementExample.createCriteria();

        vagueRequirementId = "%" + vagueRequirementId + "%";
        criteria.andTechnologyRequirementIdLike(vagueRequirementId);

        PageHelper.startPage(page,rows);
        List<TechnologyRequirement> requirementList = requirementMapper.selectByExample(requirementExample);

        for (TechnologyRequirement technologyRequirement : requirementList){
            String technologyName = technologyService.selectTechnologyNameById(technologyRequirement.getTechnologyId());
            technologyRequirement.setTechnologyName(technologyName);
        }


        Page<TechnologyRequirement> requirementPage = new Page<>();
        requirementPage.setRows(requirementList);

        int count = (int) requirementMapper.countByExample(requirementExample);
        requirementPage.setTotal(count);

        return requirementPage;

    }

    //工艺名称搜索：模糊查询
    @Override
    public Page<TechnologyRequirement> searchTechReqPageByVagueTechnologyName(String vagueTechnologyName, int page, int rows) {
        //用technologyName在technology表里查technologyId,再用technologyId在requirement表里查technologyRequirement
        //一个technologyId对应多个requirement
        List<String> technologyIds = technologyService.selectTechnologyIdByVagueName(vagueTechnologyName);

        PageHelper.startPage(page,rows);
        List<TechnologyRequirement> requirementList = requirementMapper.selectByTechnologyIds(technologyIds);

        Page<TechnologyRequirement> requirementPage = new Page<TechnologyRequirement>();
        requirementPage.setRows(requirementList);

        int count = requirementMapper.selectByTechnologyIds(technologyIds).size();
        requirementPage.setTotal(count);

        return requirementPage;
    }

    @Override
    public int insertRequirement(TechnologyRequirement requirement) {
        int i = requirementMapper.insert(requirement);
        return i;
    }

    @Override
    public int updateRequirement(TechnologyRequirement requirement) {
        int i = requirementMapper.updateByPrimaryKey(requirement);
        return i;
    }

    @Override
    public int deleteRequirementById(String technologyRequirementId) {
        int i = requirementMapper.deleteByPrimaryKey(technologyRequirementId);
        return i;
    }

    @Override
    public int updateRequirementOnlyById(String technologyRequirementId, String requirement) {
        TechnologyRequirement technologyRequirement = requirementMapper.selectByPrimaryKey(technologyRequirementId);
        technologyRequirement.setRequirement(requirement);
        int i = requirementMapper.updateByPrimaryKey(technologyRequirement);
        return i;
    }
}
