package com.yt.model.system.user.vo;

import java.sql.Date;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SystemUserInfoVo
 * @Description 查询所有系统用户的返回模型
 * @createTime 2020年02月07日 12:17:00
 */
public class SystemUserInfoVo {
    private int id;
    private String username;
    private String password;
    private String real;
    private int age;
    private int sex;
    private Date entryTime;
    private String roleName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getReal() {
        return real;
    }

    public void setReal(String real) {
        this.real = real;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
