package com.cskaoyan.service.schemedprogress.impl;

import com.cskaoyan.bean.Task;
import com.cskaoyan.bean.TaskExample;
import com.cskaoyan.bean.schemedprogress.TaskMagger;
import com.cskaoyan.mapper.TaskMapper;
import com.cskaoyan.service.schemedprogress.TaskService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskMapper taskMapper;

    @Override
    public TaskMagger getTaskByPage(String page, String rows) {
        TaskExample taskExample = new TaskExample();
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        int count = (int) taskMapper.countByExample(taskExample);
        TaskMagger taskMagger = new TaskMagger();
        taskMagger.setTotal(count);
        taskMagger.setRows(tasks);
        return taskMagger;
    }

    @Override
    public int insert(Task task) {
        int insert = taskMapper.insert(task);
        return insert;
    }

    @Override
    public int update(Task task) {
        int update = taskMapper.updateByPrimaryKey(task);
        return update;
    }

    @Override
    public int delete(String[] ids) {
        int status = 1;
        for (String id : ids) {
            int delete = taskMapper.deleteByPrimaryKey(id);
            if(delete == 0){
                status = 0;
            }
        }

        return status;
    }

    @Override
    public TaskMagger search_task_by_taskId(String searchValue, String page, String rows) {
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        criteria.andTaskIdEqualTo(searchValue);
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        int count = (int) taskMapper.countByExample(taskExample);
        TaskMagger taskMagger = new TaskMagger();
        taskMagger.setTotal(count);
        taskMagger.setRows(tasks);
        return taskMagger;
    }

    @Override
    public TaskMagger search_task_by_taskWorkId(String searchValue, String page, String rows) {
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        criteria.andWorkIdEqualTo(searchValue);
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        int count = (int) taskMapper.countByExample(taskExample);
        TaskMagger taskMagger = new TaskMagger();
        taskMagger.setTotal(count);
        taskMagger.setRows(tasks);
        return taskMagger;
    }

    @Override
    public TaskMagger search_task_by_taskManufactureSn(String searchValue, String page, String rows) {
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        criteria.andManufactureSnEqualTo(searchValue);
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        int count = (int) taskMapper.countByExample(taskExample);
        TaskMagger taskMagger = new TaskMagger();
        taskMagger.setTotal(count);
        taskMagger.setRows(tasks);
        return taskMagger;
    }
}
