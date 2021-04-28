package com.tongbu.datasources.service.db;

import com.tongbu.config.DataSourceKey;
import com.tongbu.config.TargetDataSource;
import com.tongbu.datasources.mapper.PetitionBasicInfoMapper;
import com.tongbu.datasources.model.db.Petition_Basic_Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: DBPetitionBasicInfoService
 * @Package: com.tongbu.datasources.service.db
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/28 9:31
 * @Description:
 * @Version: 1.0.0
 */
@Service
public class DBPetitionBasicInfoService {
    @Autowired
    private PetitionBasicInfoMapper mapper;


    @TargetDataSource(value = DataSourceKey.master)
    public Integer findRecordCount(){
        return mapper.findRecordCount();
    }

    @TargetDataSource(value = DataSourceKey.master)
    public List<Petition_Basic_Info> findRecordDetails(){
        return mapper.findRecordDetails();
    }
}
