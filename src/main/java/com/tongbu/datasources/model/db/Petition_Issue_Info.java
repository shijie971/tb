package com.tongbu.datasources.model.db;

import lombok.Data;

import java.util.Date;

/**
 * @Title: Petition_Issue_Info
 * @Package: com.tongbu.datasources.model.db
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/29 15:13
 * @Description:
 * @Version: 1.0.0
 */
@Data
public class Petition_Issue_Info {
    private String OID;
    private String PETITION_NO;
    private String ISSUE_TYPE_CODE;
    private String ISSUE_TYPE_NAME;
    private String ISSUE_CONTENT;
    private Date CREATE_DATE;
}
