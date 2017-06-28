package io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.logic.impl;

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
import io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.dataaccess.api.RequestEntity;
import io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.dataaccess.api.dao.RequestDao;
import io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.logic.api.Requestmanagement;
import io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.logic.api.to.RequestEto;
import io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.logic.api.to.RequestSearchCriteriaTo;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.common.api.RSOffer;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.dataaccess.api.RSOfferEntity;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.dataaccess.api.dao.RSOfferDao;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.logic.api.to.RSOfferEto;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.logic.api.to.RSOfferSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

@Named
@Component
@Transactional
public class RequestmanagementImpl extends AbstractComponentFacade implements Requestmanagement {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(RequestmanagementImpl.class);

  /**
   * @see #getRequestDao()
   */
  private RequestDao requestDao;

  private RSOfferDao rsOfferDao;

  @Override
  @RolesAllowed(PermissionConstants.FIND_REQUEST)
  public RequestEto findRequest(Long id) {

    return getBeanMapper().map(getRequestDao().find(id), RequestEto.class);
  }

  @Override
  @RolesAllowed(PermissionConstants.FIND_REQUEST)
  public List<RequestEto> findAllRequests() {

    List<RequestEntity> requests = getRequestDao().findAll();
    List<RequestEto> requestsBo = new ArrayList<>();

    for (RequestEntity request : requests) {
      requestsBo.add(getBeanMapper().map(request, RequestEto.class));
    }

    return requestsBo;
  }

  @Override
  @RolesAllowed(PermissionConstants.DELETE_REQUEST)
  public void deleteRequest(Long requestId) {

    getRequestDao().delete(requestId);
  }

  @Override
  @RolesAllowed(PermissionConstants.SAVE_REQUEST)
  public RequestEto saveRequest(RequestEto request) {

    Objects.requireNonNull(request, "request");

    RequestEntity persistedRequest = getRequestDao().save(getBeanMapper().map(request, RequestEntity.class));
    RequestEto requestEto = getBeanMapper().map(persistedRequest, RequestEto.class);

    RSOfferSearchCriteriaTo rsOfferSearch = new RSOfferSearchCriteriaTo();
    rsOfferSearch.setRequest(requestEto);

    PaginatedListTo<RSOfferEntity> matchedRSOffersPaginatedList =
            getRSOfferDao().checkRSOffertMatchedByOffer(rsOfferSearch);

    List<RSOfferEntity> matchedRSOffers = matchedRSOffersPaginatedList.getResult();

    if (!matchedRSOffers.isEmpty()) {
      referRequestToOffer(requestEto, matchedRSOffers);
    } else {
      LOG.warn("no matched request found");
    }

    LOG.warn("saved request with departure: " + requestEto.getEarliestDepartureTime() + " and " + requestEto.getLatestDepartureTime());
    return requestEto;
  }

  private void referRequestToOffer(RequestEto request, List<RSOfferEntity> matchedRSOffers) {
    for (RSOfferEntity rsOffer : matchedRSOffers) {
      if (rsOffer.getNumberOfPlaces() >= request.getNumberOfPlaces()) {

        //update RSOfferIdMapped and save the new request
        request.setRSOfferIdMapped(rsOffer.getId());
        getRequestDao().save(getBeanMapper().map(request, RequestEntity.class));

        //update number of places and save the rsOffer with one place less
        rsOffer.setNumberOfPlaces(rsOffer.getNumberOfPlaces() - request.getNumberOfPlaces());
        getRSOfferDao().save(rsOffer);
      }
    }
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

  /**
   * @return the {@link RSOfferDao} instance.
   */
  public RSOfferDao getRSOfferDao() {

    return this.rsOfferDao;
  }

  /**
   * Sets the field 'rsOfferDao'.
   *
   * @param rsOfferDao New value for rsOfferDao
   */
  @Inject
  public void setRSOfferDao(RSOfferDao rsOfferDao) {

    this.rsOfferDao = rsOfferDao;
  }

  @Override
  public PaginatedListTo<RequestEto> checkRequestMatchedByOffer(RequestSearchCriteriaTo requestSearchCriteriaTo) {

    PaginatedListTo<RequestEntity> requests = getRequestDao().checkRequestMatchedByOffer(requestSearchCriteriaTo);
    return mapPaginatedEntityList(requests, RequestEto.class);
  }

}
