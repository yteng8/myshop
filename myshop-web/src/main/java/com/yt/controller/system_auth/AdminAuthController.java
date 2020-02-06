package com.yt.controller.system_auth;

import com.yt.exception.myexception.NoInputException;
import com.yt.service.system.auth.AdminAuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AdminAuthController
 * @Description 超级管理员管理子管理员和客服管理员
 * @createTime 2020年02月04日 14:51:00
 */
@Api(tags = "admin超级管理员的人员管理")
@RestController
@RequestMapping("/system/protected/auth/")
public class AdminAuthController {

    @Autowired
    private AdminAuthService adminAuthService;

    @ApiOperation(value = "超级管理员为子管理员和客服管理员注册", notes = "msg:0 表示重复插入，msg:-1 表示插入失败, msg:1 表示插入成功;输入不能为空且字段必须全部全部填写")
    @ApiImplicitParam(name = "registerUser",value = "被注册用户的详细信息",required = true)
    @PostMapping("register")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String,Integer> registerUser(@RequestBody Map<String,String> registerUser) throws NoInputException{
        if (registerUser == null || registerUser.size() != 7){
            throw new NoInputException("输入异常");
        }
        return adminAuthService.registerUserService(registerUser);
    }



}
