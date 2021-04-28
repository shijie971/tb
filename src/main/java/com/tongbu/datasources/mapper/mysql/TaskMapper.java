package com.tongbu.datasources.mapper.mysql;

import com.tongbu.datasources.model.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Title: TaskMapper
 * @Package: com.tongbu.datasources.mapper
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/28 9:35
 * @Description:
 * @Version: 1.0.0
 */
@Mapper
public interface TaskMapper extends tk.mybatis.mapper.common.Mapper<Task> {

    Task findTask(@Param("title") String title);
}
