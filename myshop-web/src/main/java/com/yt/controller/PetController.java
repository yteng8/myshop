package com.yt.controller;

import com.yt.exception.myexception.NoInputException;
import com.yt.service.pet.PetService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PetController
 * @Description 宠物信息控制器
 * @createTime 2020年02月14日 13:58:00
 */
@RestController
@RequestMapping("/system/protected/")
public class PetController {
    @Autowired
    private PetService petService;

    @PostMapping("/pet")
    @PreAuthorize("hasAnyRole({'ADMIN','CADMIN'})")
    public Map<String,Integer> addPet(@RequestParam("title") String title, @RequestParam("selling") int selling, @RequestParam("price") double price, @RequestParam("age") int age, @RequestParam("type") String type,
                                      @RequestParam("variety") String variety, @RequestParam("sellAddress") String sellAddress, @RequestParam("bornAddress") String bornAddress, @RequestParam("pic1") MultipartFile file1,
                                      @RequestParam("pic2") MultipartFile file2, @RequestParam("pic3") MultipartFile file3, @RequestParam("mainPic") MultipartFile mainFile, @RequestParam("description") String description,
                                      @RequestParam("addTime") Date addTime) throws IOException, NoInputException {
        return petService.addPet(title,selling,price,age,type,variety,sellAddress,bornAddress,file1,file2,file3,mainFile,description,addTime);
    }
}
