package lv.autentica.kursi.dao;

import lv.autentica.kursi.entity.FilmCatalogEntity;

import javax.inject.Named;
import javax.transaction.Transactional;

@Named
@Transactional
public class FilmCatalogDAOImpl extends AbstractBaseDAOImpl<FilmCatalogEntity>
        implements FilmCatalogDAO {
    
}
