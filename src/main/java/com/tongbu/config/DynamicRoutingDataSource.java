package com.tongbu.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Title: DynamicRoutingDataSource
 * @Package: com.tongbu.config
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/21 16:29
 * @Description:
 * @Version: 1.0.0
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    /**
     * logger日志
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    protected Object determineCurrentLookupKey() {
        String dataSourceName = DynamicDataSourceContextHolder.get().toString();
        logger.info("当前数据源:{}", dataSourceName);
        // 从共享线程中获取数据源名称
        return DynamicDataSourceContextHolder.get();
    }
}
