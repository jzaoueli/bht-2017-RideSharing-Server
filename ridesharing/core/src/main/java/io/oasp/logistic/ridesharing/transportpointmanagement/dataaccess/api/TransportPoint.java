package io.oasp.logistic.ridesharing.transportpointmanagement.dataaccess.api;


import io.oasp.logistic.ridesharing.general.common.api.ApplicationEntity;

public interface TransportPoint extends ApplicationEntity {

    Long getId();

    void setId(Long id);

    String getName();

    void setName(String name);

    boolean getCgLocation();

    void setCgLocation(boolean cgLocation);

    String getCountry();

    void setCountry(String country);

    String getCity();

    void setCity(String city);

    String getLocationAddress();

    void setLocationAddress(String locationAddress);

    String getGpsCoordination();

    void setGpsCoordination(String gpsCoordination);
}
