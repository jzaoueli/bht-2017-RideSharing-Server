package io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.dataaccess.impl.dao;

import static com.mysema.query.alias.Alias.$;

import java.util.Date;

import javax.inject.Named;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.gastronomy.restaurant.general.dataaccess.base.dao.ApplicationMasterDataDaoImpl;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.dataaccess.api.RSOfferEntity;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.dataaccess.api.dao.RSOfferDao;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.logic.api.to.RSOfferSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of {@link RSOfferDao}.
 */
@Named
public class RSOfferDaoImpl extends ApplicationMasterDataDaoImpl<RSOfferEntity> implements RSOfferDao {
  /**
   * constructor
   */
  public RSOfferDaoImpl() {
    super();
  }

  @Override
  protected Class<RSOfferEntity> getEntityClass() {

    return RSOfferEntity.class;
  }

  @Override
  public PaginatedListTo<RSOfferEntity> checkRSOffertMatchedByOffer(RSOfferSearchCriteriaTo rsOfferSearchCriteriaTo) {

    RSOfferEntity rsOffer = Alias.alias(RSOfferEntity.class);
    EntityPathBase<RSOfferEntity> alias = $(rsOffer);

    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    Date earliestDepartureTime = rsOfferSearchCriteriaTo.getRequest().getEarliestDepartureTime();
    Date latestDepartureTime = rsOfferSearchCriteriaTo.getRequest().getLatestDepartureTime();
    Long fromLocationId = rsOfferSearchCriteriaTo.getRequest().getFromLocation();
    Long toLocationId = rsOfferSearchCriteriaTo.getRequest().getToLocation();

    query.where(($(rsOffer.getDepartureTime()).between(earliestDepartureTime, latestDepartureTime))
        .and($(rsOffer.getFromLocation()).eq(fromLocationId)).and($(rsOffer.getToLocation()).eq(toLocationId)));

    return findPaginated(rsOfferSearchCriteriaTo, query, alias);
  }

}
