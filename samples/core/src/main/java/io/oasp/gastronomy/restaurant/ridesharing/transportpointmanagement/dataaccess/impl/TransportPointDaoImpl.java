package io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.dataaccess.impl;

import javax.inject.Named;

import io.oasp.gastronomy.restaurant.general.dataaccess.base.dao.ApplicationMasterDataDaoImpl;
import io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.dataaccess.api.TransportPointEntity;
import io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.dataaccess.api.dao.TransportPointDao;

@Named
public class TransportPointDaoImpl extends ApplicationMasterDataDaoImpl<TransportPointEntity>
    implements TransportPointDao {

  public TransportPointDaoImpl() {

    super();
  }

  @Override
  public Class<TransportPointEntity> getEntityClass() {

    return TransportPointEntity.class;
  }
}
