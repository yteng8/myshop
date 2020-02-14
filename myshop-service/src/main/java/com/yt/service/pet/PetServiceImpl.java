package com.yt.service.pet;

import com.yt.exception.myexception.NoInputException;
import com.yt.mapper.pet.PetDao;
import com.yt.model.Pet;
import com.yt.util.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PetServiceImpl
 * @Description 宠物服务实现类
 * @createTime 2020年02月14日 14:01:00
 */
@Service
public class PetServiceImpl implements PetService{

    @Autowired
    private FileUploadUtils fileUploadUtils;

    @Autowired
    private PetDao petDao;

    @Override
    public Map<String, Integer> addPet(String title, int selling, double price, int age, String type, String variety, String sellAddress, String bornAddress, MultipartFile file1, MultipartFile file2, MultipartFile file3, MultipartFile mainFile, String description, Date addTime) throws IOException, NoInputException {
        Map<String, Integer> msg = new HashMap<>();
        if (fileUploadUtils.isImage(file1) && fileUploadUtils.isImage(file2) && fileUploadUtils.isImage(file3)&&fileUploadUtils.isImage(mainFile)){
            String pic1 = fileUploadUtils.uploadFile(file1);
            String pic2 = fileUploadUtils.uploadFile(file2);
            String pic3 = fileUploadUtils.uploadFile(file3);
            String mainPic = fileUploadUtils.uploadFile(mainFile);
            Pet pet = new Pet();
            pet.setTitle(title);
            pet.setSelling(selling);
            pet.setPrice(price);
            pet.setAge(age);
            pet.setType(type);
            pet.setVariety(variety);
            pet.setBornAddress(bornAddress);
            pet.setSellAddress(sellAddress);
            pet.setDescription(description);
            pet.setAddTime(addTime);
            pet.setPic1(pic1);
            pet.setPic2(pic2);
            pet.setPic3(pic3);
            pet.setMainPic(mainPic);

            int flag = petDao.insertPetBySystem(pet);
            if (flag == 1){
                msg.put("msg",1);
            }else {
                msg.put("msg",-1);
            }
        } else {
            throw new NoInputException("图片格式不正确");
        }
        return msg;
    }
}
