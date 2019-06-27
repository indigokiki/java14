/*
package com.cskaoyan;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyExample;
import com.cskaoyan.mapper.TechnologyMapper;
import com.cskaoyan.service.TechnologyService;
import com.cskaoyan.service.TechnologyServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

*/
/**
 * @author YangShuo
 * @date 2019-06-26 20:21
 *//*

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
}
*/
