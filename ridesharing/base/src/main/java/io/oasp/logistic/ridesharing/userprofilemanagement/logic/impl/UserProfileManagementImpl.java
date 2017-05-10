package io.oasp.logistic.ridesharing.userprofilemanagement.logic.impl;

import io.oasp.logistic.ridesharing.general.common.api.UserProfile;
import io.oasp.logistic.ridesharing.general.common.api.Usermanagement;
import io.oasp.logistic.ridesharing.general.common.api.constants.PermissionConstants;
import io.oasp.logistic.ridesharing.general.logic.base.AbstractComponentFacade;
import io.oasp.logistic.ridesharing.userprofilemanagement.dataaccess.api.CGUserProfileEntity;
import io.oasp.logistic.ridesharing.userprofilemanagement.dataaccess.api.dao.UserProfileDao;
import io.oasp.logistic.ridesharing.userprofilemanagement.logic.api.UserProfileManagement;
import io.oasp.logistic.ridesharing.userprofilemanagement.logic.api.to.CGUserProfileEto;
import io.oasp.logistic.ridesharing.userprofilemanagement.logic.api.to.UserProfileSearchCriteriaTo;
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

/**
 * Implementation of {@link UserProfileManagement}.
 */
@Named
@Component
@Transactional
public class UserProfileManagementImpl extends AbstractComponentFacade implements UserProfileManagement, Usermanagement {

    /**
     * Logger instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UserProfileManagementImpl.class);

    /**
     * @see #getUserProfileDao()
     */
    private UserProfileDao userProfileDao;

    /**
     * Do not extract this method as a service, because of PermitAll. (only for login)
     */
    @Override
    @RolesAllowed(PermissionConstants.FIND_USER_PROFILE)
    public CGUserProfileEto findCGUserProfileByLogin(String login) {

        return privateFindUserProfileByLogin(login);
    }

    @Override
    @RolesAllowed(PermissionConstants.FIND_USER_PROFILE)
    public CGUserProfileEto findUserProfile(Long id) {

        return getBeanMapper().map(getUserProfileDao().find(id), CGUserProfileEto.class);
    }

    @Override
    @RolesAllowed(PermissionConstants.FIND_USER_PROFILE)
    public List<CGUserProfileEto> findAllUserProfiles() {

        List<CGUserProfileEntity> users = getUserProfileDao().findAll();
        List<CGUserProfileEto> usersBo = new ArrayList<>();

        for (CGUserProfileEntity user : users) {
            usersBo.add(getBeanMapper().map(user, CGUserProfileEto.class));
        }

        return usersBo;
    }

    @Override
    @RolesAllowed(PermissionConstants.FIND_USER_PROFILE)
    public PaginatedListTo<CGUserProfileEto> findUserProfileEtos(UserProfileSearchCriteriaTo criteria) {

        // Uncomment next line in order to limit the maximum page size for the user profile search
        // criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);

        PaginatedListTo<CGUserProfileEntity> offers = getUserProfileDao().findUserProfiles(criteria);
        return mapPaginatedEntityList(offers, CGUserProfileEto.class);
    }

    @Override
    // used during authentication so not authorization annotation (not even @PermitAll) can be used here
    public UserProfile findUserProfileByLogin(String login) {

        return privateFindUserProfileByLogin(login);
    }

    /**
     * Do not extract this method as a service, because of PermitAll. (only for login)
     */
    private CGUserProfileEto privateFindUserProfileByLogin(String login) {

        return getBeanMapper().map(getUserProfileDao().findByLogin(login), CGUserProfileEto.class);
    }

    @Override
    @RolesAllowed(PermissionConstants.DELETE_USER_PROFILE)
    public void deleteUserProfileByLogin(String login) {

        getUserProfileDao().delete(getUserProfileDao().findByLogin(login));
    }

    @Override
    @RolesAllowed(PermissionConstants.DELETE_USER_PROFILE)
    public void deleteUserProfile(Long userProfileId) {

        getUserProfileDao().delete(userProfileId);
    }

    @Override
    @RolesAllowed(PermissionConstants.SAVE_USER_PROFILE)
    public CGUserProfileEto saveUserProfile(CGUserProfileEto userProfile) {

        Objects.requireNonNull(userProfile, "userProgile");

        Long id = userProfile.getId();
        CGUserProfileEntity targetUserProfile = null;

        if (id != null) {
            targetUserProfile = getUserProfileDao().find(id);
        }
        if (targetUserProfile == null) {
            // CGUserProfile is new: -> create
            LOG.debug("Saving CGUserProfile with id '{}' to the database.", id);
        } else {
            // CGUserProfile already exists: -> Update
            LOG.debug("Updating CGUserProfile with id '{}' in the database.", id);
            if (!Objects.equals(targetUserProfile.getName(), userProfile.getName())) {
                LOG.debug("Changing login of CGUserProfile with id '{}' from '{}' to '{}' in the database.", id,
                        targetUserProfile.getName(), userProfile.getName());
            }
        }
        CGUserProfileEntity persistedUserProfile =
                getUserProfileDao().save(getBeanMapper().map(userProfile, CGUserProfileEntity.class));
        return getBeanMapper().map(persistedUserProfile, CGUserProfileEto.class);
    }

    /**
     * @return the {@link UserProfileDao} instance.
     */
    public UserProfileDao getUserProfileDao() {

        return this.userProfileDao;
    }

    /**
     * Sets the field 'userProfileDao'.
     *
     * @param userProfileDao New value for userProfileDao
     */
    @Inject
    public void setUserProfileDao(UserProfileDao userProfileDao) {

        this.userProfileDao = this.userProfileDao;
    }

}
