package com.tongbu.datasources.controller;


import com.tongbu.datasources.model.Task;
import com.tongbu.datasources.model.db.Petition_Basic_Info;
import com.tongbu.datasources.service.TaskService;
import com.tongbu.datasources.service.db.DBPetitionBasicInfoService;
import com.tongbu.datasources.service.mysql.PetitionBasicInfoService;
import com.tongbu.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

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
    @Autowired
    private DBPetitionBasicInfoService dbPetitionBasicInfoService;
    @Autowired
    private PetitionBasicInfoService petitionBasicInfoService;
    /**
     * logger日志
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final Integer LIMIT = 1000;

    @Scheduled(cron = "${cron.msg}")
    public void taskRun() {
        try {
            //查询同步任务是否开启
            Task task = taskService.findTask("petition_basic_info");
            if(task == null || "0".equals(task.getStatus())){
                logger.info("未查询到定时任务或者定时任务未开启");
            }else {
                int row = 0;
                Date nowTime = new Date();
                String date = null;
                if (task.getTime() != null) {
                    date = DateUtil.getDateYMDHMSS(task.getTime());
                }
                // 获取读数据源同步数据总数
                Integer count = dbPetitionBasicInfoService.findRecordCount();
                if(count == 0){
                    // 更新定时任务同步时间戳
                    task.setTime(nowTime);
                    taskService.updateRecord(task);
                    return;
                }
                for (int i = 0; i < count; i += LIMIT) {
                    List<Petition_Basic_Info> list = dbPetitionBasicInfoService.findRecordDetails();
                    for(Petition_Basic_Info data : list){
                        row += petitionBasicInfoService.insertOrUpdate(data);
                    }
                }
                // 更新定时任务时间戳
                logger.info("获取同步数据总条数：" + count + "条 , " + row + "条：同步完成");
                // 更新定时任务同步时间戳
                task.setTime(nowTime);
                taskService.updateRecord(task);
                return;
            }
        } catch (Exception e) {
            logger.error("同步异常", e);
            return;
        }
    }
}
