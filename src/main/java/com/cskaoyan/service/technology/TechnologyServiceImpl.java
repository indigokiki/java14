package com.cskaoyan.service.technology;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.technology.Technology;
import com.cskaoyan.bean.technology.TechnologyExample;
import com.cskaoyan.mapper.technology.TechnologyMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangShuo
 * @date 2019-06-26 20:20
 */
@Service
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    TechnologyMapper technologyMapper;

    @Override
    public Technology selectTechnologyById(String technologyId) {
        Technology technology = technologyMapper.selectByPrimaryKey(technologyId);
        return technology;
    }

    @Override
    public List<Technology> selectTechnologys() {
        TechnologyExample technologyExample = new TechnologyExample();
        List<Technology> technologyList = technologyMapper.selectByExample(technologyExample);
        return technologyList;
    }

    @Override
    public String selectTechnologyNameById(String technologyId) {
        String technologyName = technologyMapper.selectTechnologyNameById(technologyId);
        return technologyName;
    }

    @Override
    public Page<Technology> selectTechnologyPage(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Technology> technologyList = technologyMapper.selectAll();
        Page<Technology> techPage = new Page<>();
        techPage.setRows(technologyList);

        int count = (int) technologyMapper.countByExample(new TechnologyExample());
        techPage.setTotal(count);

        return techPage;
    }

    //工艺编号搜索做模糊查询
    @Override
    public Page<Technology> searchTechPageByVagueId(String vagueTechnologyId, int page, int rows) {
        TechnologyExample technologyExample = new TechnologyExample();
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        vagueTechnologyId = "%" + vagueTechnologyId + "%";
        criteria.andTechnologyIdLike(vagueTechnologyId);

        PageHelper.startPage(page,rows);
        List<Technology> technologyList = technologyMapper.selectByExample(technologyExample);

        Page<Technology> technologyPage = new Page<>();
        technologyPage.setRows(technologyList);

        int count = (int) technologyMapper.countByExample(technologyExample);
        technologyPage.setTotal(count);

        return technologyPage;
    }

    //工艺名称搜索做模糊查询
    @Override
    public Page<Technology> searchTechPageByVagueName(String vagueTechnologyName, int page, int rows) {
        TechnologyExample technologyExample = new TechnologyExample();
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        vagueTechnologyName = "%" + vagueTechnologyName + "%";
        criteria.andTechnologyNameLike(vagueTechnologyName);

        PageHelper.startPage(page,rows);
        List<Technology> technologyList = technologyMapper.selectByExample(technologyExample);

        Page<Technology> technologyPage = new Page<>();
        technologyPage.setRows(technologyList);

        int count = (int) technologyMapper.countByExample(technologyExample);
        technologyPage.setTotal(count);

        return technologyPage;
    }

    @Override
    public int insertTechnology(Technology technology) {
        int insert = technologyMapper.insert(technology);
        return insert;
    }

    @Override
    public int updateTechnology(Technology technology) {
        int i = technologyMapper.updateByPrimaryKey(technology);
        return i;
    }

    @Override
    public int deleteTechnologyById(String technologyId) {
        int i = technologyMapper.deleteByPrimaryKey(technologyId);
        return i;
    }

    @Override
    public List<String> selectTechnologyIdByVagueName(String vagueTechnologyName) {
        vagueTechnologyName = "%" + vagueTechnologyName + "%";
        TechnologyExample technologyExample = new TechnologyExample();
        TechnologyExample.Criteria criteria = technologyExample.createCriteria();
        criteria.andTechnologyNameLike(vagueTechnologyName);

        List<Technology> technologyList = technologyMapper.selectByExample(technologyExample);
        List<String> technologyIds = new ArrayList<>();
        for (Technology technology : technologyList){
            technologyIds.add(technology.getTechnologyId());
        }

        return technologyIds;
    }


}
