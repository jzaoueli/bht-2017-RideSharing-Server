package io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.logic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import io.oasp.gastronomy.restaurant.general.common.api.constants.PermissionConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.oasp.gastronomy.restaurant.general.logic.base.AbstractComponentFacade;
import io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.common.api.TransportPoint;
import io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.dataaccess.api.TransportPointEntity;
import io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.dataaccess.api.dao.TransportPointDao;
import io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.logic.api.TransportPointmanagement;
import io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.logic.api.to.TransportPointEto;

@Named
@Component
@Transactional
public class TransportPointmanagementImpl extends AbstractComponentFacade implements TransportPointmanagement {


  private static final Logger LOG = LoggerFactory.getLogger(TransportPointmanagementImpl.class);

  private TransportPointDao transportPointDao;

  @Inject
  public void setTransportPointDao(TransportPointDao transportPointDao) {

    this.transportPointDao = transportPointDao;
  }

  public TransportPointDao getTransportPointDao() {

    return this.transportPointDao;
  }

  @RolesAllowed(PermissionConstants.FIND_TRANSPORTPOINT)
  @Override
  public TransportPointEto findTransportPoint(Long id) {

    return getBeanMapper().map(getTransportPointDao().find(id), TransportPointEto.class);
  }

  @RolesAllowed(PermissionConstants.FIND_TRANSPORTPOINT)
  @Override
  public List<TransportPointEto> findAllTransportPoints() {

    List<TransportPointEntity> transportPoints = getTransportPointDao().findAll();
    List<TransportPointEto> transportPointsBo = new ArrayList<>();

    for (TransportPointEntity transportPoint : transportPoints) {
      transportPointsBo.add(getBeanMapper().map(transportPoint, TransportPointEto.class));
    }

    return transportPointsBo;
  }

  @RolesAllowed(PermissionConstants.SAVE_TRANSPORTPOINT)
  @Override
  public TransportPointEto saveTransportPoint(TransportPoint transportPoint) {

    Objects.requireNonNull(transportPoint, "transportPoint");

    Long id = transportPoint.getId();
    TransportPointEntity targetTransportPoint = null;

    if (id != null) {
      targetTransportPoint = getTransportPointDao().find(id);
    }
    if (targetTransportPoint == null) {
      // TransportPoint is new: -> create
      LOG.debug("Saving TransportPoint with id '{}' to the database.", id);
    } else {
      // TransportPoint already exists: -> Update
      LOG.debug("Updating TransportPoint with id '{}' in the database.", id);
      if (!Objects.equals(targetTransportPoint.getName(), transportPoint.getName())) {
        LOG.debug("Changing login of TransportPoint with id '{}' from '{}' to '{}' in the database.", id,
            targetTransportPoint.getName(), transportPoint.getName());
      }
    }
    TransportPointEntity persistedTransportPoint =
        getTransportPointDao().save(getBeanMapper().map(transportPoint, TransportPointEntity.class));
    return getBeanMapper().map(persistedTransportPoint, TransportPointEto.class);
  }

  @RolesAllowed(PermissionConstants.DELETE_TRANSPORTPOINT)
  @Override
  public void deleteTransportPoint(Long transportPointId) {

    getTransportPointDao().delete(transportPointId);

  }

}
