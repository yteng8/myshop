package com.yt.mapper.pet;

import com.yt.entity.image.ImageName;
import com.yt.model.Pet;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PetDao
 * @Description 宠物dao层
 * @createTime 2020年02月14日 14:02:00
 */
@Repository
public interface PetDao {

    /**
     * 系统管理员添加宠物信息
     * @param pet
     * @return
     */
    int insertPetBySystem(Pet pet);

    /**
     * 根据宠物id系统管理员删除宠物信息
     * @param id
     * @return
     */
    Integer deletePetBySystem(Integer id);

    /**
     * 根据评论id删除评论信息
     * @param evaluationId
     * @return
     */
    Integer deleteEvaluationBySystem(Integer evaluationId);

    /**
     * 根据宠物id查询评论id
     * @param id
     * @return
     */
    Integer selectEvaluationIdByPetId(Integer id);

    /**
     * 根据宠物id查询图片路径
     * @param id
     * @return
     */
    ImageName selectImageName(Integer id);

    /**
     * 根据宠物id更新宠物信息
     * @param pet
     * @return
     */
    Integer updatePetBySystem(Pet pet);

    /**
     * 查询所有宠物信息
     * @return
     */
    List<Pet> selectAllPet();

    /**
     * 根据evaluationId查询所有评论信息
     * @param evaluationId
     * @return
     */
    List<String> selectEvaluationByPetId(Integer evaluationId);

}
