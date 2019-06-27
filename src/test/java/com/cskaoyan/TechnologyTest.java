package com.cskaoyan;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.TechnologyMapper;
import com.cskaoyan.mapper.TechnologyRequirementMapper;
import com.cskaoyan.service.TechnologyPlanService;
import com.cskaoyan.service.TechnologyService;
import com.cskaoyan.service.TechnologyServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author YangShuo
 * @date 2019-06-26 20:21
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class TechnologyTest {

    @Autowired
    TechnologyService technologyService;

    @Autowired
    TechnologyMapper technologyMapper;

    @Test
    public void techTest1(){
        Technology technology = technologyService.selectTechnologyById("001");
        System.out.println("technology = " + technology);
    }

    @Test
    public void techTest2(){
        TechnologyExample technologyExample = new TechnologyExample();
        //TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        List<Technology> technologies = technologyMapper.selectByExample(technologyExample);
        System.out.println("technologies = " + technologies);
    }

    @Test
    public void techTest3(){
        Page<Technology> technologyPage = technologyService.selectTechnologyPage(1, 30);
        System.out.println("technologyPage = " + technologyPage);

    }

    @Autowired
    TechnologyPlanService technologyPlanService;

    @Test
    public void techPTest(){
        Page<TechnologyPlan> technologyPlanPage = technologyPlanService.selectTechPlanPage(1, 30);
        System.out.println("technologyPlanPage = " + technologyPlanPage);
    }

    @Test
    public void techTest4(){
        Page<Technology> page = technologyService.searchTechPageByVagueName("打磨", 1, 30);
        System.out.println("page = " + page);
    }

    @Test
    public void techMapTest(){
        String[] id = technologyMapper.selectTechnologyIdByName("抛光");
        System.out.println("id = " + id);
    }

    @Autowired
    TechnologyRequirementMapper requirementMapper;
    @Test
    public void techRMapTest(){
        List<TechnologyRequirement> requirementList = requirementMapper.selectTechReqByTechnologyId("001");
        System.out.println("requirementList = " + requirementList);

    }

    @Test
    public void techRMapTest2(){
        List<TechnologyRequirement> requirementList = requirementMapper.selectAllWithTechnologyName();
        System.out.println("requirementList = " + requirementList);

    }

}

