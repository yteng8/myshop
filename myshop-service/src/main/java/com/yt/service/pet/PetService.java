package com.yt.service.pet;

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

    Map<String,Integer> addPet(String title, int selling, double price, int age, String type, String variety, String sellAddress, String bornAddress, MultipartFile file1, MultipartFile file2, MultipartFile file3, MultipartFile mainFile, String description, Date addTime) throws IOException, NoInputException;
}
