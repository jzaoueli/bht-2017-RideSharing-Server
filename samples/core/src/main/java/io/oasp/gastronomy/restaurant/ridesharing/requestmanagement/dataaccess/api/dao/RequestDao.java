package io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.dataaccess.api.dao;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.dataaccess.api.RequestEntity;
import io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.logic.api.to.RequestSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.jpa.dataaccess.api.MasterDataDao;

/**
 * {@link ApplicationDao Data Access Object} for {@link RequestEntity} entity.
 */
public interface RequestDao extends ApplicationDao<RequestEntity>, MasterDataDao<RequestEntity> {

  PaginatedListTo<RequestEntity> checkRequestMatchedByOffer(RequestSearchCriteriaTo requestSearchCriteriaTo);
}
