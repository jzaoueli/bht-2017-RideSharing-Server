package io.oasp.logistic.ridesharing.general.common.api;


import io.oasp.logistic.ridesharing.general.common.api.datatype.Role;

import java.security.Principal;

public interface UserProfile extends Principal {
    /**
     * @return the technical ID of the user for calling REST services.
     */
    Long getId();

    /**
     * @return the unique login of the user for authentication and identification.
     */
    String getName();

    /**
     * @return the first name of the users real name.
     */
    String getFirstName();

    /**
     * @return the last name of the users real name.
     */
    String getLastName();

    /**
     * @return {@link Role} of this {@link UserProfile}.
     */
    Role getRole();
}
