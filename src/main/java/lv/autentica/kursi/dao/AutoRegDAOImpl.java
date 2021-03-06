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
    public AutoRegEntity getCarById(Long carId)
    {
            return (AutoRegEntity) currentSession()
                    .createQuery("from " + entityName() + " where id = :carId ")
                    .setParameter("carId", carId)
                    .uniqueResult();
    }

    public List<AutoRegEntity> getCarsByKeeperId(Long keeperId) {

        List<AutoRegEntity> carList = currentSession()
                .createQuery("from " + entityName() + " where keeperId = :keeperId ")
                .setLong("keeperId", keeperId)
                .list();

        return carList;
    }

}
