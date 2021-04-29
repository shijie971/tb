package com.tongbu.datasources.model.db;

import lombok.Data;

/**
 * @Title: Petition_Accused_Info
 * @Package: com.tongbu.datasources.model.db
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/29 14:15
 * @Description:
 * @Version: 1.0.0
 */
@Data
public class Petition_Accused_Info {
    private String OID;
    private String PETITION_NO;
    private String ACCUSED_NAME;
    private String ACCUSED_POSITION_NAME;
    private String ACCUSED_CLASS_NAME;
    private String ACCUSED_WORK_UNIT;
    private String ACCUSED_WORK_TYPE_NAME;
    private String ACCUSED_TEL_ONE;
    private String ACCUSED_REGION_NAME;

}
