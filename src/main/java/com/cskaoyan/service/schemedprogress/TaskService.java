package com.cskaoyan.service.schemedprogress;

import com.cskaoyan.bean.Task;
import com.cskaoyan.bean.schemedprogress.TaskMagger;

public interface TaskService {

    TaskMagger getTaskByPage(String page, String rows);

    int insert(Task task);

    int update(Task task);

    int delete(String[] ids);

    TaskMagger search_task_by_taskId(String searchValue, String page, String rows);

    TaskMagger search_task_by_taskWorkId(String searchValue, String page, String rows);

    TaskMagger search_task_by_taskManufactureSn(String searchValue, String page, String rows);
}
