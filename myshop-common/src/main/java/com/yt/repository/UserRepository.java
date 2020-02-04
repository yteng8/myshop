package com.yt.repository;

import com.yt.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserRepository
 * @Description 根据用户名查找用户
 * @createTime 2020年02月04日 10:48:00
 */
public interface UserRepository  {
    User findByUsername(String username);
}
