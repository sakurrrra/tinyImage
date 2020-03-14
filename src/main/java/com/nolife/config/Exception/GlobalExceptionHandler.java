package com.nolife.config.Exception;

import com.nolife.common.Result;
import com.nolife.common.SysException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *description 全局异常
 *@author xierl
 *date 2020/3/13
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Exception异常
     *
     * @param e 异常
     * @return Result
     */
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e) {
        logger.error("Exception系统异常>>>>>>>", e);
        return Result.failure("系统异常");
    }

    /**
     * SysException异常
     *
     * @param e 异常
     * @return Result
     */
    @ExceptionHandler(value = SysException.class)
    public Result sysExceptionHandler(SysException e) {
        logger.error("Exception系统异常>>>>>>>", e);
        return Result.failure(e.getMessage());
    }
}
