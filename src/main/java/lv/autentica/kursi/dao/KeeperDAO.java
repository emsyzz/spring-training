package lv.autentica.kursi.dao;

import lv.autentica.kursi.entity.KeeperEntity;

/**
 * Created by maksims.senko on 2016.09.13..
 */

public interface KeeperDAO extends AbstractBaseDAO<KeeperEntity> {

    KeeperEntity getKeeperById(Long keeperId);

}
