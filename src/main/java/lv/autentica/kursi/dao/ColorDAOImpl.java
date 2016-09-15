package lv.autentica.kursi.dao;

import lv.autentica.kursi.entity.ColorEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;

/**
 * Created by maksims.senko on 2016.09.13..
 */
@Named
@Transactional
public class ColorDAOImpl extends AbstractBaseDAOImpl<ColorEntity>
        implements ColorDAO {

        @Override
        public ColorEntity getColorById(Long colorId){
                return (ColorEntity) currentSession()
                        .createQuery("from " + entityName() + " where id = :colorId ")
                        .setParameter("colorId", colorId)
                        .uniqueResult();
        }
}
