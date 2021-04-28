package com.tongbu.datasources.model.mysql;

import lombok.Data;

import javax.persistence.Id;

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
public class PetitionBasicInfo {
    @Id
    private Integer oid;
    private String petitionNo;
    private String regionCode;
    private String regionName;
    private String petitionSeqNo;
    private String petitionPrtNo;
}
