package com.tongbu.datasources.service.mysql;

import com.tongbu.config.DataSourceKey;
import com.tongbu.config.TargetDataSource;
import com.tongbu.datasources.model.db.Petition_Accuser_Info;
import com.tongbu.datasources.model.mysql.PetitionAccuserInfo;
import com.tongbu.datasources.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * @Title: PetitionAccuserInfoService
 * @Package: com.tongbu.datasources.service.mysql
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/29 10:22
 * @Description:
 * @Version: 1.0.0
 */
@Service
public class PetitionAccuserInfoService extends BaseService<PetitionAccuserInfo> {

    @TargetDataSource(value = DataSourceKey.slave1)
    public int insertOrUpdate(Petition_Accuser_Info data){
        PetitionAccuserInfo info = new PetitionAccuserInfo();
        info.setOID(data.getOID());
        info.setPetitionNo(data.getPETITION_NO());
        info.setAccuserCardId(data.getACCUSER_CARD_ID());
        info.setAccuserAnonymousFlag(data.getACCUSER_ANONYMOUS_FLAG());
        info.setAccuserName(data.getACCUSER_NAME());
        info.setAccuserTelOne(data.getACCUSER_TEL_ONE());
        info.setAccuserWorkUnit(data.getACCUSER_WORK_UNIT());
        info.setCreateDate(data.getCREATE_DATE());
        int i = mapper.updateByPrimaryKeySelective(info);
        if(i < 1){
            return mapper.insertSelective(info);
        }
        return i;
    }
}
