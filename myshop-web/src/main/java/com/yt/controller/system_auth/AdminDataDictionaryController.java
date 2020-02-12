package com.yt.controller.system_auth;

import com.yt.entity.page.PageResult;
import com.yt.exception.myexception.NoInputException;
import com.yt.model.system.datadictionary.DataDictionary;
import com.yt.service.system.auth.AdminDataDictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AdminDataDictionaryController
 * @Description admin用户对数据字典的管理
 * @createTime 2020年02月12日 11:56:00
 */
@RestController
@Api(tags = "admin用户对数据字典管理")
@RequestMapping("/system/protected/dataDictionary")
public class AdminDataDictionaryController {

    @Autowired
    private AdminDataDictionaryService adminDataDictionaryService;

    @ApiOperation(value = "超级管理员查询所有数据字典")
    @GetMapping("")
    public PageResult getAllDataDictionary(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize) throws NoInputException {
        if (pageNum == null || pageSize == null) {
            throw new NoInputException("分页异常");
        }
        return adminDataDictionaryService.getAllDataDictionary(pageNum,pageSize);
    }

    @ApiOperation(value = "超级管理员新增数据字典")
    @ApiImplicitParam(name = "dictionary", value = "三个字段,typeCode,typeName,name")
    @PostMapping("")
    public Map<String,Integer> addDataDictionary(@RequestBody Map<String,String> dictionary) throws NoInputException {
        if(dictionary == null || dictionary.size() != 3){
            throw new NoInputException("输入异常");
        }
        return adminDataDictionaryService.addDataDictionary(dictionary);
    }

    @ApiOperation(value = "超级管理员修改数据字典",notes = "返回1成功，-1失败")
    @ApiImplicitParam(name = "dictionary",value = "四个字段,id,typeCode,typeName,name")
    @PutMapping("")
    public Map<String,Integer> updateDataDictionary(@RequestBody Map<String,String> dictionary) throws NoInputException {
        if(dictionary == null || dictionary.size() != 4){
            throw new NoInputException("输入异常");
        }
        return adminDataDictionaryService.updateDataDictionary(dictionary);
    }

    @ApiOperation(value = "超级管理员删除数据字典",notes = "返回1成功，-1失败")
    @ApiImplicitParam(name = "id",value = "字典id")
    @DeleteMapping("/{id}")
    public Map<String,Integer> removeDataDictionary(@PathVariable("id") Integer id) throws NoInputException {
        if (id == null){
            throw new NoInputException("输入异常");
        }
        return adminDataDictionaryService.deleteDataDictionary(id);
    }




}
