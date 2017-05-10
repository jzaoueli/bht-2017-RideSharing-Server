package io.oasp.logistic.ridesharing.userprofilemanagement.common.api;

import io.oasp.logistic.ridesharing.general.common.api.ApplicationEntity;
import io.oasp.logistic.ridesharing.general.common.api.UserProfile;

/**
 * This is the interface for a {@link CGUserProfile} that is an employee.
 */
public interface CGUserProfile extends ApplicationEntity, UserProfile {

    /**
     * @param name is the new {@link #getName() login}.
     */
    void setName(String name);

    /**
     * @param firstName is the new {@link #getFirstName() first name}.
     */
    void setFirstName(String firstName);

    /**
     * @param lastName is the new {@link #getLastName() last name}.
     */
    void setLastName(String lastName);

  /*
    @param role the new {@link #getRole() role}.
   */
    //void setRole(Role role);

}
