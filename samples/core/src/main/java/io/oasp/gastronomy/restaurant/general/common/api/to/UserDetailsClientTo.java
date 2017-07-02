package io.oasp.gastronomy.restaurant.general.common.api.to;

import io.oasp.gastronomy.restaurant.ridesharing.general.CGUserProfile;
import io.oasp.module.basic.common.api.to.AbstractTo;

/**
 * This is the {@link AbstractTo TO} for the client view on the user details.
 *
 */
public class UserDetailsClientTo extends AbstractTo implements CGUserProfile {

  /** UID for serialization. */
  private static final long serialVersionUID = 1L;

  private Long id;

  private String name;

  private String emailAddress;

  private String mobileNumber;

  private String cgHomeLocation;

  private boolean validationStatus;

  private String role;

  private String password;

  /**
   * The constructor.
   */
  public UserDetailsClientTo() {

    super();
  }

  @Override
  public Long getId() {

    return this.id;
  }

  @Override
  public String getName() {

    return this.name;
  }

  @Override
  public String getEmailAddress() {
    return this.emailAddress;
  }

  @Override
  public String getMobileNumber() {
    return this.mobileNumber;
  }

  @Override
  public String getCgHomeLocation() {
    return this.cgHomeLocation;
  }

  @Override
  public boolean getValidationStatus() {
    return this.validationStatus;
  }

  @Override
  public String getRole() {
    return role;
  }

  @Override
  public String getPassword() {
    return password;
  }

  /**
   * Sets the ID.
   *
   * @param id the ID to set
   */
  public void setId(Long id) {

    this.id = id;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {

    this.name = name;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public void setCgHomeLocation(String cgHomeLocation) {
    this.cgHomeLocation = cgHomeLocation;
  }

  public void setValidationStatus(boolean validationStatus) {
    this.validationStatus = validationStatus;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
