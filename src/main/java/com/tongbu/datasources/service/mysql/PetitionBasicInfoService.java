package com.tongbu.datasources.service.mysql;

import com.tongbu.config.DataSourceKey;
import com.tongbu.config.TargetDataSource;
import com.tongbu.datasources.model.db.Petition_Basic_Info;
import com.tongbu.datasources.model.mysql.PetitionBasicInfo;
import com.tongbu.datasources.service.BaseService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @Title: PetitionBasicInfoService
 * @Package: com.tongbu.datasources.service.mysql
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/28 9:31
 * @Description:
 * @Version: 1.0.0
 */
@Service
public class PetitionBasicInfoService extends BaseService<PetitionBasicInfo> {

    @TargetDataSource(value = DataSourceKey.slave1)
    public int insertOrUpdate(Petition_Basic_Info data) {
        PetitionBasicInfo info = new PetitionBasicInfo();
        info.setPetitionNo(data.getPETITION_NO());
        info.setPetitionTypeName(data.getPETITION_TYPE_NAME());
        info.setPetitionSourceName(data.getPETITION_SOURCE_NAME());
        info.setPetitionClassName(data.getPETITION_CLASS_NAME());
        info.setIssueRegionCode(data.getISSUE_REGION_CODE());
        info.setSubIssueRegionCode(data.getSUB_ISSUE_REGION_CODE());
        info.setSubIssueRegionName(data.getSUB_ISSUE_REGION_NAME());
        info.setDealTypeName(data.getDEAL_TYPE_NAME());
        info.setFirstAccuser(data.getFIRST_ACCUSER());
        info.setFirstAccused(data.getFIRST_ACCUSED());
        info.setRepeatFlag(data.getREPEAT_FLAG());
        info.setAgentPerson_Name(data.getAGENT_PERSON_NAME());
        info.setEndFlag(data.getEND_FLAG());
        info.setArchiveFlag(data.getARCHIVE_FLAG());
        info.setCreateDate(data.getCREATE_DATE());
        info.setModifyDate(data.getMODIFY_DATE());
        //由于信访编号是唯一的所以直接根据信访编号更新数据（PETITION_NO）
        //否则将新增数据
        Example example = new Example(PetitionBasicInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("PETITION_NO",data.getPETITION_NO());
        int i = mapper.updateByExampleSelective(info,example);
        if(i < 1){
            info.setOID(data.getOID());
            info.setPetitionDate(data.getPETITION_DATE());
            return mapper.insertSelective(info);
        }
        return i;
    }
}
