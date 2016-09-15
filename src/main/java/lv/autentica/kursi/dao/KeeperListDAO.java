package lv.autentica.kursi.dao;

import lv.autentica.kursi.entity.AutoRegEntity;
import lv.autentica.kursi.entity.KeeperListEntity;

import javax.inject.Named;

/**
 * Created by maksims.senko on 2016.09.15..
 */

public interface KeeperListDAO extends AbstractBaseDAO<KeeperListEntity> {

    KeeperListEntity getKeeperById(Long keeperId);
}
