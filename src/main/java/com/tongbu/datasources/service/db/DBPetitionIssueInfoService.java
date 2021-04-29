package com.tongbu.datasources.service.db;

import com.tongbu.config.DataSourceKey;
import com.tongbu.config.TargetDataSource;
import com.tongbu.datasources.mapper.db.DBPetitionIssueInfoMapper;
import com.tongbu.datasources.model.db.Petition_Issue_Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: DBPetitionIssueInfoService
 * @Package: com.tongbu.datasources.service.db
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/29 15:15
 * @Description:
 * @Version: 1.0.0
 */
@Service
public class DBPetitionIssueInfoService {

    @Autowired
    private DBPetitionIssueInfoMapper dbPetitionIssueInfoMapper;


    @TargetDataSource(value = DataSourceKey.master)
    public Integer findRecordCount(String dateTime){
        return dbPetitionIssueInfoMapper.findRecordCount(dateTime);
    }

    @TargetDataSource(value = DataSourceKey.master)
    public List<Petition_Issue_Info> findRecordDetails(String dateTime,Integer pageStart,Integer pageEnd){
        return dbPetitionIssueInfoMapper.findRecordDetails(dateTime, pageStart, pageEnd);
    }
}
