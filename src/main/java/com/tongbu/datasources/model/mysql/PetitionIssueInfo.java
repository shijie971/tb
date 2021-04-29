package com.tongbu.datasources.model.mysql;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Title: PetitionIssueInfo
 * @Package: com.tongbu.datasources.model.mysql
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/29 15:13
 * @Description:
 * @Version: 1.0.0
 */
@Data
@Table(name = "petition_issue_info")
public class PetitionIssueInfo {
    @Id
    private String OID;
    private String PetitionNo;
    private String IssueTypeCode;
    private String IssueTypeName;
    private String IssueContent;
    private Date CreateDate;
}
