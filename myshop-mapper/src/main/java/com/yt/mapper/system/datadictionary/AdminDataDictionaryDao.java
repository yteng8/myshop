package com.yt.mapper.system.datadictionary;

import com.yt.model.system.datadictionary.DataDictionary;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AdminDataDictionaryDao
 * @Description admin用户管理数据字典的数据访问层
 * @createTime 2020年02月12日 12:11:00
 */
@Repository
public interface AdminDataDictionaryDao {

    /**
     * 查询所有数据字典
     * @return 数据字典列表
     */
    List<DataDictionary> selectAllDataDictionary();

    /**
     * 插入数据字典
     * @return 1 成功 -1 失败
     */
    int insertDataDictionary(DataDictionary dataDictionary);

    /**
     * 根据typeCode和name查询数据字典是否存在
     * @param dataDictionary
     * @return >=1 存在   0：不存在
     */
    int selectExistDataDictionary(DataDictionary dataDictionary);

    /**
     * 修改数据字典
     * @param dataDictionary
     * @return
     */
    int updateDataDictionary(DataDictionary dataDictionary);

    /**
     * 根据id删除数据字典
     * @param id
     * @return
     */
    int deleteDataDictionaryById(Integer id);


}
