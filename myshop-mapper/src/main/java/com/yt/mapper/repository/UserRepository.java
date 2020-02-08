package com.yt.mapper.repository;

import com.yt.entity.User;
import com.yt.model.system.user.Role;
import com.yt.model.system.user.SystemUserInfo;
import com.yt.model.system.user.UserRole;
import com.yt.model.system.user.vo.SystemUserInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserRepository
 * @Description 用户的登录操作
 * @createTime 2020年02月04日 10:48:00
 */
public interface UserRepository extends CrudRepository<User, Integer>{
    /**
     * 根据用户名查询用户信息（username,password,role）
     * @param username 用户名
     * @return 用户实体
     */
    User findByUsername(String username);

    /**
     * 根据用户名查询用户是否存在count>0表示存在，count=0表示不存在
     * @param systemUserInfo 被注册用户实体
     * @return 1or0 0表示不存在，1表示存在
     */
    int selectExistUserByUsername(SystemUserInfo systemUserInfo);

    /**
     * 向角色表插入角色信息
     * @param role 角色信息（角色名）
     * @return 角色id
     */
    int insertRolename(Role role);

    /**
     * 向system_user中插入具体信息
     * @param systemUserInfo 被注册用户实体
     * @return  用户id
     */
    int insertSystemUserInfo(SystemUserInfo systemUserInfo);

    /**
     * 向system_role_user 中插入数据关联system_user和system_role
     * @param userId 用户id
     * @param roleId 角色id
     * @return 改变的行数
     */
    int insertUserIdAndRoleId(@Param("userId") int userId,@Param("roleId") int roleId);

    /**
     * 查询角色名是否存在
     * @param role 角色实体
     * @return  角色id
     */
    int selectExistRoleName(Role role);

    /**
     * 查询所有系统用户信息
     * @return 系统用户信息模型
     */
    List<SystemUserInfoVo> selectAllSystemUserInfoByPage();

    /**
     * 向system_user更新user信息
     * @param systemUserInfo 实体模型
     * @return 更新的条数
     */
    int updateSystemInfoToSystemUser(SystemUserInfo systemUserInfo);

    /**
     * 向system_user_role更新用户角色关联信息
     * @param userRole 实体模型
     * @return 更新的条数
     */
    int updateSystemInfoToSystemUserRole(UserRole userRole);

    /**
     * 根据roleName查询roleId
     * @param userRole 模型
     * @return roleId
     */
    int selectRoleIdByRoleName(UserRole userRole);

    /**
     * 根据id删除system_user中的信息
     * @param id
     * @return
     */
    int deleteSystemInfoToSystemUser(Integer id);

    /**
     * 根据id(userId)删除system_user_role中的信息
     * @param id userId
     * @return
     */
    int deleteSystemInfoToSystemUserRole(Integer id);

}
