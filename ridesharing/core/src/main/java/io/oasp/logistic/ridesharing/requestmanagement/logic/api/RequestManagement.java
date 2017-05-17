package io.oasp.logistic.ridesharing.requestmanagement.logic.api;

import io.oasp.logistic.ridesharing.requestmanagement.logic.api.to.RequestEto;
import io.oasp.logistic.ridesharing.requestmanagement.logic.api.to.RequestSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

import java.util.List;

/**
 * Interface for StaffManagement component.
 */
public interface RequestManagement {

    /**
     * @param id the {@link RequestEto#getId() ID} of the requested staff member.
     * @return The {@link RequestEto} with the given <code>id</code> or {@code null} if no such object exists.
     */
    RequestEto findRequest(Long id);

    /**
     * @return {@link List} of all existing {@link RequestEto staff members}.
     */
    List<RequestEto> findAllRequests();

    /**
     * Returns a list of staff memberss matching the search criteria.
     *
     * @param criteria the {@link RequestSearchCriteriaTo}.
     * @return the {@link List} of matching {@link RequestEto}s.
     */
    PaginatedListTo<RequestEto> findRequestEtos(RequestSearchCriteriaTo criteria);

    /**
     * @param RequestId the {@link RequestEto#getId() ID} of a {@link RequestEto} to delete.
     */
    void deleteRequest(Long RequestId);

    /**
     * Creates or updates a {@link RequestEto}.
     *
     * @param Request The {@link RequestEto} to create or update.
     * @return the saved {@link RequestEto}
     */
    RequestEto saveRequest(RequestEto Request);
}
