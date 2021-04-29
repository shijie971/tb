package com.tongbu.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Title: util
 * @Package: com.tongbu
 * @Author: ysj闫世杰
 * @Email: 1105324813@qq.com
 * @Date: Created in 2021/4/28 11:57
 * @Description:
 * @Version: 1.0.0
 */
public class DateUtil {
    public static String getDateYMDHMSS(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}
