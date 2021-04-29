package com.tongbu.datasources.model.db;

import lombok.Data;

import java.util.Date;

/**
 * @Title: Petition_Accuser_Info
 * @Package: com.tongbu.datasources.model.db
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/29 10:22
 * @Description:
 * @Version: 1.0.0
 */
@Data
public class Petition_Accuser_Info {
    private String OID;
    private String PETITION_NO;
    private String ACCUSER_ANONYMOUS_FLAG;
    private String ACCUSER_CARD_ID;
    private String ACCUSER_NAME;
    private String ACCUSER_TEL_ONE;
    private String ACCUSER_WORK_UNIT;
    private Date CREATE_DATE;
}
