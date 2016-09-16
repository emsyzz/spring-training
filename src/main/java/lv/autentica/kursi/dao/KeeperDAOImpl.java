package lv.autentica.kursi.dao;

import lv.autentica.kursi.entity.AutoRegEntity;
import lv.autentica.kursi.entity.KeeperEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@Transactional
public class KeeperDAOImpl
        extends AbstractBaseDAOImpl<KeeperEntity>
        implements KeeperDAO
{

    @Override
    public KeeperEntity getKeeperById(Long keeperId)
    {
        return (KeeperEntity) currentSession()
                .createQuery("from " + entityName() + " where id = :keeperId ")
                .setParameter("keeperId", keeperId)
                .uniqueResult();
    }

    public List<KeeperEntity> getKeepersWithoutCars()
    {
        List<KeeperEntity> keeperList = currentSession()
                .createSQLQuery(
                        "select * from keeper_list where \"ID\" not in (select \"KEEPER_ID\" from auto_reg) "
                ).addEntity(KeeperEntity.class)
                .list();

        return keeperList;
    }
}
