package io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.logic.api.to;

import java.util.Locale;

import io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.common.api.CGMember;
import io.oasp.module.basic.common.api.to.AbstractEto;

/**
 * The {@link AbstractEto ETO} for a {@link CGMember}.
 *
 */
public class CGMemberEto extends AbstractEto implements CGMember {

  // UUID
  private static final long serialVersionUID = 1L;

  // private Long userID;

  private String name;

  private String emailAddress;

  private String mobileNumber;

  private String cgHomeLocation;

  private boolean validationStatus;

  //
  private Locale language;

  /**
   * The constructor.
   */
  public CGMemberEto() {
    super();
  }

  @Override
  public String getName() {

    return this.name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  public Locale getLanguage() {

    return this.language;
  }

  public void setLanguage(Locale language) {

    this.language = language;
  }

  /*
   * @Override public Long getUserID() {
   *
   * return this.userID; }
   */
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

  /*
   * @Override public void setUserID(Long userID) {
   *
   * this.userID = userID; }
   */
  @Override
  public void setEmailAddress(String emailAddress) {

    this.emailAddress = emailAddress;
  }

  @Override
  public void setMobileNumber(String mobileNumber) {

    this.mobileNumber = mobileNumber;
  }

  @Override
  public void setCgHomeLocation(String cgHomeLocation) {

    this.cgHomeLocation = cgHomeLocation;
  }

  @Override
  public void setValidationStatus(boolean validationStatus) {

    this.validationStatus = validationStatus;
  }
}
