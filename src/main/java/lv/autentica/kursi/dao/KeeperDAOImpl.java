package lv.autentica.kursi.dao;

import lv.autentica.kursi.entity.KeeperEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;
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
                        "select k.* from keeper_list as k " +
                        "left join auto_reg as a on k.\"ID\" = a.\"KEEPER_ID\" " +
                        "where a.\"ID\" is null"
                ).addEntity(KeeperEntity.class)
                .list();

        return keeperList;
    }
}
