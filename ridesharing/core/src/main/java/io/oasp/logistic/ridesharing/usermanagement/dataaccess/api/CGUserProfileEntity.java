package io.oasp.logistic.ridesharing.usermanagement.dataaccess.api;

import io.oasp.logistic.ridesharing.general.dataaccess.api.ApplicationPersistenceEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CGUserProfileEntity extends ApplicationPersistenceEntity implements CGUserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UserID")
    private Long userID;

    @Column(name = "Name")
    private String name;

    @Column(name = "EmailAddress")
    private String emailAddress;

    @Column(name = "MobileNumber")
    private String mobileNumber;

    @Column(name = "CGHomeLocation")
    private String cgHomeLocation;

    @Column(name = "ValidationStatus")
    private boolean validationStatus;

    @Override
    public Long getUserID() {
        return userID;
    }

    @Override
    public void setUserID(Long userID) {
        this.userID = userID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String getMobileNumber() {
        return mobileNumber;
    }

    @Override
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String getCgHomeLocation() {
        return cgHomeLocation;
    }

    @Override
    public void setCgHomeLocation(String cgHomeLocation) {
        this.cgHomeLocation = cgHomeLocation;
    }

    @Override
    public boolean isValidationStatus() {
        return validationStatus;
    }

    @Override
    public void setValidationStatus(boolean validationStatus) {
        this.validationStatus = validationStatus;
    }


}
