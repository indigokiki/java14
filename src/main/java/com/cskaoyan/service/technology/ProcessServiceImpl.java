package com.cskaoyan.service.technology;

import com.cskaoyan.bean.*;
import com.cskaoyan.bean.technology.Process;
import com.cskaoyan.bean.technology.ProcessExample;
import com.cskaoyan.mapper.technology.ProcessMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YangShuo
 * @date 2019-06-27 10:35
 */
@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    ProcessMapper processMapper;

    @Override
    public Page<Process> selectProcessPage(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Process> processes = processMapper.selectAll();
        Page<Process> processPage = new Page<>();
        processPage.setRows(processes);

        int count = (int) processMapper.countByExample(new ProcessExample());
        processPage.setTotal(count);
        return processPage;
    }

    @Override
    public int insertProcess(Process process) {
        int i = processMapper.insert(process);
        return i;
    }

    @Override
    public int updateProcess(Process process) {
        int i = processMapper.updateByPrimaryKey(process);
        return i;
    }

    @Override
    public int deleteProcess(String processId) {
        int i = processMapper.deleteByPrimaryKey(processId);
        return i;
    }

    @Override
    public Page<Process> searchProcessPageByVagueId(String vagueProcessId, int page, int rows) {
        ProcessExample processExample = new ProcessExample();
        ProcessExample.Criteria criteria = processExample.createCriteria();
        vagueProcessId = "%" + vagueProcessId + "%";
        criteria.andProcessIdLike(vagueProcessId);

        PageHelper.startPage(page,rows);
        List<Process> processList = processMapper.selectByExample(processExample);

        Page<Process> processPage = new Page<>();
        processPage.setRows(processList);

        int count = (int) processMapper.countByExample(processExample);
        processPage.setTotal(count);

        return processPage;
    }

    @Override
    public Page<Process> searchProcessPageByVaguePlanId(String vaguePlanId, int page, int rows) {
        ProcessExample processExample = new ProcessExample();
        ProcessExample.Criteria criteria = processExample.createCriteria();
        vaguePlanId = "%" + vaguePlanId + "%";
        criteria.andTechnologyPlanIdLike(vaguePlanId);

        PageHelper.startPage(page,rows);
        List<Process> processList = processMapper.selectByExample(processExample);

        Page<Process> processPage = new Page<>();
        processPage.setRows(processList);

        int count = (int) processMapper.countByExample(processExample);
        processPage.setTotal(count);

        return processPage;
    }


}
