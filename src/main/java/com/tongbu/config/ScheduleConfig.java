package com.tongbu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @Title: ScheduleConfig
 * @Package: com.example.config
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021-2-5 10:26
 * @Description: 定时任务配置类
 * @Version: 1.0.0
 */
@Configuration
public class ScheduleConfig {
    @Bean
    public TaskScheduler taskScheduler(){
        //Spring提供的定时任务线程池类
        ThreadPoolTaskScheduler taskScheduler=new ThreadPoolTaskScheduler();
        //设定最大可用的线程数目
        taskScheduler.setPoolSize(10);
        return taskScheduler;
    }
}
