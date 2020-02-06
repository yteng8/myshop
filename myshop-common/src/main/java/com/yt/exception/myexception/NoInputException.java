package com.yt.exception.myexception;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName NoInputException
 * @Description 空输入异常
 * @createTime 2020年02月06日 15:42:00
 */
public class NoInputException extends Exception {

    public NoInputException(String message) {
        super(message);
    }
}
