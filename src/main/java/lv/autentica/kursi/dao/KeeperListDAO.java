package lv.autentica.kursi.dao;

import lv.autentica.kursi.entity.KeeperListEntity;

/**
 * Created by maksims.senko on 2016.09.13..
 */
public interface KeeperListDAO  extends AbstractBaseDAO<KeeperListEntity> {

    KeeperListEntity getKeeperById(Integer keeperId);
}
