package com.greatgump.crm.exception;

import com.greatgump.crm.utils.IResultCode;
import com.greatgump.crm.utils.ResultCode;

/**
 * 自定义异常类
 *
 * @author yupi
 */
public class BusinessException extends RuntimeException implements IResultCode {

    private final String code;

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.code = resultCode.getCode();
    }

    public BusinessException(ResultCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return this.getMessage();
    }
}
