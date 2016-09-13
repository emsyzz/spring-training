package lv.autentica.kursi.dao;

import lv.autentica.kursi.entity.AutoRegEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by maksims.senko on 2016.09.13..
 */
@Transactional
public interface AutoRegDAO extends AbstractBaseDAO<AutoRegEntity> {

    AutoRegEntity getCarById(Long carId);

}
