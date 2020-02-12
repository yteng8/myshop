package com.yt.service.system.auth.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yt.entity.page.PageRequest;
import com.yt.entity.page.PageResult;
import com.yt.mapper.system.datadictionary.AdminDataDictionaryDao;
import com.yt.model.system.datadictionary.DataDictionary;
import com.yt.model.system.user.vo.SystemUserInfoVo;
import com.yt.service.system.auth.AdminDataDictionaryService;
import com.yt.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AdminDataDictionaryServiceImpl
 * @Description AdminDataDictionaryService实现类
 * @createTime 2020年02月12日 12:00:00
 */
@Service
public class AdminDataDictionaryServiceImpl implements AdminDataDictionaryService {

    @Autowired
    private AdminDataDictionaryDao adminDataDictionaryDao;

    @Override
    public PageResult getAllDataDictionary(Integer pageNum, Integer pageSize) {
        PageRequest pageQuery = new PageRequest();
        pageQuery.setPageNum(pageNum);
        pageQuery.setPageSize(pageSize);

        return PageUtils.getPageResult(pageQuery, getPageInfo(pageQuery));
    }

    /**
     * 调用分页插件完成分页
     *
     * @param pageRequest
     * @return
     */
    private PageInfo<DataDictionary> getPageInfo(PageRequest pageRequest) {
        Integer pageNum = pageRequest.getPageNum();
        Integer pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<DataDictionary> dds = adminDataDictionaryDao.selectAllDataDictionary();
        return new PageInfo<DataDictionary>(dds);
    }

    @Override
    public Map<String, Integer> addDataDictionary(Map<String, String> dictionary) {
        Map<String, Integer> msg = new HashMap<>();
        DataDictionary dataDictionary = new DataDictionary();
        dataDictionary.setTypeCode(dictionary.get("typeCode"));
        dataDictionary.setTypeName(dictionary.get("typeName"));
        dataDictionary.setName(dictionary.get("name"));
        // 如果存在则不再插入
        if (adminDataDictionaryDao.selectExistDataDictionary(dataDictionary) > 0) {
            msg.put("msg", 0);
        } else {
            int i = adminDataDictionaryDao.insertDataDictionary(dataDictionary);
            if (i==1){
                msg.put("msg",1);
            }else {
                msg.put("msg",-1);
            }
        }
        return msg;
    }

    @Override
    public Map<String,Integer>  updateDataDictionary(Map<String,String> dictionary) {
        Map<String,Integer> msg = new HashMap<>();
        DataDictionary dataDictionary = new DataDictionary();
        dataDictionary.setId(Integer.parseInt(dictionary.get("id")));
        dataDictionary.setTypeCode(dictionary.get("typeCode"));
        dataDictionary.setTypeName(dictionary.get("typeName"));
        dataDictionary.setName(dictionary.get("name"));
        int i = adminDataDictionaryDao.updateDataDictionary(dataDictionary);
        if (i>0){
            msg.put("msg",1);
        } else {
            msg.put("msg",-1);
        }
        return msg;
    }

    @Override
    public Map<String, Integer> deleteDataDictionary(Integer id) {
        Map<String,Integer> msg = new HashMap<>();
        int i = adminDataDictionaryDao.deleteDataDictionaryById(id);
        if (i==1){
            msg.put("msg",1);
        }else {
            msg.put("msg",-1);
        }
        return msg;
    }
}
