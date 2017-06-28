package io.oasp.gastronomy.restaurant.general.common.api.datatype;

import java.security.Principal;

/**
 * Created by jihedzaoueli on 27.06.17 at 19:30.
 */
public enum Role implements Principal {

    /**
     * AccessControlGroup of simple user.
     */
    USER("user"),

    /**
     * AccessControlGroup of admin on the ride-sharing who can manage the master-data such as TrasnportPoint and users
     * {@link io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.common.api.CGMember}s.
     */
    ADMIN("admin");

    private final String name;

    private Role(String name) {

        this.name = name;
    }

    @Override
    public String getName() {

        return this.name;
    }
}
