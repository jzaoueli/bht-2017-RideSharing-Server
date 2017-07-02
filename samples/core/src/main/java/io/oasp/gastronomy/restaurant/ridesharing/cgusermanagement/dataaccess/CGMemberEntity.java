package io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.dataaccess;

import javax.persistence.*;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.ApplicationPersistenceEntity;
import io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.common.api.CGMember;

@Entity
@Table(name = "CGMEMBER")
public class CGMemberEntity extends ApplicationPersistenceEntity implements CGMember {

  private static final long serialVersionUID = 1L;

  /*
   * @Id
   *
   * @GeneratedValue(strategy = GenerationType.AUTO)
   *
   * @Column(name = "UserID") private Long userID;
   */
  @Column(name = "Name")
  private String name;

  @Column(name = "password")
  private String password;

  @Column(name = "EmailAddress")
  private String emailAddress;

  @Column(name = "MobileNumber")
  private String mobileNumber;

  @Column(name = "CGHomeLocation")
  private String cgHomeLocation;

  @Column(name = "ValidationStatus")
  private boolean validationStatus;

  @Column(name = "role")
  private String role;

  /*
   * @Override public Long getUserID() {
   *
   * return this.userID; }
   *
   * @Override public void setUserID(Long userID) {
   *
   * this.userID = userID; }
   */

  public CGMemberEntity() {

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

  @Override
  public String getEmailAddress() {

    return this.emailAddress;
  }

  @Override
  public void setEmailAddress(String emailAddress) {

    this.emailAddress = emailAddress;
  }

  @Override
  public String getMobileNumber() {

    return this.mobileNumber;
  }

  @Override
  public void setMobileNumber(String mobileNumber) {

    this.mobileNumber = mobileNumber;
  }

  @Override
  public String getCgHomeLocation() {

    return this.cgHomeLocation;
  }

  @Override
  public void setCgHomeLocation(String cgHomeLocation) {

    this.cgHomeLocation = cgHomeLocation;
  }

  @Override
  public boolean getValidationStatus() {

    return this.validationStatus;
  }

  @Override
  public void setValidationStatus(boolean validationStatus) {

    this.validationStatus = validationStatus;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
