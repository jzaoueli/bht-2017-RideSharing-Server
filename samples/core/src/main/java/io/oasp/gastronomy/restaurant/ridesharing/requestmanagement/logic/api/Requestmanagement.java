package io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.logic.api;

import java.util.List;

import io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.logic.api.to.RequestEto;
import io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.logic.api.to.RequestSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Interface for StaffManagement component.
 */
public interface Requestmanagement {

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
   * @param RequestId the {@link RequestEto#getId() ID} of a {@link RequestEto} to delete.
   */
  void deleteRequest(Long requestId);

  /**
   * Creates or updates a {@link RequestEto}.
   *
   * @param Request The {@link RequestEto} to create or update.
   * @return the saved {@link RequestEto}
   */
  RequestEto saveRequest(RequestEto request);

  PaginatedListTo<RequestEto> checkRequestMatchedByOffer(RequestSearchCriteriaTo requestSearchCriteriaTo);
}
