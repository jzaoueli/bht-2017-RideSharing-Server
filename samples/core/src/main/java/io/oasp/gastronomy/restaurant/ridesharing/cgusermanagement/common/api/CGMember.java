package io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.common.api;

import io.oasp.gastronomy.restaurant.general.common.api.ApplicationEntity;
import io.oasp.gastronomy.restaurant.ridesharing.general.CGUserProfile;

public interface CGMember extends ApplicationEntity, CGUserProfile {

  // void setUserID(Long userID);

  void setName(String name);

  void setEmailAddress(String emailAddress);

  void setMobileNumber(String mobileNumber);

  void setCgHomeLocation(String cgHomeLocation);

  void setValidationStatus(boolean validationStatus);

}
