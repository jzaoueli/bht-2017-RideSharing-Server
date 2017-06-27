package io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.dataaccess.impl;

import javax.inject.Named;
import javax.persistence.TypedQuery;

import io.oasp.gastronomy.restaurant.general.common.api.constants.NamedQueries;
import io.oasp.gastronomy.restaurant.general.dataaccess.base.dao.ApplicationMasterDataDaoImpl;
import io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.dataaccess.CGMemberEntity;
import io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.dataaccess.dao.CGMemberDao;
import io.oasp.gastronomy.restaurant.ridesharing.general.CGUserProfile;

@Named
public class CGMemberDaoImpl extends ApplicationMasterDataDaoImpl<CGMemberEntity> implements CGMemberDao {

  public CGMemberDaoImpl() {

    super();
  }

  @Override
  public Class<CGMemberEntity> getEntityClass() {

    return CGMemberEntity.class;
  }

  @Override
  public CGUserProfile findByName(String name) {
    TypedQuery<CGMemberEntity> query = getEntityManager().createNamedQuery(NamedQueries.GET_CG_MEMBER_BY_NAME, CGMemberEntity.class);
    query.setParameter("name", name);
    return query.getSingleResult();
  }
}
