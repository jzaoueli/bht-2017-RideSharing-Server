package io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.logic.impl;

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
  // @RolesAllowed(PermissionConstants.FIND_REQUEST)
  public RequestEto findRequest(Long id) {

    return getBeanMapper().map(getRequestDao().find(id), RequestEto.class);
  }

  @Override
  // @RolesAllowed(PermissionConstants.FIND_REQUEST)
  public List<RequestEto> findAllRequests() {

    List<RequestEntity> requests = getRequestDao().findAll();
    List<RequestEto> requestsBo = new ArrayList<>();

    for (RequestEntity request : requests) {
      requestsBo.add(getBeanMapper().map(request, RequestEto.class));
    }

    return requestsBo;
  }

  @Override
  // @RolesAllowed(PermissionConstants.DELETE_REQUEST)
  public void deleteRequest(Long requestId) {

    getRequestDao().delete(requestId);
  }

  @Override
  // @RolesAllowed(PermissionConstants.SAVE_REQUEST)
  public RequestEto saveRequest(RequestEto request) {

    Objects.requireNonNull(request, "request");

    RequestEntity persistedRequest = getRequestDao().save(getBeanMapper().map(request, RequestEntity.class));
    RequestEto requestEto = getBeanMapper().map(persistedRequest, RequestEto.class);

    // Fixme: check if it works
    RSOfferSearchCriteriaTo rsOfferSearch = new RSOfferSearchCriteriaTo();
    rsOfferSearch.setRequest(requestEto);

    PaginatedListTo<RSOfferEntity> matchedRSOffersPaginatedList =
        getRSOfferDao().checkRSOffertMatchedByOffer(rsOfferSearch);

    List<RSOfferEntity> matchedRSOffers = matchedRSOffersPaginatedList.getResult();

    if (!matchedRSOffers.isEmpty()) {
      LOG.warn("found matched rsOffer: " + matchedRSOffers.size());
      for (RSOffer rsOffer : matchedRSOffers) {
        RSOfferEto rsofferEto = getBeanMapper().map(rsOffer, RSOfferEto.class);
        LOG.warn("found matched rsOffer from user : " + rsOffer.getUserId());
        LOG.warn("found matched rsOffer with id : " + rsofferEto.getId());
      }
    } else {
      LOG.warn("no matched request found");
    }

    LOG.warn("saved offer from : " + requestEto.getFromLocation());
    LOG.warn("saved offer from : " + requestEto.getFromLocation());
    LOG.warn("saved offer between : " + requestEto.getEarliestDepartureTime() + "and "
        + requestEto.getLatestDepartureTime());
    return requestEto;
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
