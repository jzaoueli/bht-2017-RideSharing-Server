package io.oasp.logistic.ridesharing.transportpointmanagement.dataaccess.api.dao;


import io.oasp.logistic.ridesharing.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.module.jpa.dataaccess.api.MasterDataDao;
import io.oasp.logistic.ridesharing.transportpointmanagement.dataaccess.api.TransportPointEntity;

public interface TransportPointDao extends ApplicationDao<TransportPointEntity>, MasterDataDao<TransportPointEntity> {

}
