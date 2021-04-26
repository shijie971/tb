package com.tongbu.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: DynamicDataSourceContextHolder
 * @Package: com.tongbu.config
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/21 16:28
 * @Description:
 * @Version: 1.0.0
 */
public class DynamicDataSourceContextHolder {

    /**
     * 存储已经注册的数据源的key, 主要是为了判断数据源是否存在
     */
    public static List<DataSourceKey> dataSourceKeys = new ArrayList<>();

    /**
     * 当使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程提供独立的变量副本，
     * 所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
     */
    private static final ThreadLocal<DataSourceKey> currentDatesource = new ThreadLocal<>();

    /**
     * 清除当前数据源
     */
    public static void clear() {
        currentDatesource.remove();
    }

    /**
     * 获取当前使用的数据源
     *
     * @return 当前使用数据源的ID
     */
    public static DataSourceKey get() {
        return currentDatesource.get();
    }

    /**
     * 设置当前使用的数据源
     *
     * @param dataSourceKey 需要设置的数据源ID
     */
    public static void set(DataSourceKey dataSourceKey) {
        currentDatesource.set(dataSourceKey);
    }

}
