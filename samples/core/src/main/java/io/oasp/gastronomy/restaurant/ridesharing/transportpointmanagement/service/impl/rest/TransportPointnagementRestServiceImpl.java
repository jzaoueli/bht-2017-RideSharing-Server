package io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.service.impl.rest;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.logic.api.TransportPointmanagement;
import io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.logic.api.to.TransportPointEto;
import io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.service.api.rest.TransportPointmanagementRestService;

/**
 */
@Named("TransportPointmanagementRestService")
public class TransportPointnagementRestServiceImpl implements TransportPointmanagementRestService {

  private TransportPointmanagement transportPointManagement;

  @Inject
  public void setTransportPointManagement(TransportPointmanagement transportPointManagement) {

    this.transportPointManagement = transportPointManagement;
  }

  @Override
  @Deprecated
  public List<TransportPointEto> getAllTransportPoints() {

    List<TransportPointEto> allTransportPoints = this.transportPointManagement.findAllTransportPoints();
    return allTransportPoints;
  }

  @Override
  public TransportPointEto getTransportPoint(long id) {

    return this.transportPointManagement.findTransportPoint(id);
  }

  @Override
  @Deprecated
  public TransportPointEto createTransportPoint(TransportPointEto transportPointEto) {

    return this.transportPointManagement.saveTransportPoint(transportPointEto);
  }

  @Override
  public void deleteTransportPoint(long id) {

    this.transportPointManagement.deleteTransportPoint(id);
  }

  @Override
  public TransportPointEto saveTransportPoint(TransportPointEto transportPointEto) {

    return this.transportPointManagement.saveTransportPoint(transportPointEto);
  }

}
