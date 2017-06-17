package io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.dataaccess.impl.dao;

import static com.mysema.query.alias.Alias.$;

import java.util.Date;

import javax.inject.Named;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.gastronomy.restaurant.general.dataaccess.base.dao.ApplicationMasterDataDaoImpl;
import io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.dataaccess.api.RequestEntity;
import io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.dataaccess.api.dao.RequestDao;
import io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.logic.api.to.RequestSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of {@link RequestDao}.
 */
@Named
public class RequestDaoImpl extends ApplicationMasterDataDaoImpl<RequestEntity> implements RequestDao {
  /**
   * constructor
   */
  public RequestDaoImpl() {
    super();
  }

  @Override
  protected Class<RequestEntity> getEntityClass() {

    return RequestEntity.class;
  }

  @Override
  public PaginatedListTo<RequestEntity> checkRequestMatchedByOffer(RequestSearchCriteriaTo requestSearchCriteriaTo) {

    RequestEntity request = Alias.alias(RequestEntity.class);
    EntityPathBase<RequestEntity> alias = $(request);

    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    Date departureTime = requestSearchCriteriaTo.getRSOffer().getDepartureTime();
    Long fromLocationId = requestSearchCriteriaTo.getRSOffer().getFromLocation();
    Long toLocationId = requestSearchCriteriaTo.getRSOffer().getToLocation();

    query.where(($(request.getEarliestDepartureTime()).before(departureTime))
        .and($(request.getLatestDepartureTime()).after(departureTime))
        .and($(request.getFromLocation()).eq(fromLocationId)).and($(request.getToLocation()).eq(toLocationId)));

    return findPaginated(requestSearchCriteriaTo, query, alias);
  }

}
