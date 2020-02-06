package com.yt.model.system.user;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName role
 * @Description 角色实体
 * @createTime 2020年02月05日 12:38:00
 */
public class Role {
    private int id;
    private String rolename;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
