package lv.autentica.kursi.dao;

import lv.autentica.kursi.entity.ColorEntity;

/**
 * Created by maksims.senko on 2016.09.13..
 */

public interface ColorDAO extends AbstractBaseDAO<ColorEntity> {

    ColorEntity getColorById(Long keeperId);

}
