package lv.autentica.kursi.dao;

import lv.autentica.kursi.entity.ColorListEntity;

/**
 * Created by maksims.senko on 2016.09.13..
 */
public interface ColorListDAO  extends AbstractBaseDAO<ColorListEntity> {

    ColorListEntity getColorById(Integer colorId);
}
