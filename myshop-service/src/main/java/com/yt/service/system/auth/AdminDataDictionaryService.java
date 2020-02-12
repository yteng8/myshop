package com.yt.service.system.auth;

import com.yt.entity.page.PageResult;
import com.yt.model.system.datadictionary.DataDictionary;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AdminDataDictionaryService
 * @Description admin用户数据字典服务
 * @createTime 2020年02月12日 12:00:00
 */
public interface AdminDataDictionaryService {
    /**
     * admin查询所有数据字典
     * @return
     */
    PageResult getAllDataDictionary(Integer pageNum, Integer pageSize);

    /**
     * 像数据字典表中插入数据字典
     * @param dictionary dictionary实体
     * @return
     */
    Map<String,Integer> addDataDictionary(Map<String,String> dictionary);

    /**
     * 根据id修改数据字典
     * @param dictionary
     * @return 1:成功 -1:失败
     */
    Map<String,Integer>  updateDataDictionary(Map<String,String> dictionary);

    /**
     * 根据id删除数据字典
     * @param id
     * @return
     */
    Map<String,Integer> deleteDataDictionary(Integer id);
}
