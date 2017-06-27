package io.oasp.gastronomy.restaurant.general.common.api.security;

import io.oasp.gastronomy.restaurant.general.common.api.to.UserDetailsClientTo;

import java.security.Principal;
import java.util.Collection;

import io.oasp.gastronomy.restaurant.ridesharing.general.CGUserProfile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * Container class for the profile of a user.
 *
 */
public class UserData extends User implements Principal {

  private static final long serialVersionUID = 1L;

  private CGUserProfile cgUserProfile;

  /**
   * The constructor.
   *
   * @param username sets the username
   * @param password sets the password
   * @param enabled check if user is enabled
   * @param accountNonExpired check if user account is not expired
   * @param credentialsNonExpired check if user credentials are not expired
   * @param accountNonLocked check if user account is not locked
   * @param authorities the authorities/permissions the user has
   */
  public UserData(String username, String password, boolean enabled, boolean accountNonExpired,
      boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {

    super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
  }

  /**
   * The constructor.
   *
   * @param username sets the username
   * @param password sets the password
   * @param authorities the authorities/permissions the user has
   */
  public UserData(String username, String password, Collection<? extends GrantedAuthority> authorities) {

    super(username, password, authorities);
  }

  @Override
  public String getName() {

    return getUsername();
  }

  /**
   * @return an instance of {@link UserDetailsClientTo} with the client side representation of this {@link UserData}
   *         instance.
   */
  public UserDetailsClientTo toClientTo() {

    UserDetailsClientTo clientTo = new UserDetailsClientTo();
    clientTo.setId(this.cgUserProfile.getId());
    clientTo.setName(this.cgUserProfile.getName());
    clientTo.setEmailAddress(this.cgUserProfile.getEmailAddress());
    clientTo.setMobileNumber(this.cgUserProfile.getMobileNumber());
    clientTo.setCgHomeLocation(this.cgUserProfile.getCgHomeLocation());
    clientTo.setValidationStatus(this.cgUserProfile.getValidationStatus());
    return clientTo;
  }

  @Override
  public String toString() {

    return getName();
  }

  /**
   * @return cgUserProfile
   */
  public CGUserProfile getCgUserProfile() {

    return this.cgUserProfile;
  }

  /**
   * @param cgUserProfile the cgUserProfile to set
   */
  public void setCgUserProfile(CGUserProfile cgUserProfile) {

    this.cgUserProfile = cgUserProfile;
  }

  /**
   * @return the {@link UserData} of the user currently logged in.
   */
  public static UserData get() {

    return get(SecurityContextHolder.getContext().getAuthentication());
  }

  /**
   * @param authentication is the {@link Authentication} where to retrieve the user from.
   * @return the {@link UserData} of the logged in user from the given {@link Authentication}.
   */
  public static UserData get(Authentication authentication) {

    if (authentication == null) {
      throw new IllegalStateException("Authentication not available!");
    }
    Object principal = authentication.getPrincipal();
    if (principal == null) {
      throw new IllegalStateException("Principal not available!");
    }
    try {
      return (UserData) principal;
    } catch (ClassCastException e) {
      throw new IllegalStateException("Principal (" + principal + ") is not an instance of UserData!", e);
    }
  }
}
