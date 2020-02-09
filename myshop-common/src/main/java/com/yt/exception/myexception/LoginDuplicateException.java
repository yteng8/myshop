package com.yt.exception.myexception;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName LoginDuplicateException
 * @Description TODO
 * @createTime 2020年02月09日 18:30:00
 */
public class LoginDuplicateException extends Exception{
    public LoginDuplicateException(String message) {
        super(message);
    }
}
