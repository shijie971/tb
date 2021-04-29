package com.tongbu.datasources.model.mysql;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Title: PetitionAccuserInfo
 * @Package: com.tongbu.datasources.model.mysql
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/29 10:23
 * @Description:
 * @Version: 1.0.0
 */
@Data
@Table(name = "petition_accuser_info")
public class PetitionAccuserInfo {
    @Id
    private String OID;
    private String PetitionNo;
    private String AccuserAnonymousFlag;
    private String AccuserCardId;
    private String AccuserName;
    private String AccuserTelOne;
    private String AccuserWorkUnit;
    private Date CreateDate;
}
