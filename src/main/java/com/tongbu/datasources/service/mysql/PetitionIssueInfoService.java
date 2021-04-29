package com.tongbu.datasources.service.mysql;

import com.tongbu.config.DataSourceKey;
import com.tongbu.config.TargetDataSource;
import com.tongbu.datasources.model.db.Petition_Issue_Info;
import com.tongbu.datasources.model.mysql.PetitionIssueInfo;
import com.tongbu.datasources.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * @Title: PetitionIssueInfoService
 * @Package: com.tongbu.datasources.service.mysql
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/29 15:15
 * @Description:
 * @Version: 1.0.0
 */
@Service
public class PetitionIssueInfoService extends BaseService<PetitionIssueInfo> {

    @TargetDataSource(value = DataSourceKey.slave1)
    public Integer insertOrUpdate(Petition_Issue_Info data){
        PetitionIssueInfo info = new PetitionIssueInfo();
        info.setOID(data.getOID());
        info.setIssueContent(data.getISSUE_CONTENT());
        info.setIssueTypeCode(data.getISSUE_TYPE_CODE());
        info.setIssueTypeName(data.getISSUE_TYPE_NAME());
        info.setPetitionNo(data.getPETITION_NO());
        info.setCreateDate(data.getCREATE_DATE());
        int i = mapper.updateByPrimaryKeySelective(info);
        if(i < 1){
            return mapper.insertSelective(info);
        }
        return i;
    }
}
