package io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.dataaccess.impl;

import javax.inject.Named;

import io.oasp.gastronomy.restaurant.general.dataaccess.base.dao.ApplicationMasterDataDaoImpl;
import io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.dataaccess.CGMemberEntity;
import io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.dataaccess.dao.CGMemberDao;

@Named
public class CGMemberDaoImpl extends ApplicationMasterDataDaoImpl<CGMemberEntity> implements CGMemberDao {

  public CGMemberDaoImpl() {

    super();
  }

  @Override
  public Class<CGMemberEntity> getEntityClass() {

    return CGMemberEntity.class;
  }
}
