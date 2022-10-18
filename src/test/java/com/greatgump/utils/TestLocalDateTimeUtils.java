package com.greatgump.utils;

import com.greatgump.crm.utils.LocalDateTimeUtils;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import org.junit.Test;

/**
 * @author CodingPang
 * @version V1.0
 * @description
 * @date 2022/10/18 11:38
 * @since 1.0
 */
public class TestLocalDateTimeUtils {

  @Test
  public void testLocalDateTimeUtils(){ // 时间转格式化后的字符串
    Date date = new Date(System.currentTimeMillis());
    LocalDateTime localDateTime = LocalDateTimeUtils.dateToLocalDateTime(date);
    String time = LocalDateTimeUtils.LocalDateTimeByFormat(localDateTime,
        LocalDateTimeUtils.YYYY_MM_DD_HH_MM_SS_PATTERN);
    System.out.println(time);
  }

}
