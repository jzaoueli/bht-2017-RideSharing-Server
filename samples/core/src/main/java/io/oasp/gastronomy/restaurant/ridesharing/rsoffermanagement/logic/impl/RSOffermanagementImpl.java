package io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.logic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.oasp.gastronomy.restaurant.general.logic.base.AbstractComponentFacade;
import io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.dataaccess.api.RequestEntity;
import io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.dataaccess.api.dao.RequestDao;
import io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.logic.api.to.RequestSearchCriteriaTo;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.dataaccess.api.RSOfferEntity;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.dataaccess.api.dao.RSOfferDao;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.logic.api.RSOffermanagement;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.logic.api.to.RSOfferEto;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.logic.api.to.RSOfferSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

@Named
@Component
@Transactional
public class RSOffermanagementImpl extends AbstractComponentFacade implements RSOffermanagement {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(RSOffermanagementImpl.class);

  /**
   * @see #getRSOfferDao()
   */
  private RSOfferDao rsofferDao;

  private RequestDao requestDao;

  @Override
  // @RolesAllowed(PermissionConstants.FIND_REQUEST)
  public RSOfferEto findRSOffer(Long id) {

    return getBeanMapper().map(getRSOfferDao().find(id), RSOfferEto.class);
  }

  @Override
  // @RolesAllowed(PermissionConstants.FIND_REQUEST)
  public List<RSOfferEto> findAllRSOffers() {

    List<RSOfferEntity> rsoffers = getRSOfferDao().findAll();
    List<RSOfferEto> rsoffersBo = new ArrayList<>();

    for (RSOfferEntity rsoffer : rsoffers) {
      rsoffersBo.add(getBeanMapper().map(rsoffer, RSOfferEto.class));
    }

    return rsoffersBo;
  }

  @Override
  // @RolesAllowed(PermissionConstants.DELETE_REQUEST)
  public void deleteRSOffer(Long rsofferId) {

    getRSOfferDao().delete(rsofferId);
  }

  @Override
  // @RolesAllowed(PermissionConstants.SAVE_REQUEST)
  public RSOfferEto saveRSOffer(RSOfferEto rsoffer) {

    Objects.requireNonNull(rsoffer, "rsoffer");

    RSOfferEntity persistedRSOffer = getRSOfferDao().save(getBeanMapper().map(rsoffer, RSOfferEntity.class));
    RSOfferEto rsOfferEto = getBeanMapper().map(persistedRSOffer, RSOfferEto.class);

    matchOfferWithRequests(rsOfferEto);

    return rsOfferEto;
  }

  private void matchOfferWithRequests(RSOfferEto rsOfferEto) {
    RequestSearchCriteriaTo requestSearch = new RequestSearchCriteriaTo();
    requestSearch.setRSOffer(rsOfferEto);
    PaginatedListTo<RequestEntity> matchedRequestsPaginatedList =
        getRequestDao().checkRequestMatchedByOffer(requestSearch);

    List<RequestEntity> matchedRequests = matchedRequestsPaginatedList.getResult();
    if (!matchedRequests.isEmpty()) {
      referRequestToOffer(rsOfferEto,matchedRequests);
    }
  }

  private void referRequestToOffer(RSOfferEto rsOfferEto, List<RequestEntity> matchedRequests) {
    int numberOfPlaces = rsOfferEto.getNumberOfPlaces();
    while (numberOfPlaces > 0){
      for(RequestEntity request: matchedRequests){
        if(request.getNumberOfPlaces() < numberOfPlaces ){

          //update RSOfferIdMapped and save the new request
          request.setRSOfferIdMapped(rsOfferEto.getId());
          getRequestDao().save(request);

          //update number of places and save the rsOffer with one place less
          numberOfPlaces = numberOfPlaces - request.getNumberOfPlaces();
          rsOfferEto.setNumberOfPlaces(numberOfPlaces);
          getRSOfferDao().save(getBeanMapper().map(rsOfferEto, RSOfferEntity.class));
        }
      }
    }
  }

  @Override
  public PaginatedListTo<RSOfferEto> checkRequestMatchedByOffer(RSOfferSearchCriteriaTo rsOfferSearchCriteriaTo) {

    PaginatedListTo<RSOfferEntity> requests = getRSOfferDao().checkRSOffertMatchedByOffer(rsOfferSearchCriteriaTo);
    return mapPaginatedEntityList(requests, RSOfferEto.class);
  }

  /**
   * @return the {@link RSOfferDao} instance.
   */
  public RSOfferDao getRSOfferDao() {

    return this.rsofferDao;
  }

  /**
   * Sets the field 'rsofferDao'.
   *
   * @param rsofferDao New value for rsofferDao
   */
  @Inject
  public void setRSOfferDao(RSOfferDao rsofferDao) {

    this.rsofferDao = rsofferDao;
  }

  /**
   * @return the {@link RequestDao} instance.
   */
  public RequestDao getRequestDao() {

    return this.requestDao;
  }

  /**
   * Sets the field 'requestDao'.
   *
   * @param requestDao New value for requestDao
   */
  @Inject
  public void setRequestDao(RequestDao requestDao) {

    this.requestDao = requestDao;
  }
}
