package io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.common.api;

import io.oasp.gastronomy.restaurant.general.common.api.ApplicationEntity;

/**
 * @author Jihed
 *
 */
public interface TransportPoint extends ApplicationEntity {

  // @Override
  // void setId(Long id);

  void setName(String name);

  String getName();

  void setCgLocation(boolean cgLocation);

  boolean getCgLocation();

  void setCountry(String country);

  String getCountry();

  void setCity(String city);

  String getCity();

  void setLocationAddress(String locationAddress);

  String getLocationAddress();

  void setGpsCoordination(String gpsCoordination);

  String getGpsCoordination();

}
