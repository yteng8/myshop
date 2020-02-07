package com.yt.service.system.auth;

import com.yt.entity.page.PageResult;

import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName LoginService
 * @Description 超级系统管理员管理子管理员和客服人员服务
 * @createTime 2020年02月05日 11:40:00
 */
public interface AdminAuthService {
    /**
     * 超级管理员注册子管理员和客服人员服务
     * @param registerUser 被注册人员的基本信息
     * @return msg:-1 插入失败， msg：0 用户名已经存在， msg：1 插入成功
     */
    Map<String, Integer> registerUserService(Map<String,String> registerUser);

    /**
     * 超级管理员分页查询所有子管理员和客服管理员信息
     * @param pageNum 请求的当前页码
     * @param pageSize 每页显示的数量
     * @return 所有结果
     */
    PageResult getAllSystemUserInfo(Integer pageNum,Integer pageSize);

    Map<String,Integer> modifySystemUserInfo(Map<String,String> modifyUser);
}
