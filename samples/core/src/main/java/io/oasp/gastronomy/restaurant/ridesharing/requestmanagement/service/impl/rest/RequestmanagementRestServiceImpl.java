package io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.service.impl.rest;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.logic.api.Requestmanagement;
import io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.logic.api.to.RequestEto;
import io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.service.api.rest.RequestmanagementRestService;

/**
 */
@Named("RequestmanagementRestService")
public class RequestmanagementRestServiceImpl implements RequestmanagementRestService {

  private Requestmanagement requestmanagement;

  /**
   * @param requestManagement the requestManagement to be set
   */
  @Inject
  public void setRequestmanagement(Requestmanagement requestManagement) {

    this.requestmanagement = requestManagement;
  }

  @Override
  public List<RequestEto> getAllRequest() {

    return this.requestmanagement.findAllRequests();
  }

  @Override
  public RequestEto getRequest(long id) {

    return this.requestmanagement.findRequest(id);
  }

  // although login is not explicitly needed here, the path structure is intentionally chosen
  // it is up to the GUI-Team to either insert a (maybe redundant) call on getRequest or to leave it
  // like that and do the update right in the view of a previously "loaded" Request

  @Override
  @Deprecated
  public void updateRequest(RequestEto requestBo) {

    this.requestmanagement.saveRequest(requestBo);
  }

  @Override
  public RequestEto saveRequest(RequestEto requestEto) {

    return this.requestmanagement.saveRequest(requestEto);
  }

  @Override
  public void deleteRequest(long id) {

    this.requestmanagement.deleteRequest(id);
  }

}
