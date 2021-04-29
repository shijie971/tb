package com.tongbu.datasources.mapper.db;

import com.tongbu.datasources.model.db.Petition_Accuser_Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Title: DBPetitionAccuserInfoMapper
 * @Package: com.tongbu.datasources.mapper.db
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/29 10:21
 * @Description:
 * @Version: 1.0.0
 */
@Mapper
public interface DBPetitionAccuserInfoMapper {

    Integer findRecordCount(@Param("dateTime") String dateTime);

    List<Petition_Accuser_Info> findRecordDetails(@Param("dateTime") String dateTime, @Param("pageStart") Integer pageStart,
                                                  @Param("pageEnd") Integer pageEnd);
}
