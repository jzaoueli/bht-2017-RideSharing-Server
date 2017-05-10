package io.oasp.logistic.ridesharing.userprofilemanagement.service.api.rest;

import io.oasp.logistic.ridesharing.general.common.api.RestService;
import io.oasp.logistic.ridesharing.userprofilemanagement.logic.api.UserProfileManagement;
import io.oasp.logistic.ridesharing.userprofilemanagement.logic.api.to.CGUserProfileEto;
import io.oasp.logistic.ridesharing.userprofilemanagement.logic.api.to.UserProfileSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * The service class for REST calls in order to execute the methods in {@link UserProfileManagement}.
 */
@Path("/userprofilemanagement/v1/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface UserProfileManagementRestService extends RestService {

    /**
     * @return a list of all {@link CGUserProfileEto}
     */
    @GET
    @Path("/")
    @Deprecated
    List<CGUserProfileEto> getAllUserProfile();

    /**
     * @param login the login of a user profile
     * @return {@link CGUserProfileEto}
     */
    @GET
    @Path("/{login}")
    CGUserProfileEto getUserProfile(@PathParam("login") String login);

    /**
     * @param userProfileBo the CGUserProfile to be updated as JSON
     */
    @PUT
    @Path("/{login}")
    @Deprecated
    void updateUserProfile(CGUserProfileEto userProfileBo);

    /**
     * Calls {@link UserProfileManagement#saveUserProfile}.
     *
     * @param userProfileEto the userProfile to be created or updated
     * @return the saved {@link CGUserProfileEto}
     */
    @POST
    @Path("/")
    CGUserProfileEto saveUserProfile(CGUserProfileEto userProfileEto);

    /**
     * @param login the login
     */
    @DELETE
    @Path("/{login}")
    void deleteUserProfile(@PathParam("login") String login);

    /**
     * Delegates to {@link UserProfileManagement#findUserProfileEtos}.
     *
     * @param searchCriteriaTo the pagination and search criteria to be used for finding userProfiles.
     * @return the {@link PaginatedListTo list} of matching {@link CGUserProfileEto}s.
     */
    @Path("/search")
    @POST
    PaginatedListTo<CGUserProfileEto> findUserProfilesByPost(UserProfileSearchCriteriaTo searchCriteriaTo);

}
