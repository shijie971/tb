package com.tongbu.datasources.model;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

/**
 * @Title: Task
 * @Package: com.tongbu.datasources.model
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/28 9:36
 * @Description:
 * @Version: 1.0.0
 */
@Data
public class Task {
    @Id
    private String id;
    private String title;
    private String content;
    private String status;
    private Date time;
}
