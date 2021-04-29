package com.tongbu.datasources.service.db;

import com.tongbu.config.DataSourceKey;
import com.tongbu.config.TargetDataSource;
import com.tongbu.datasources.mapper.db.DBPetitionAccuserInfoMapper;
import com.tongbu.datasources.model.db.Petition_Accuser_Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: PetitionAccuserInfoService
 * @Package: com.tongbu.datasources.service.db
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/29 10:22
 * @Description:
 * @Version: 1.0.0
 */
@Service
public class DBPetitionAccuserInfoService {

    @Autowired
    private DBPetitionAccuserInfoMapper dbPetitionAccuserInfoMapper;

    @TargetDataSource(value = DataSourceKey.master)
    public Integer findRecordCount(String dateTime){
        return dbPetitionAccuserInfoMapper.findRecordCount(dateTime);
    }

    @TargetDataSource(value = DataSourceKey.master)
    public List<Petition_Accuser_Info> findRecordDetails(String dateTime,Integer pageStart,Integer pageEnd){
        return dbPetitionAccuserInfoMapper.findRecordDetails(dateTime,pageStart,pageEnd);
    }
}
