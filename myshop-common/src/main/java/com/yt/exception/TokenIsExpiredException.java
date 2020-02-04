package com.yt.exception;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TokenIsExpiredException
 * @Description 自定义异常，token过期异常
 * @createTime 2020年02月04日 11:56:00
 */
public class TokenIsExpiredException extends  Exception{
    public TokenIsExpiredException() {
    }

    public TokenIsExpiredException(String message) {
        super(message);
    }

    public TokenIsExpiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenIsExpiredException(Throwable cause) {
        super(cause);
    }

    public TokenIsExpiredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
