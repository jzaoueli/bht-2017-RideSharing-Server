package io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.service.impl.rest;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.logic.api.RSOffermanagement;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.logic.api.to.RSOfferEto;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.service.api.rest.RSOffermanagementRestService;

/**
 */
@Named("RSOffermanagementRestService")
public class RSOffermanagementRestServiceImpl implements RSOffermanagementRestService {

  private RSOffermanagement rsoffermanagement;

  /**
   * @param rsofferManagement the rsofferManagement to be set
   */
  @Inject
  public void setRSOffermanagement(RSOffermanagement rsofferManagement) {

    this.rsoffermanagement = rsofferManagement;
  }

  @Override
  public List<RSOfferEto> getAllRSOffer() {

    return this.rsoffermanagement.findAllRSOffers();
  }

  @Override
  public RSOfferEto getRSOffer(long id) {

    return this.rsoffermanagement.findRSOffer(id);
  }

  // although login is not explicitly needed here, the path structure is intentionally chosen
  // it is up to the GUI-Team to either insert a (maybe redundant) call on getRSOffer or to leave it
  // like that and do the update right in the view of a previously "loaded" RSOffer

  @Override
  @Deprecated
  public void updateRSOffer(RSOfferEto rsofferBo) {

    this.rsoffermanagement.saveRSOffer(rsofferBo);
  }

  @Override
  public RSOfferEto saveRSOffer(RSOfferEto rsofferEto) {

    return this.rsoffermanagement.saveRSOffer(rsofferEto);
  }

  @Override
  public void deleteRSOffer(long id) {

    this.rsoffermanagement.deleteRSOffer(id);
  }

}
