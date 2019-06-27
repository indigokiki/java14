package com.cskaoyan.service;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.Process;

/**
 * @author YangShuo
 * @date 2019-06-27 10:33
 */
public interface ProcessService {

    Page<Process> selectProcessPage(int page, int rows);

}
