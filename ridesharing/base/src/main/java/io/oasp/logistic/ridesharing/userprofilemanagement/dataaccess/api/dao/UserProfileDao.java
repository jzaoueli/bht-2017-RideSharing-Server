package io.oasp.logistic.ridesharing.userprofilemanagement.dataaccess.api.dao;

import io.oasp.logistic.ridesharing.userprofilemanagement.dataaccess.api.CGUserProfileEntity;
import io.oasp.logistic.ridesharing.userprofilemanagement.logic.api.to.UserProfileSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.jpa.dataaccess.api.MasterDataDao;

import io.oasp.logistic.ridesharing.general.dataaccess.api.dao.ApplicationDao;


/**
 * {@link ApplicationDao Data Access Object} for {@link CGUserProfileEntity} entity.
 */
public interface UserProfileDao extends ApplicationDao<CGUserProfileEntity>, MasterDataDao<CGUserProfileEntity> {

    /**
     * Searchs user profile with identifier 'login' within the database.
     * 2
     *
     * @param login user profile identifier
     * @return CGUserProfile
     */
    CGUserProfileEntity findByLogin(String login);

    /**
     * Finds the {@link CGUserProfileEntity} objects matching the given {@link UserProfileSearchCriteriaTo}-
     *
     * @param criteria is the {@link UserProfileSearchCriteriaTo}.
     * @return the {@link PaginatedListTo} with the matching {@link CGUserProfileEntity} objects.
     */
    PaginatedListTo<CGUserProfileEntity> findUserProfiles(UserProfileSearchCriteriaTo criteria);


}
