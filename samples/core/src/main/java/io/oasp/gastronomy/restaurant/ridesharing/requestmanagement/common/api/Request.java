package io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.common.api;

import java.util.Date;

public interface Request {

  void setUserId(long userId);

  void setFromLocation(long fromLocation);

  void setToLocation(long toLocation);

  void setEarliestDepartureTime(Date earliestDepartureTime);

  void setLatestDepartureTime(Date latestDepartureTime);

  void setNumberOfPlaces(int numberOfPlaces);

  void setLuggageSpace(String luggageSpace);

  void setRSOfferIdMapped(long RSOfferIdMapped);

  long getUserId();

  long getFromLocation();

  long getToLocation();

  Date getEarliestDepartureTime();

  Date getLatestDepartureTime();

  int getNumberOfPlaces();

  String getLuggageSpace();

  long getRSOfferIdMapped();
}
