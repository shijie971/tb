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
    private String id;
    private String Petition_Code;
    private String Reception_Area;
    private String Area_name;
    private String problem_ascription;
    private Date Petition_Date;
    private String Petition_Mode;
    private String Petion_Source;
    private String Petion_Category;
    private String Petion_Rank;
    private String Duplicate;
    private String ClosingUp;
    private String Filing;
    private String Respondent_Name;
    private String Respondent_Area;
    private String Respondent_Unit;
    private String Respondent_Post;
    private String Respondent_Rank;
    private String Unit_Category;
    private String Reflector_Name;
    private String Reflector_Unit;
    private String Reflector_Signature;
    private String Reflector_Tel;
    private String Problem_Category;
    private String Problem_Remark;
    private String Transfer_Organ;
    private String Undertake_Unit;
    private String Keyword;
    private String Circulation_State;
    private String Add_User;
    private Date Add_Date;
    private String Reflect_Area;
    private String Problem_Type;
    private String Bar_Code;
    private String Handle_Type;
    private String Previous_Info;
    private Date case_Time;
    private String IsEndCase;
    private String DisposeResult;
    private String verify;
    private String handleFinish;
    private String IDCard;
    private String RegionCode;
    private String subregionCode;
    private String IssueTypeCode;
    private String IssueTypeName;
    private String AgentPeronName;

}
