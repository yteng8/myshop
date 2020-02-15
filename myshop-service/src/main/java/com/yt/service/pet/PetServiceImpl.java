package com.yt.service.pet;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yt.entity.page.PageRequest;
import com.yt.entity.page.PageResult;
import com.yt.exception.myexception.NoInputException;
import com.yt.mapper.pet.PetDao;
import com.yt.model.Pet;
import com.yt.model.system.datadictionary.DataDictionary;
import com.yt.util.FileUploadUtils;
import com.yt.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
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

    @Transactional
    @Override
    public Map<String, Integer> removePet(Integer id) {
        Map<String,Integer> msg = new HashMap<>();
        // 先查询是否有评论，有评论则先删除评论再删除图片再删除宠物信息
        Integer evaluationId = petDao.selectEvaluationIdByPetId(id);
        if(evaluationId != null){
            Integer flag1 = petDao.deleteEvaluationBySystem(evaluationId);
            boolean flag4 = fileUploadUtils.removeImage(petDao.selectImageName(id));
            Integer flag2 = petDao.deletePetBySystem(id);
            if(flag1 == 1 && flag2 == 1 && flag4){
                msg.put("msg",1);
            }else{
                msg.put("msg",-1);
            }
        }else{
            boolean flag5 = fileUploadUtils.removeImage(petDao.selectImageName(id));
            Integer flag3 = petDao.deletePetBySystem(id);
            if (flag3 == 1 && flag5){
                msg.put("msg",1);
            }else{
                msg.put("msg",-1);
            }
        }
        return msg;
    }

    @Transactional
    @Override
    public Map<String, Integer> modifyPet(String title, int selling, double price, int age, String type, String variety, String sellAddress, String bornAddress, MultipartFile file1, MultipartFile file2, MultipartFile file3, MultipartFile mainFile, String description, Date addTime, Integer id) throws IOException {
        Map<String,Integer> msg = new HashMap<>();
        int returnFlag = -1;
        if (fileUploadUtils.isImage(file1) && fileUploadUtils.isImage(file2) && fileUploadUtils.isImage(file3)&&fileUploadUtils.isImage(mainFile)){
            // 先删除原图片重新上传
            boolean flag1 = fileUploadUtils.removeImage(petDao.selectImageName(id));
            if (flag1) {
                String pic1 = fileUploadUtils.uploadFile(file1);
                String pic2 = fileUploadUtils.uploadFile(file2);
                String pic3 = fileUploadUtils.uploadFile(file3);
                String mainPic = fileUploadUtils.uploadFile(mainFile);
                Pet pet = new Pet();
                pet.setId(id);
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
                int flag2 = petDao.updatePetBySystem(pet);
                if(flag2 == 1){
                    returnFlag = 1;
                }
            }
        }
        msg.put("msg",returnFlag);
        return msg;
    }

    @Override
    public PageResult getAllPet(Integer pageNum, Integer pageSize) {
        PageRequest pageQuery = new PageRequest();
        pageQuery.setPageNum(pageNum);
        pageQuery.setPageSize(pageSize);
        return PageUtils.getPageResult(pageQuery, getPageInfo(pageQuery));
    }

    private PageInfo<Pet> getPageInfo(PageRequest pageRequest) {
        Integer pageNum = pageRequest.getPageNum();
        Integer pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Pet> pets =  petDao.selectAllPet();
        return new PageInfo<Pet>(pets);
    }
}
