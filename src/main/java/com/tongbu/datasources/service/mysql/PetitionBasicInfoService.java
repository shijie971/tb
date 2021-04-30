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
        info.setPetition_Code(data.getPETITION_NO());
        info.setId(data.getOID());
        info.setPetition_Mode(data.getPETITION_TYPE_NAME());
        info.setPetion_Source(data.getPETITION_SOURCE_NAME());
        info.setPetion_Category(data.getPETITION_CLASS_NAME());
        info.setProblem_ascription(data.getSUB_ISSUE_REGION_NAME());
        info.setProblem_Remark(data.getISSUE_CONTENT());
        info.setHandle_Type(data.getDEAL_TYPE_NAME());
        info.setReflector_Name(data.getFIRST_ACCUSER());
        info.setRespondent_Name(data.getFIRST_ACCUSED());
        info.setDuplicate(data.getREPEAT_FLAG());
        info.setClosingUp(data.getEND_FLAG());
        info.setFiling(data.getARCHIVE_FLAG());
        info.setReflector_Signature(data.getACCUSER_ANONYMOUS_FLAG());
        info.setReflector_Name(data.getACCUSER_NAME());
        info.setReflector_Tel(data.getACCUSER_TEL_ONE());
        info.setReflector_Unit(data.getACCUSER_WORK_UNIT());
        info.setRespondent_Unit(data.getACCUSED_WORK_UNIT());
        info.setRespondent_Name(data.getACCUSED_NAME());
        info.setRespondent_Post(data.getACCUSED_POSITION_NAME());
        info.setRespondent_Rank(data.getACCUSED_CLASS_NAME());
        info.setUnit_Category(data.getACCUSED_WORK_TYPE_NAME());
        info.setRespondent_Area(data.getACCUSED_REGION_NAME());
        info.setTransfer_Organ(data.getFROM_REGION_NAME());
        info.setKeyword(data.getKEY_WORD_NAME());
        info.setIssueTypeCode(data.getISSUE_TYPE_CODE());
        info.setIssueTypeName(data.getISSUE_TYPE_NAME());

        //由于信访编号是唯一的所以直接根据信访编号更新数据（PETITION_NO）
        //否则将新增数据
        Example example = new Example(PetitionBasicInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("Petition_Code",data.getPETITION_NO());
        int i = mapper.updateByExampleSelective(info,example);
        if(i < 1){
            info.setPetition_Date(data.getPETITION_DATE());
            return mapper.insertSelective(info);
        }
        return i;
    }
}
