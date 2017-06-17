package io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.dataaccess.api.dao;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.dataaccess.api.RSOfferEntity;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.logic.api.to.RSOfferSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.jpa.dataaccess.api.MasterDataDao;

/**
 * {@link ApplicationDao Data Access Object} for {@link RSOfferEntity} entity.
 */
public interface RSOfferDao extends ApplicationDao<RSOfferEntity>, MasterDataDao<RSOfferEntity> {

    PaginatedListTo<RSOfferEntity> checkRSOffertMatchedByOffer(RSOfferSearchCriteriaTo rsOfferSearch);
}
