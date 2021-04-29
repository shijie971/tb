package com.tongbu.datasources.model.mysql;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Title: PetitionBasicInfo
 * @Package: com.tongbu.datasources.model
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/28 9:21
 * @Description:
 * @Version: 1.0.0
 */
@Data
@Table(name = "petition_basic_info")
public class PetitionBasicInfo {
    @Id
    private String OID;
    private String PetitionNo;
    private Date PetitionDate;
    private String PetitionTypeName;
    private String PetitionSourceName;
    private String PetitionClassName;
    private String IssueRegionCode;
    private String SubIssueRegionCode;
    private String SubIssueRegionName;
    private String DealTypeName;
    private String FirstAccuser;
    private String FirstAccused;
    private String RepeatFlag;
    private String AgentPerson_Name;
    private String EndFlag;
    private String ArchiveFlag;
    private Date CreateDate;
    private Date ModifyDate;
}
