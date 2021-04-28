package com.tongbu.datasources.controller;


import com.tongbu.datasources.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: PetitionBasicInfoController
 * @Package: com.tongbu.datasources.controller
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/28 9:32
 * @Description:
 * @Version: 1.0.0
 */

@RestController
@EnableScheduling
@PropertySource("classpath:application.yml")
@RequestMapping("basicInfo")
public class PetitionBasicInfoController {

    @Autowired
    private TaskService taskService;
    /**
     * logger日志
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final Integer LIMIT = 1000;
}
