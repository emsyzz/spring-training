package lv.autentica.kursi.dao;

import lv.autentica.kursi.entity.AutoRegEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;
import java.util.List;

/**
 * Created by maksims.senko on 2016.09.13..
 */
@Named
@Transactional
public class AutoRegDAOImpl extends AbstractBaseDAOImpl<AutoRegEntity>
        implements AutoRegDAO {

        @Override
        public AutoRegEntity getCarById(Long carId){
                return (AutoRegEntity) currentSession()
                        .createQuery("from " + entityName() + " where id = :carId ")
                        .setParameter("carId", carId)
                        .uniqueResult();
        }

//        @Override
//        public List<AutoRegEntity> findCarByBrand(String brandName){
//
//                return (List<AutoRegEntity>) currentSession()
//                        .createSQLQuery("select * from auto_reg where \"BRAND\" like :bindParam1 ")
//                        .addEntity(AutoRegEntity.class)
//                        .setParameter("bindParam1", brandName)
//                        .list();
//        }
}
