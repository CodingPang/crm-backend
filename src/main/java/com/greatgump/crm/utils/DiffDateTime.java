package com.greatgump.crm.utils;
import io.swagger.models.auth.In;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author CodingPang
 * @version V1.0
 * @description
 * @date 2022/10/19 20:00
 * @since 1.0
 */
public class DiffDateTime {

  /**
   * Joda-Time 计算两个时间差（年，月，星期，日，小时，分钟，秒，毫秒）   注： 开始时间 和 结束时间 格式须相同
   *
   * @param startDateTime 开始时间
   * @param endDateTime   结束时间
   * @param dateTimeType  时间格式（2018年01月20日 21:02:37（yyyy年MM月dd日 HH:mm:ss））
   */
  public static Integer calculateTimeDifference(String startDateTime, String endDateTime,
      String dateTimeType) {

    DateTimeFormatter format = DateTimeFormat.forPattern(dateTimeType);
    DateTime dateTimeStart = format.parseDateTime(startDateTime);
    DateTime dateTimeEnd = format.parseDateTime(endDateTime);

    if (dateTimeStart.isAfter(dateTimeEnd)) {
      DateTime temp = dateTimeStart;
      dateTimeStart = dateTimeEnd;
      dateTimeEnd = temp;
      return 0;
    }

    Interval interval = new Interval(dateTimeStart.getMillis(), dateTimeEnd.getMillis());
    Period p = interval.toPeriod();
    System.out.println(p.toString());
    System.out.printf(
        "两个日期的时间差：%d 年 %d 个月 %d 星期 %d 天 %d 小时 %d 分钟 %d 秒 %d 毫秒\n",
        p.getYears(), p.getMonths(), p.getWeeks(), p.getDays(), p.getHours(), p.getMinutes(),
        p.getSeconds(), p.getMillis());

    return p.getDays();

  }
}