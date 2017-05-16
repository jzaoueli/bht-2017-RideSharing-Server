package io.oasp.logistic.ridesharing.usermanagement.dataaccess.api;


import io.oasp.logistic.ridesharing.general.common.api.ApplicationEntity;

public interface CGUserProfile extends ApplicationEntity {

    Long getUserID();

    void setUserID(Long userID);

    String getName();

    void setName(String name);

    String getEmailAddress();

    void setEmailAddress(String emailAddress);

    String getMobileNumber();

    void setMobileNumber(String mobileNumber);

    String getCgHomeLocation();

    void setCgHomeLocation(String cgHomeLocation);

    boolean isValidationStatus();

    void setValidationStatus(boolean validationStatus);
}
