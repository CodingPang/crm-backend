package com.greatgump.crm.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CodingPang
 * @version V1.0
 * @description 封装后端返回给LayUI的Json数据
 * @date 2022/10/05 13:37
 * @since 1.0
 */
public class R extends HashMap<String, Object> {


  private static final String codeKey = "code"; // 状态码的key
  private static final String countKey = "count"; // 从数据库查询到的数据条数(计数) key
  private static final String msgKey = "msg"; // 错误信息内容

  private static final String dataKey = "data"; // 携带的数据

  public R() {

  }

  public static R ok(){
    R r = new R();
    r.put(codeKey, 0);
    r.put(msgKey, "success");
    return r;
  }

  public static R ok(long count, Object data){
    R r = new R();
    r.put(codeKey, 0);
    r.put(msgKey, "success");
    r.put(countKey, count);
    r.put(dataKey, data);
    return r;
  }

  public static  R error(){ // 未知错误
    R r = new R();
    r.put(codeKey, ErrorCode.INTERNAL_SERVER_ERROR.getCode());
    r.put(msgKey, ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
    r.put(countKey, 0);
    r.put(dataKey, null);
    return r;
  }

  public static  R error(ErrorCode e){ // 业务错误，但是没有要从数据查询的返回
    R r = new R();
    r.put(codeKey, e.getCode());
    r.put(msgKey, e.getMessage());
    r.put(countKey, 0);
    r.put(dataKey, null);
    return r;
  }

  public static  R error(ErrorCode e,long count, Object data){
    R r = new R();
    r.put(codeKey, e.getCode());
    r.put(msgKey, e.getMessage());
    r.put(countKey, count);
    r.put(dataKey, data);
    return r;
  }

  public static R ok(Map<String, Object> map) {
    R r = new R();
    r.putAll(map);
    return r;
  }

  public static R error(int code, String message) {
    R r = new R();
    r.put(codeKey,code);
    r.put(msgKey, message);
    return r;
  }

  public static R error(ErrorCode systemError, String message) {
    R r = new R();
    r.put(codeKey,systemError.getCode());
    r.put(msgKey, message);
    return r;
  }

  @Override
  public R put(String key, Object value) {
    super.put(key, value);
    return this;
  }

}
