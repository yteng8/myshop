package com.yt.mapper.pet;

import com.yt.model.Pet;
import org.springframework.stereotype.Repository;

import java.sql.Date;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PetDao
 * @Description 宠物dao层
 * @createTime 2020年02月14日 14:02:00
 */
@Repository
public interface PetDao {

    int insertPetBySystem(Pet pet);


}
