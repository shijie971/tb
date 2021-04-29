package com.tongbu.datasources.mapper.db;

import com.tongbu.datasources.model.db.Petition_Basic_Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Title: PetitionBasicInfoMapper
 * @Package: com.tongbu.datasources.mapper.mysql
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/28 9:28
 * @Description:
 * @Version: 1.0.0
 */
@Mapper
public interface DBPetitionBasicInfoMapper {

    Integer findRecordCount(@Param("dateTime")String dateTime);

    List<Petition_Basic_Info> findRecordDetails(@Param("dateTime")String dateTime,@Param("pageStart") Integer pageStart,
                                                @Param("pageEnd") Integer pageEnd);
}
