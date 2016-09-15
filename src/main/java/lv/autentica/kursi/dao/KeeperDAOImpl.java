package lv.autentica.kursi.dao;

import lv.autentica.kursi.entity.KeeperEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;

/**
 * Created by maksims.senko on 2016.09.13..
 */
@Named
@Transactional
public class KeeperDAOImpl extends AbstractBaseDAOImpl<KeeperEntity>
        implements KeeperDAO {

        @Override
        public KeeperEntity getKeeperById(Long keeperId){
                return (KeeperEntity) currentSession()
                        .createQuery("from " + entityName() + " where id = :keeperId ")
                        .setParameter("keeperId", keeperId)
                        .uniqueResult();
        }
}
