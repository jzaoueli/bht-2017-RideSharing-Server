package io.oasp.logistic.ridesharing.requestmanagement.common.api;

import java.util.Date;

public interface Request {

    void setUserId(long userId);

    void setFromLocation(String fromLocation);

    void setToLocation(String toLocation);

    void setEarliestDepartureTime(Date earliestDepartureTime);

    void setLatestDepartureTime(Date latestDepartureTime);

    void setNumberOfPlaces(int numberOfPlaces);

    void setLuggageSpace(String luggageSpace);

    void setRSOfferIdMapped(long RSOfferIdMapped);

    long getUserId();

    String getFromLocation();

    String getToLocation();

    Date getEarliestDepartureTime();

    Date getLatestDepartureTime();

    int getNumberOfPlaces();

    String getLuggageSpace();

    long getRSOfferIdMapped();
}
