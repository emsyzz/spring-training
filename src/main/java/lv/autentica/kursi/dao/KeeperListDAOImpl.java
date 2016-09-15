package lv.autentica.kursi.dao;

import lv.autentica.kursi.entity.AutoRegEntity;
import lv.autentica.kursi.entity.KeeperListEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;

/**
 * Created by maksims.senko on 2016.09.15..
 */
@Named
@Transactional
public class KeeperListDAOImpl  extends AbstractBaseDAOImpl<KeeperListEntity>
        implements KeeperListDAO {

        @Override
        public KeeperListEntity getKeeperById(Long keeperId){
                return (KeeperListEntity) currentSession()
                        .createQuery("from " + entityName() + " where id = :bindParam1 ")
                        .setParameter("bindParam1", keeperId)
                        .uniqueResult();
        }
}
