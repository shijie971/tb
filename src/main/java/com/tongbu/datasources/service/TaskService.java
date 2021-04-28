package com.tongbu.datasources.service;

import com.tongbu.config.DataSourceKey;
import com.tongbu.config.TargetDataSource;
import com.tongbu.datasources.mapper.mysql.TaskMapper;
import com.tongbu.datasources.model.Task;
import org.springframework.stereotype.Service;

/**
 * @Title: TaskService
 * @Package: com.tongbu.datasources.service
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/28 9:37
 * @Description:
 * @Version: 1.0.0
 */
@Service
public class TaskService extends BaseService<Task>{

    @TargetDataSource(value = DataSourceKey.slave1)
    public Task findTask(String rwmc) {
        return ((TaskMapper) mapper).findTask(rwmc);
    }


    @TargetDataSource(value = DataSourceKey.slave1)
    public Integer updateRecord(Task task) {
        return mapper.updateByPrimaryKeySelective(task);
    }
}
