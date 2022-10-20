package com.greatgump.utils;

import static com.greatgump.crm.utils.DiffDateTime.calculateTimeDifference;

/**
 * @author CodingPang
 * @version V1.0
 * @description
 * @date 2022/10/19 20:03
 * @since 1.0
 */
public class TestDiffDateTime {
  public static void main(String[] args) {
    calculateTimeDifference("2018年01月20日 21:02:37", "2019年03月01日 13:24:46", "yyyy年MM月dd日 HH:mm:ss");
    calculateTimeDifference("2018年01月27日", "2019年03月07日", "yyyy年MM月dd日");
    calculateTimeDifference("2019年03月01日", "2018年01月20日", "yyyy年MM月dd日");
    calculateTimeDifference("2022-10-17", "2022-10-18", "yyyy-MM-dd");
    calculateTimeDifference("2022-10-18", "2022-10-1", "yyyy-MM-dd");
  }

}
