package io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.dataaccess.api.dao;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.dataaccess.api.TransportPointEntity;
import io.oasp.module.jpa.dataaccess.api.MasterDataDao;

/**
 * @author Jihed
 *
 */
public interface TransportPointDao extends ApplicationDao<TransportPointEntity>, MasterDataDao<TransportPointEntity> {

}
