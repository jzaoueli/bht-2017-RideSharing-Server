package io.oasp.logistic.ridesharing.userprofilemanagement.logic.api;

import io.oasp.logistic.ridesharing.userprofilemanagement.logic.api.to.CGUserProfileEto;
import io.oasp.logistic.ridesharing.userprofilemanagement.logic.api.to.UserProfileSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

import java.util.List;

/**
 * Interface for UserProfileManagement component.
 */
public interface UserProfileManagement {

    /**
     * @param id the {@link CGUserProfileEto#getId() ID} of the requested user profile.
     * @return The {@link CGUserProfileEto} with the given <code>id</code> or {@code null} if no such object exists.
     */
    CGUserProfileEto findUserProfile(Long id);

    /**
     * @param login The {@link CGUserProfileEto#getName() login} of the requested user profile.
     * @return The {@link CGUserProfileEto} with the given <code>login</code> or {@code null} if no such object exists.
     */
    CGUserProfileEto findCGUserProfileByLogin(String login);

    /**
     * @return {@link List} of all existing {@link CGUserProfileEto user profile}.
     */
    List<CGUserProfileEto> findAllUserProfiles();

    /**
     * Returns a list of user profile matching the search criteria.
     *
     * @param criteria the {@link UserProfileSearchCriteriaTo}.
     * @return the {@link List} of matching {@link CGUserProfileEto}s.
     */
    PaginatedListTo<CGUserProfileEto> findUserProfileEtos(UserProfileSearchCriteriaTo criteria);

    /**
     * @param userProfileId the {@link CGUserProfileEto#getId() ID} of a {@link CGUserProfileEto} to delete.
     */
    void deleteUserProfile(Long userProfileId);

    /**
     * @param login {@link CGUserProfileEto#getName() login} of a {@link CGUserProfileEto} to delete.
     */
    void deleteUserProfileByLogin(String login);

    /**
     * Creates or updates a {@link CGUserProfileEto}.
     *
     * @param userProfile The {@link CGUserProfileEto} to create or update.
     * @return the saved {@link CGUserProfileEto}
     */
    CGUserProfileEto saveUserProfile(CGUserProfileEto userProfile);

}
