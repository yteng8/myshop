package com.yt.mapper.repository;

import com.yt.entity.User;
import com.yt.model.user.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserRepository
 * @Description 用户的登录操作
 * @createTime 2020年02月04日 10:48:00
 */
public interface UserRepository extends CrudRepository<User, Integer>{
    User findByUsername(String username);

    /**
     *
     * @param role 角色信息（角色名）
     * @return 角色id
     */
    int insertRolename(Role role);

    int insertUsernameAndPassword(User user);

    int insertUserIdAndRoleId(@Param("userId") int userId,@Param("roleId") int roleId);

}
