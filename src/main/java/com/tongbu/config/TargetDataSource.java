package com.tongbu.config;

import java.lang.annotation.*;

/**
 * @Title: TargetDataSource
 * @Package: com.tongbu.config
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/21 16:30
 * @Description:
 * @Version: 1.0.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    /**
     * 默认数据源的 key：master
     * 也就是说如果直接用注解，而不指定value的话，那么默认就使用master默认数据源
     */
    DataSourceKey value() default DataSourceKey.master;
}
