package lv.autentica.kursi.dao;

import lv.autentica.kursi.entity.KeeperEntity;

import java.util.List;

public interface KeeperDAO extends AbstractBaseDAO<KeeperEntity> {

    KeeperEntity getKeeperById(Long keeperId);

    List getKeepersWithoutCars();

}
