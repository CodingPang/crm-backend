package com.greatgump.crm.exception;

import com.greatgump.crm.utils.Result;
import com.greatgump.crm.utils.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author yupi
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public Result<T> businessExceptionHandler(BusinessException e) {
        log.error("businessException: " + e.getMessage(), e);
        return Result.failed(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Result<T>runtimeExceptionHandler(RuntimeException e) {
        log.error("runtimeException", e);
        return Result.failed(ResultCode.SYSTEM_EXECUTION_ERROR, e.getMessage());
    }
}
