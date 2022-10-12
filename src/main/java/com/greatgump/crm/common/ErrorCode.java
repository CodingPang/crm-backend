package com.greatgump.crm.common;

/**
 * @author CodingPang
 * @version V1.0
 * @description
 * @date 2022/10/12 11:22
 * @since 1.0
 */
public enum ErrorCode {
  SUCCESS(200, "ok"),
  NULL(1, "什么都没有哦~~"),
  PARAMS_ERROR(40000, "请求参数错误"),
  NOT_LOGIN_ERROR(40100, "无token，无权访问，请先登录"),
  USER_NOT_EXISTS(40101, "用户不存在"),
  NO_AUTH_ERROR(40102, "无权限"),
  TOKEN_EXPIRED(40103, "token过期，请重新登录"),
  FAKE_TOKEN(40104, "token被伪造，无效token"),
  PASSWORD_ERROR(40105, "用户名或密码错误"),

  ALREADY_LOGGED(40106, "用户名已登录，请直接进行操作"),
  NOT_FOUND_ERROR(40400, "请求数据不存在"),
  FORBIDDEN_ERROR(40300, "禁止访问"),
  SYSTEM_ERROR(50000, "系统内部异常"),
  OPERATION_ERROR(50001, "操作失败"),
  INTERNAL_SERVER_ERROR(50002,"未知异常，请联系管理员"),
  LOGIN_FAILED(50003,"登录失败");
  /**
   * 状态码
   */
  private final int code;

  /**
   * 信息
   */
  private final String message;

  ErrorCode(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

}
