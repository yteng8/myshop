package com.yt.entity;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName LoginUser
 * @Description 登录信息
 * @createTime 2020年02月04日 11:39:00
 */
public class LoginUser {
    private String username;
    private String password;
    private Integer rememberMe;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Integer rememberMe) {
        this.rememberMe = rememberMe;
    }
}
