package com.yt.model.system.user;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserRole
 * @Description 用户角色模型
 * @createTime 2020年02月07日 16:53:00
 */
public class UserRole {
    private int userId;
    private int roleId;
    private String roleName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
