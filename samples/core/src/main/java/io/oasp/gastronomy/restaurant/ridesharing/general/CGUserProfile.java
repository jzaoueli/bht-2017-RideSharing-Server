package io.oasp.gastronomy.restaurant.ridesharing.general;


import java.security.Principal;

public interface CGUserProfile extends Principal {

  // Long getUserID();

  Long getId();

  @Override
  String getName();

  String getEmailAddress();

  String getMobileNumber();

  String getCgHomeLocation();

  boolean getValidationStatus();

  String getRole();

  String getPassword();
}
