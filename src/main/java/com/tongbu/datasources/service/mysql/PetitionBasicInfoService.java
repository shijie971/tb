package com.tongbu.datasources.service.mysql;

import com.tongbu.config.DataSourceKey;
import com.tongbu.config.TargetDataSource;
import com.tongbu.datasources.model.db.Petition_Basic_Info;
import com.tongbu.datasources.model.mysql.PetitionBasicInfo;
import com.tongbu.datasources.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * @Title: PetitionBasicInfoService
 * @Package: com.tongbu.datasources.service.mysql
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/28 9:31
 * @Description:
 * @Version: 1.0.0
 */
@Service
public class PetitionBasicInfoService extends BaseService<PetitionBasicInfo> {

    @TargetDataSource(value = DataSourceKey.slave1)
    public int insertOrUpdate(Petition_Basic_Info data) {
        PetitionBasicInfo info = new PetitionBasicInfo();
        info.setOid(Integer.parseInt(data.getId()));
        info.setPetitionNo(data.getPETITION_NO());
        info.setRegionName(data.getREGION_NAME());
        return mapper.insertSelective(info);
    }
}
