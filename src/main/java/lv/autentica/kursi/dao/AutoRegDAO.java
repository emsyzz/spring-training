package lv.autentica.kursi.dao;

import lv.autentica.kursi.entity.AutoRegEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by maksims.senko on 2016.09.13..
 */

public interface AutoRegDAO extends AbstractBaseDAO<AutoRegEntity> {

    AutoRegEntity getCarById(Long carId);

//    List<AutoRegEntity> findCarByBrand(String brandName);

}
