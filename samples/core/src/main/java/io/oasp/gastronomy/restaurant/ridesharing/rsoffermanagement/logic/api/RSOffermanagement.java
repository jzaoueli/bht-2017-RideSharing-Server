package io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.logic.api;

import java.util.List;

import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.logic.api.to.RSOfferEto;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.logic.api.to.RSOfferSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Interface for StaffManagement component.
 */
public interface RSOffermanagement {

  /**
   * @param id the {@link RSOfferEto#getId() ID} of the rsoffered staff member.
   * @return The {@link RSOfferEto} with the given <code>id</code> or {@code null} if no such object exists.
   */
  RSOfferEto findRSOffer(Long id);

  /**
   * @return {@link List} of all existing {@link RSOfferEto staff members}.
   */
  List<RSOfferEto> findAllRSOffers();

  /**
   * @param RSOfferId the {@link RSOfferEto#getId() ID} of a {@link RSOfferEto} to delete.
   */
  void deleteRSOffer(Long RSOfferId);

  /**
   * Creates or updates a {@link RSOfferEto}.
   *
   * @param RSOffer The {@link RSOfferEto} to create or update.
   * @return the saved {@link RSOfferEto}
   */
  RSOfferEto saveRSOffer(RSOfferEto RSOffer);

  PaginatedListTo<RSOfferEto> checkRequestMatchedByOffer(RSOfferSearchCriteriaTo rsOfferSearchCriteriaTo);

}
