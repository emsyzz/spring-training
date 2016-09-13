package lv.autentica.kursi.dao;

import lv.autentica.kursi.entity.ColorListEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;

/**
 * Created by maksims.senko on 2016.09.13..
 */
@Named
@Transactional
public class ColorListDAOImpl extends AbstractBaseDAOImpl<ColorListEntity>
        implements ColorListDAO {
}
