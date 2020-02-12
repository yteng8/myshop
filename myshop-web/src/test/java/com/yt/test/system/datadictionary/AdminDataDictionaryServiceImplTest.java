package com.yt.test.system.datadictionary;

import com.yt.mapper.repository.UserRepository;
import com.yt.mapper.system.datadictionary.AdminDataDictionaryDao;
import com.yt.test.Test1;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AdminDataDictionaryServiceImplTest
 * @Description TODO
 * @createTime 2020年02月12日 13:32:00
 */
public class AdminDataDictionaryServiceImplTest extends Test1 {

    @Autowired
    private AdminDataDictionaryDao adminDataDictionaryDao;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getAllDataDictionary() {
        //System.out.println(adminDataDictionaryDao.selectAllDataDictionary().toString());

        //System.out.println(adminDataDictionaryDao.test());
        System.out.println(adminDataDictionaryDao);
        System.out.println(adminDataDictionaryDao.selectAllDataDictionary());
        System.out.println(userRepository.findByUsername("yt"));
    }
}