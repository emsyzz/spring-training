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

    @Inject
    AutoRegDAO autoRegDAO;

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
                .createQuery(
                        "from KeeperEntity as k "/* +
                        "join AutoRegEntity as ar on ar.keeperId = k.id " +
                        "where ar.id is null"*/
                )
                .list();

        List<KeeperEntity> resultList = new ArrayList<>();

        for (KeeperEntity keeper : keeperList) {
            List<AutoRegEntity> carList = autoRegDAO.getCarsByKeeperId(keeper.getId());
            if (carList.isEmpty()) {
                resultList.add(keeper);
            }
        }

        return resultList;
    }
}
