package com.yt.controller.system_auth;

import com.yt.entity.page.PageResult;
import com.yt.exception.myexception.NoInputException;
import com.yt.service.system.auth.AdminAuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "超级管理员为子管理员和客服管理员注册", notes = "注册的数据有username(String)用户名, age(int)年龄," +
            " entryTime(String)入职时间, password(String)密码, real(String)真实姓名, sex(int)性别, roleName(String)角色名称 ; msg:0 表示重复插入，msg:-1 表示插入失败, msg:1 表示插入成功;输入不能为空且字段必须全部全部填写")
    @ApiImplicitParam(name = "registerUser",value = "被注册用户的详细信息",required = true)
    @PostMapping("systemUserInfo")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String,Integer> registerUser(@RequestBody Map<String,String> registerUser) throws NoInputException{
        if (registerUser == null || registerUser.size() != 7){
            throw new NoInputException("输入异常");
        }
        return adminAuthService.registerUserService(registerUser);
    }

    @ApiOperation(value = "超级管理员查询子管理员和客服管理员信息",notes = "请求参数写在url上, 返回分页的具体json数据; 返回的数据有pageNum(int) 当前页码, pageSize(int)每页显示的数量, totalSize(int)记录总数," +
            " totalPages(int)页码总数, content(List<?>)数据模型")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageNum",value = "页码"),@ApiImplicitParam(name = "pageSize",value = "每页显示的数量")})
    @GetMapping("systemUserInfo")
    @PreAuthorize("hasRole('ADMIN')")
    public PageResult getAllSystemUserInfo(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize) throws NoInputException {
        if (pageNum == null || pageSize == null){
            throw new NoInputException("分页异常");
        }
        return adminAuthService.getAllSystemUserInfo(pageNum,pageSize);
    }

    @ApiOperation(value = "超级管理员修改子管理员和客服管理员信息")
    @ApiImplicitParam(name = "modifyUser",value = "必填6个值：id(int),username,age(int),sex(int),real,roleName;返回msg：-1失败，msg：1成功")
    @PutMapping("systemUserInfo")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String,Integer> updateSystemUserInfo(@RequestBody Map<String,String> modifyUser) throws NoInputException{
        if (modifyUser == null || modifyUser.size()!=6){
            throw new NoInputException("输入异常");
        }
        return adminAuthService.modifySystemUserInfo(modifyUser);
    }

    @DeleteMapping("systemUserInfo/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String,Integer> removeSystemUserInfo(@PathVariable("id") Integer id) throws NoInputException {
        if (id == null ){
            throw new NoInputException("删除id值为空");
        }
        return adminAuthService.removeSystemUserInfoById(id);
    }



}
