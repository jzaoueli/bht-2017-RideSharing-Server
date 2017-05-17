package io.oasp.logistic.ridesharing.requestmanagement.logic.impl;


import io.oasp.logistic.ridesharing.general.common.api.constants.PermissionConstants;
import io.oasp.logistic.ridesharing.general.logic.base.AbstractComponentFacade;
import io.oasp.logistic.ridesharing.requestmanagement.dataaccess.api.RequestEntity;
import io.oasp.logistic.ridesharing.requestmanagement.dataaccess.api.dao.RequestDao;
import io.oasp.logistic.ridesharing.requestmanagement.logic.api.RequestManagement;
import io.oasp.logistic.ridesharing.requestmanagement.logic.api.to.RequestEto;
import io.oasp.logistic.ridesharing.requestmanagement.logic.api.to.RequestSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Named
@Component
@Transactional
public class RequestmanagementImpl extends AbstractComponentFacade implements RequestManagement {

    /**
     * Logger instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(RequestmanagementImpl.class);

    /**
     * @see #getRequestDao()
     */
    private RequestDao requestDao;

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
    public PaginatedListTo<RequestEto> findRequestEtos(RequestSearchCriteriaTo criteria) {
        PaginatedListTo<RequestEntity> offers = getRequestDao().findRequests(criteria);
        return mapPaginatedEntityList(offers, RequestEto.class);
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
        return getBeanMapper().map(persistedRequest, RequestEto.class);
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
