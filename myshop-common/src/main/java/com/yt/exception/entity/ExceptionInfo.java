package com.yt.exception.entity;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ExceptionInfo
 * @Description 异常信息模型
 * @createTime 2020年02月06日 16:03:00
 */
public class ExceptionInfo<T> {
//    public static final Integer OK=0;
//    public static final Integer EXCEPTION = 450;

    private Integer code;
    private String message;
    private String url;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
