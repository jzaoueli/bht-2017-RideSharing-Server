package io.oasp.gastronomy.restaurant.general.common.api;

import io.oasp.gastronomy.restaurant.ridesharing.general.CGUserProfile;

/**
 * Interface to get a user from its login.
 *
 */
public interface Usermanagement {

  /**
   * @param login The login of the requested user.
   * @return The {@link CGUserProfile} with the given <code>login</code> or {@code null} if no such object exists.
   */
  CGUserProfile findUserProfileByLogin(String login);

}
