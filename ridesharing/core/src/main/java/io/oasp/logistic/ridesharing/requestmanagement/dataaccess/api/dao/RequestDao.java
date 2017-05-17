package io.oasp.logistic.ridesharing.requestmanagement.dataaccess.api.dao;

import io.oasp.logistic.ridesharing.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.logistic.ridesharing.requestmanagement.dataaccess.api.RequestEntity;
import io.oasp.logistic.ridesharing.requestmanagement.logic.api.to.RequestSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.jpa.dataaccess.api.MasterDataDao;

import java.util.List;

/**
 * {@link ApplicationDao Data Access Object} for {@link RequestEntity} entity.
 */
public interface RequestDao extends ApplicationDao<RequestEntity>, MasterDataDao<RequestEntity> {

    /**
     * Finds the {@link RequestEntity} objects matching the given {@link RequestSearchCriteriaTo}-
     *
     * @param criteria is the {@link RequestSearchCriteriaTo}.
     * @return the {@link PaginatedListTo} with the matching {@link RequestEntity} objects.
     */
    PaginatedListTo<RequestEntity> findRequests(RequestSearchCriteriaTo criteria);

    List<RequestEntity> getNotMappedRequests();
}
