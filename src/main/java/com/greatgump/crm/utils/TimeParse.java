package com.greatgump.crm.utils;

import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author CodingPang
 * @version V1.0
 * @description 时间处理对象工具类
 * @date 2022/10/21 0:51
 * @since 1.0
 */
public class TimeParse {

  /**
   * 时间格式常量
   */
  public static final String COMMON_PATTERN = "yyyy-MM-dd HH:mm:ss";
  public static final String COMMON_PATTERN_TYPE2 = "yyyy/MM/dd HH:mm:ss";
  public static final String SHORT_PATTERN = "yyyy-MM-dd";
  public static final String SHORT_PATTERN_TYPE2 = "yyyy/MM/dd";
  public static final String LONG_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";
  public static final String SUP_SHORT_PATTERN = "yyyyMMdd";
  public static final String SUP_LONG_PATTERN = "yyyyMMddHHmmss";
  public static final String YEAR_MONTH = "yyyyMM";
  public static final String YEAR = "yyyy";
  public static final String CN_SHORT_PATTERN = "yyyy年MM月dd日";
  public static final String CN_YEAR_MONTH = "yyyy年MM月";
  public static final String DDMM_PATTERN = "ddMM";


  /**
   * 1、将 String 解析为 date
   *
   * @param dateString 待解析的日期字符串
   * @param pattern    日期字符串的时间格式
   * @return
   */
  public static Date trans2Date(String dateString, String pattern) {
    String fRTN = StringUtils.isNotBlank(pattern) ? pattern : COMMON_PATTERN;
    DateTimeFormatter format = DateTimeFormat.forPattern(fRTN);
    DateTime dt = DateTime.parse(dateString, format);
    return dt.toDate();
  }

  /**
   * 2、日期字符串格式化输出
   *
   *@param
   * dateString 待格式化的日期字符串
   *
   *@param
   * fromPattern 待格式化日期字符串的格式
   *
   * @param
   * toPattern 格式化后的日期格式
   *@return
   */

  public static String formatDate2String(String dateString, String fromPattern, String toPattern) {
    String tRTN = StringUtils.isNotBlank(toPattern) ? toPattern : COMMON_PATTERN;
    DateTimeFormatter format = DateTimeFormat.forPattern(fromPattern);
    DateTime dt = DateTime.parse(dateString, format);
    return dt.toString(tRTN);
  }

  /**
   * 3、Date类型日期转字符串格式化输出
   *
   * @param date    待格式化的日期
   * @param pattern 格式化后的格式
   * @return
   */
  public static String formatDate2String(Date date, String pattern) {
    String fRTN = StringUtils.isNotBlank(pattern) ? pattern : COMMON_PATTERN;
    DateTimeFormatter format = DateTimeFormat.forPattern(fRTN);
    return new DateTime(date).toString(format);
  }

  /**
   * @return String
   * @Title: 4.获取当前指定格式的系统时间 <br/>
   * <br/>
   * <格式 :yyyy-MM-dd HH:mm:ss>
   * @Description:
   */
  public static String getCurSysTime(String pattern) {
    String fRTN = StringUtils.isNotBlank(pattern) ? pattern : COMMON_PATTERN;
    // 初始化时间
    DateTime dateTime = new DateTime();
    return dateTime.toString(fRTN);
  }

  /**
   * @return String
   * @Title: 5.获取当前指定格式的系统时间生成文件上下传的文件夹名字 <br/>
   * <br/>
   * <格式 :yyyyMMdd>
   * @Description:
   */
  public static String generateUploadFolder(String pattern) {
    String fRTN = StringUtils.isNotBlank(pattern) ? pattern : SUP_SHORT_PATTERN;
    // 初始化时间
    DateTime dateTime = new DateTime();
    return dateTime.toString(fRTN);
  }

}
