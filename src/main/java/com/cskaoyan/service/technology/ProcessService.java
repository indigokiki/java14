package com.cskaoyan.service.technology;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.technology.Process;

/**
 * @author YangShuo
 * @date 2019-06-27 10:33
 */
public interface ProcessService {

    Page<Process> selectProcessPage(int page, int rows);

    //插入功能
    int insertProcess(Process process);

    //修改功能
    int updateProcess(Process process);

    //删除功能
    int deleteProcess(String processId);

    //工序管理编号搜索
    Page<Process> searchProcessPageByVagueId(String vagueProcessId, int page, int rows);

    //工艺计划编号搜索
    Page<Process> searchProcessPageByVaguePlanId(String vaguePlanId, int page, int rows);
}
