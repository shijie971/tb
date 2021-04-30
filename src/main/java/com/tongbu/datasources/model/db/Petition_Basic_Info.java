package com.tongbu.datasources.model.db;

import lombok.Data;

import java.util.Date;

/**
 * @Title: Petition_Basic_Info
 * @Package: com.tongbu.datasources.model.db
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/28 9:26
 * @Description:
 * @Version: 1.0.0
 */
@Data
public class Petition_Basic_Info {
    private String OID;
    private String PETITION_NO;
    private Date PETITION_DATE;
    private String PETITION_TYPE_NAME;
    private String PETITION_SOURCE_NAME;
    private String PETITION_CLASS_NAME;
    private String ISSUE_REGION_CODE;
    private String SUB_ISSUE_REGION_CODE;
    private String SUB_ISSUE_REGION_NAME;
    private String DEAL_TYPE_NAME;
    private String FIRST_ACCUSER;
    private String FIRST_ACCUSED;
    private String REPEAT_FLAG;
    private String AGENT_PERSON_NAME;
    private String END_FLAG;
    private String ARCHIVE_FLAG;
    private String ACCUSER_ANONYMOUS_FLAG;
    private String ACCUSER_CARD_ID;
    private String ACCUSER_NAME;
    private String ACCUSER_TEL_ONE;
    private String ACCUSER_WORK_UNIT;
    private String ACCUSED_NAME;
    private String ACCUSED_POSITION_NAME;
    private String ACCUSED_CLASS_NAME;
    private String ACCUSED_WORK_UNIT;
    private String ACCUSED_WORK_TYPE_NAME;
    private String ACCUSED_TEL_ONE;
    private String ACCUSED_REGION_NAME;
    private String ISSUE_TYPE_CODE;
    private String ISSUE_TYPE_NAME;
    private String ISSUE_CONTENT;
    private String KEY_WORD_NAME;
    private String GROUP_FLAG;
    private String FROM_REGION_NAME;
    private Date CREATE_DATE;
    private Date MODIFY_DATE;
}
