package com.yt.controller;

import com.yt.entity.page.PageResult;
import com.yt.exception.myexception.NoInputException;
import com.yt.service.pet.PetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
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
@Api(tags = "宠物信息接口")
@RestController
// @RequestMapping("/system/protected/")
public class PetController {
    @Autowired
    private PetService petService;

    @ApiOperation(value = "系统管理员添加宠物信息")
    @PostMapping("/system/protected/pet")
    @PreAuthorize("hasAnyRole({'ADMIN','CADMIN'})")
    public Map<String,Integer> addPet(@RequestParam("title") String title, @RequestParam("selling") int selling, @RequestParam("price") double price, @RequestParam("age") int age, @RequestParam("type") String type,
                                      @RequestParam("variety") String variety, @RequestParam("sellAddress") String sellAddress, @RequestParam("bornAddress") String bornAddress, @RequestParam("pic1") MultipartFile file1,
                                      @RequestParam("pic2") MultipartFile file2, @RequestParam("pic3") MultipartFile file3, @RequestParam("mainPic") MultipartFile mainFile, @RequestParam("description") String description,
                                      @RequestParam("addTime") Date addTime) throws IOException, NoInputException {
        return petService.addPet(title,selling,price,age,type,variety,sellAddress,bornAddress,file1,file2,file3,mainFile,description,addTime);
    }

    @ApiOperation(value = "系统管理员删除宠物相关信息")
    @ApiImplicitParam(name = "id",value = "宠物id")
    @DeleteMapping("/system/protected/pet/{id}")
    @PreAuthorize("hasAnyRole({'ADMIN','CADMIN'})")
    public Map<String,Integer> removePet(@PathVariable("id") Integer id) throws NoInputException {
        if(id == null){
            throw new NoInputException("宠物id为空");
        }
        return petService.removePet(id);
    }

    @ApiOperation(value = "系统管理员修改宠物信息")
    @PutMapping("/system/protected/pet/{id}")
    @PreAuthorize("hasAnyRole({'ADMIN','CADMIN'})")
    public Map<String,Integer> modifyPet(@PathVariable("id") Integer id,@RequestParam("title") String title, @RequestParam("selling") int selling, @RequestParam("price") double price, @RequestParam("age") int age, @RequestParam("type") String type,
                                         @RequestParam("variety") String variety, @RequestParam("sellAddress") String sellAddress, @RequestParam("bornAddress") String bornAddress, @RequestParam("pic1") MultipartFile file1,
                                         @RequestParam("pic2") MultipartFile file2, @RequestParam("pic3") MultipartFile file3, @RequestParam("mainPic") MultipartFile mainFile, @RequestParam("description") String description,
                                         @RequestParam("addTime") Date addTime) throws NoInputException, IOException {
        if (id == null){
            throw new NoInputException("宠物id为空");
        }
        return petService.modifyPet(title,selling,price,age,type,variety,sellAddress,bornAddress,file1,file2,file3,mainFile,description,addTime,id);
    }

    @GetMapping("/pet")
    public PageResult getAllPet(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) throws NoInputException {
        if (pageNum == null || pageSize == null) {
            throw new NoInputException("分页异常");
        }
        return petService.getAllPet(pageNum,pageSize);
    }

}
