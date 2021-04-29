package com.tongbu.datasources.service.db;

import com.tongbu.config.DataSourceKey;
import com.tongbu.config.TargetDataSource;
import com.tongbu.datasources.mapper.db.DBPetitionAccusedInfoMapper;
import com.tongbu.datasources.model.db.Petition_Accused_Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: DBPetitionAccusedInfoService
 * @Package: com.tongbu.datasources.service.db
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/29 14:24
 * @Description:
 * @Version: 1.0.0
 */
@Service
public class DBPetitionAccusedInfoService {

    @Autowired
    private DBPetitionAccusedInfoMapper dbPetitionAccusedInfoMapper;


    @TargetDataSource(value = DataSourceKey.master)
    public Integer findRecordCount(String dateTime){
        return dbPetitionAccusedInfoMapper.findRecordCount(dateTime);
    }


    @TargetDataSource(value = DataSourceKey.master)
    public List<Petition_Accused_Info> findRecordDetails(String dateTime,Integer pageStart,Integer pageEnd){
        return dbPetitionAccusedInfoMapper.findRecordDetails(dateTime, pageStart, pageEnd);
    }
}
