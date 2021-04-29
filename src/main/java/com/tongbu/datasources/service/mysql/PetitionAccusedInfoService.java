package com.tongbu.datasources.service.mysql;

import com.tongbu.config.DataSourceKey;
import com.tongbu.config.TargetDataSource;
import com.tongbu.datasources.model.db.Petition_Accused_Info;
import com.tongbu.datasources.model.mysql.PetitionAccusedInfo;
import com.tongbu.datasources.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * @Title: PetitionAccusedInfoService
 * @Package: com.tongbu.datasources.service.mysql
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/29 14:25
 * @Description:
 * @Version: 1.0.0
 */
@Service
public class PetitionAccusedInfoService extends BaseService<PetitionAccusedInfo> {

    @TargetDataSource(value = DataSourceKey.slave1)
    public int insertOrUpdate(Petition_Accused_Info data){
        PetitionAccusedInfo info = new PetitionAccusedInfo();
        info.setOID(data.getOID());
        info.setPetitionNo(data.getPETITION_NO());
        info.setAccusedName(data.getACCUSED_NAME());
        info.setAccusedPositionName(data.getACCUSED_POSITION_NAME());
        info.setAccusedClassName(data.getACCUSED_CLASS_NAME());
        info.setAccusedWorkTypeName(data.getACCUSED_WORK_TYPE_NAME());
        info.setAccusedWorkUnit(data.getACCUSED_WORK_UNIT());
        info.setAccusedTelOne(data.getACCUSED_TEL_ONE());
        info.setAccusedRegionName(data.getACCUSED_REGION_NAME());
        int i = mapper.updateByPrimaryKeySelective(info);
        if(i < 1){
            return mapper.insertSelective(info);
        }
        return i;
    }
}
