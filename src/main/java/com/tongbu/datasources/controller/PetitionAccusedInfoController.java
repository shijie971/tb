package com.tongbu.datasources.controller;

import com.tongbu.datasources.model.Task;
import com.tongbu.datasources.model.db.Petition_Accused_Info;
import com.tongbu.datasources.service.TaskService;
import com.tongbu.datasources.service.db.DBPetitionAccusedInfoService;
import com.tongbu.datasources.service.mysql.PetitionAccusedInfoService;
import com.tongbu.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Title: PetitionAccusedInfoController
 * @Package: com.tongbu.datasources.controller
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/29 14:15
 * @Description:
 * @Version: 1.0.0
 */
@RestController
@EnableScheduling
@PropertySource("classpath:application.yml")
public class PetitionAccusedInfoController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private DBPetitionAccusedInfoService dbPetitionAccusedInfoService;
    @Autowired
    private PetitionAccusedInfoService petitionAccusedInfoService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final Integer LIMIT = 1000;
    private static final String TITLE = "petition_accused_info";


    @Scheduled(cron = "${cron.msg}")
    public void taskRun(){
        try {
            Task task = taskService.findTask(TITLE);
            if(task == null || "0".equals(task.getStatus())){
                logger.info(TITLE +": 未查询到定时任务或者定时任务未开启");
                return;
            }else {
                int row = 0;
                Date nowTime = new Date();
                String date = DateUtil.getDateYMDHMSS(task.getTime());
                Integer recordCount = dbPetitionAccusedInfoService.findRecordCount(date);
                if(recordCount == 0){
                    logger.info(TITLE +": 未查询到数据");
                    return;
                }
                int pageSize = LIMIT;
                int pageNum = recordCount % pageSize == 0 ? recordCount / pageSize : recordCount / pageSize + 1;
                for (int i = 0; i < pageNum; i += LIMIT) {
                    int pageStart = i * pageSize;
                    int pageEnd = (i + 1) * pageSize;
                    List<Petition_Accused_Info> list = dbPetitionAccusedInfoService.findRecordDetails(date,pageStart,pageEnd);
                    for(Petition_Accused_Info data : list){
                        row += petitionAccusedInfoService.insertOrUpdate(data);
                    }
                }
                logger.info(TITLE + ": 获取同步数据总条数：" + recordCount + "条 , " + row + "条：同步完成");
                // 更新定时任务同步时间戳
                task.setTime(nowTime);
                taskService.updateRecord(task);
                return;
            }
        }catch (Exception e){
            logger.error("同步异常", e);
            return;
        }
    }
}
