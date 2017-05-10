package io.oasp.logistic.ridesharing.userprofilemanagement.service.impl.rest;

import io.oasp.logistic.ridesharing.userprofilemanagement.logic.api.UserProfileManagement;
import io.oasp.logistic.ridesharing.userprofilemanagement.logic.api.to.CGUserProfileEto;
import io.oasp.logistic.ridesharing.userprofilemanagement.logic.api.to.UserProfileSearchCriteriaTo;
import io.oasp.logistic.ridesharing.userprofilemanagement.service.api.rest.UserProfileManagementRestService;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 */
@Named("UserProfileManagementRestService")
public class UserProfileManagementRestServiceImpl implements UserProfileManagementRestService {

    private UserProfileManagement userProfileManagement;

    /**
     * @param userProfileManagement the userProfileManagement to be set
     */
    @Inject
    public void setUserProfileManagement(UserProfileManagement userProfileManagement) {

        this.userProfileManagement = userProfileManagement;
    }

    @Override
    public List<CGUserProfileEto> getAllUserProfile() {

        return this.userProfileManagement.findAllUserProfiles();
    }

    @Override
    public CGUserProfileEto getUserProfile(String login) {

        return this.userProfileManagement.findCGUserProfileByLogin(login);
    }

    // although login is not explicitly needed here, the path structure is intentionally chosen
    // it is up to the GUI-Team to either insert a (maybe redundant) call on getUserProfile or to leave it
    // like that and do the update right in the view of a previously "loaded" CGUserProfile

    @Override
    @Deprecated
    public void updateUserProfile(CGUserProfileEto userProfileBo) {

        this.userProfileManagement.saveUserProfile(userProfileBo);
    }

    @Override
    public CGUserProfileEto saveUserProfile(CGUserProfileEto userProfileEto) {

        return this.userProfileManagement.saveUserProfile(userProfileEto);
    }

    @Override
    public void deleteUserProfile(String login) {

        this.userProfileManagement.deleteUserProfileByLogin(login);
    }

    @Override
    public PaginatedListTo<CGUserProfileEto> findUserProfilesByPost(UserProfileSearchCriteriaTo searchCriteriaTo) {

        return this.userProfileManagement.findUserProfileEtos(searchCriteriaTo);
    }
}
