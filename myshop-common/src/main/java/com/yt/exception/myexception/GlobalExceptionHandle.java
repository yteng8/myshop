package com.yt.exception.myexception;

import com.yt.exception.entity.ExceptionInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName GlobalExceptionHandle
 * @Description 全局异常处理器
 * @createTime 2020年02月06日 15:58:00
 */
@ControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(value = NoInputException.class)
    @ResponseBody
    public ExceptionInfo NoInputExceptionHandle(HttpServletRequest req,NoInputException e){
        ExceptionInfo exceptionInfo = new ExceptionInfo();
        exceptionInfo.setCode(451);
        exceptionInfo.setMessage(e.getMessage());
        exceptionInfo.setUrl(req.getRequestURL().toString());
        return exceptionInfo;
    }
}
