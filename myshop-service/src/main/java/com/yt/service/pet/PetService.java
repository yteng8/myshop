package com.yt.service.pet;

import com.yt.entity.page.PageResult;
import com.yt.exception.myexception.NoInputException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PetService
 * @Description 宠物服务类
 * @createTime 2020年02月14日 14:01:00
 */

public interface PetService {

    /**
     * 添加宠物基本信息
     * @param title
     * @param selling
     * @param price
     * @param age
     * @param type
     * @param variety
     * @param sellAddress
     * @param bornAddress
     * @param file1
     * @param file2
     * @param file3
     * @param mainFile
     * @param description
     * @param addTime
     * @return
     * @throws IOException
     * @throws NoInputException
     */
    Map<String,Integer> addPet(String title, int selling, double price, int age, String type, String variety, String sellAddress, String bornAddress, MultipartFile file1, MultipartFile file2, MultipartFile file3, MultipartFile mainFile, String description, Date addTime) throws IOException, NoInputException;

    /**
     * 删除宠物基本信息
     * @param id
     * @return
     */
    Map<String,Integer> removePet(Integer id);

    /**
     * 根据宠物id修改宠物信息
     * @param title
     * @param selling
     * @param price
     * @param age
     * @param type
     * @param variety
     * @param sellAddress
     * @param bornAddress
     * @param file1
     * @param file2
     * @param file3
     * @param mainFile
     * @param description
     * @param addTime
     * @param id
     * @return
     */
    Map<String,Integer> modifyPet(String title, int selling, double price, int age, String type, String variety, String sellAddress, String bornAddress, MultipartFile file1, MultipartFile file2, MultipartFile file3, MultipartFile mainFile, String description, Date addTime,Integer id) throws IOException;


    PageResult getAllPet(Integer pageNum,Integer pageSize);
}
