package io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.common.api;

import java.util.Date;

public interface RSOffer {

  void setUserId(long userId);

  void setFromLocation(long fromLocation);

  void setToLocation(long toLocation);

  void setDepartureTime(Date departureTime);

  void setDelay(int delay);

  void setNumberOfPlaces(int numberOfPlaces);

  void setLuggageSpace(String luggageSpace);

  void setStatus(boolean status);

  long getUserId();

  long getFromLocation();

  long getToLocation();

  Date getDepartureTime();

  int getDelay();

  int getNumberOfPlaces();

  String getLuggageSpace();

  boolean getStatus();
}
