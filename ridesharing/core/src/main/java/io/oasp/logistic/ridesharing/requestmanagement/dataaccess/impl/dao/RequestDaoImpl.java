package io.oasp.logistic.ridesharing.requestmanagement.dataaccess.impl.dao;


import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;
import io.oasp.logistic.ridesharing.general.dataaccess.base.DatabaseMigrator;
import io.oasp.logistic.ridesharing.general.dataaccess.base.dao.ApplicationMasterDataDaoImpl;
import io.oasp.logistic.ridesharing.requestmanagement.dataaccess.api.RequestEntity;
import io.oasp.logistic.ridesharing.requestmanagement.dataaccess.api.dao.RequestDao;
import io.oasp.logistic.ridesharing.requestmanagement.logic.api.to.RequestSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

import javax.inject.Named;
import java.util.Date;
import java.util.List;

import static com.mysema.query.alias.Alias.$;

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
    public PaginatedListTo<RequestEntity> findRequests(RequestSearchCriteriaTo criteria) {
        RequestEntity Request = Alias.alias(RequestEntity.class);
        EntityPathBase<RequestEntity> alias = $(Request);
        JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

        Long userId = criteria.getUserId();
        query.where($(Request.getUserId()).eq(userId));
        String fromLocation = criteria.getFromLocation();

        if (fromLocation != null) {
            query.where($(Request.getFromLocation()).eq(fromLocation));
        }
        String toLocation = criteria.getToLocation();
        if (toLocation != null) {
            query.where($(Request.getToLocation()).eq(toLocation));
        }
        Date earliestDepartureTime = criteria.getEarliestDepartureTime();
        if (earliestDepartureTime != null) {
            query.where($(Request.getEarliestDepartureTime()).eq(earliestDepartureTime));
        }
        Date latestDepartureTime = criteria.getLatestDepartureTime();
        if (latestDepartureTime != null) {
            query.where($(Request.getLatestDepartureTime()).eq(latestDepartureTime));
        }
        int numberOfPlaces = criteria.getNumberOfPlaces();
        query.where($(Request.getNumberOfPlaces()).eq(numberOfPlaces));

        String luggageSpace = criteria.getLuggageSpace();
        if (luggageSpace != null) {
            query.where($(Request.getLuggageSpace()).eq(luggageSpace));
        }

        return findPaginated(criteria, query, alias);
    }
}
