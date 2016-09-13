package lv.autentica.kursi.dao;

import lv.autentica.kursi.entity.KeeperListEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;

/**
 * Created by maksims.senko on 2016.09.13..
 */
@Named
@Transactional
public class KeeperListDAOImpl extends AbstractBaseDAOImpl<KeeperListEntity>
        implements KeeperListDAO {
}
