package com.tongbu.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Title: DynamicDataSourceAspect
 * @Package: com.tongbu.config
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/21 16:26
 * @Description:
 * @Version: 1.0.0
 */
@Aspect
@Order(1) //设置AOP执行顺序(需要在事务之前，否则事务只发生在默认库中)
@Component
public class DynamicDataSourceAspect {
    /**
     * 切换放在mapper接口的方法上，所以这里要配置AOP切面的切入点
     */
    @Pointcut("execution( * com.tongbu.datasources.service.*.*(..))")
    public void dataSourcePointCut() {
    }

    /**
     * 利用反射获取注解参数数据源Key值，并切换至改数据源
     * @param joinPoint
     */
    @Before("@annotation(TargetDataSource)")
    public void before(JoinPoint joinPoint) {
        //获得当前访问的class
        Class<?> className = joinPoint.getTarget().getClass();
        //获得访问的方法名
        String methodName = joinPoint.getSignature().getName();
        //得到方法的参数的类型
        Class[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
        //获取数据源名称
        DataSourceKey dataSourceKey = null;
        try {
            // 得到访问的方法对象
            Method method = className.getMethod(methodName, parameterTypes);
            // 判断是否存在@TargetDataSource注解
            if (null != method && method.isAnnotationPresent(TargetDataSource.class)) {
                TargetDataSource annotation = method.getAnnotation(TargetDataSource.class);
                // 取出注解中的数据源名
                dataSourceKey = annotation.value();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 切换数据源
        DynamicDataSourceContextHolder.set(dataSourceKey);
    }

    /**
     * 执行完切面后，将线程共享中的数据源名称清空
     * @param joinPoint
     */
    @After("dataSourcePointCut()")
    public void after(JoinPoint joinPoint){
        DynamicDataSourceContextHolder.clear();
    }
}
