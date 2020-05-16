package com.mingx.common.hander;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mingx.common.AppResult;
import com.mingx.common.AppResultBuilder;
import com.mingx.common.ResultCode;

/**
 * @author fuqiangxin
 * @Classname: SysExceptionHandler
 * @Description: 实现全局的异常处理
 * @date 2020/5/15 18:34
 */
@ControllerAdvice
@Component
public class SysExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(SysExceptionHandler.class);

    /**
     * 入参校验
     *
     * @param exception
     * @return
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public AppResult<String> handle(MethodArgumentNotValidException exception) {
        String message = exception.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return AppResultBuilder.error(ResultCode.PARAM_ERROR, message);
    }

    /**
     * 全局异常捕捉处理
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public AppResult<String> errorHandler(Exception ex) {
        logger.error(ex.getMessage(), ex);
        return AppResultBuilder.error(ResultCode.SYSTEM_ERROR);
    }
}
