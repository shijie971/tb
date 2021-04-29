package com.tongbu.datasources.model.mysql;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Title: PetitionAccusedInfo
 * @Package: com.tongbu.datasources.model.mysql
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/29 14:17
 * @Description:
 * @Version: 1.0.0
 */
@Data
@Table(name = "petition_accused_info")
public class PetitionAccusedInfo {
    @Id
    private String OID;
    private String PetitionNo;
    private String AccusedName;
    private String AccusedPositionName;
    private String AccusedClassName;
    private String AccusedWorkUnit;
    private String AccusedWorkTypeName;
    private String AccusedTelOne;
    private String AccusedRegionName;
    private Date CreateDate;
}
