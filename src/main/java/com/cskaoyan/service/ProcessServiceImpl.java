package com.cskaoyan.service;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.Process;
import com.cskaoyan.mapper.ProcessMapper;
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
        processPage.setTotal(processes.size());
        return processPage;
    }
}
