package io.oasp.logistic.ridesharing.requestmanagement.logic.api.to;


import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

import java.util.Date;

public class RequestSearchCriteriaTo extends SearchCriteriaTo {

    private long userId;

    private String fromLocation;

    private String toLocation;

    private Date earliestDepartureTime;

    private Date latestDepartureTime;

    private int numberOfPlaces;

    private String luggageSpace;

    private long RSOfferIdMapped;

    /**
     * constructor
     */
    public RequestSearchCriteriaTo() {
        super();
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public Date getEarliestDepartureTime() {
        return earliestDepartureTime;
    }

    public void setEarliestDepartureTime(Date earliestDepartureTime) {
        this.earliestDepartureTime = earliestDepartureTime;
    }

    public Date getLatestDepartureTime() {
        return latestDepartureTime;
    }

    public void setLatestDepartureTime(Date latestDepartureTime) {
        this.latestDepartureTime = latestDepartureTime;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public String getLuggageSpace() {
        return luggageSpace;
    }

    public void setLuggageSpace(String luggageSpace) {
        this.luggageSpace = luggageSpace;
    }

    public long getRSOfferIdMapped() {
        return RSOfferIdMapped;
    }

    public void setRSOfferIdMapped(long RSOfferIdMapped) {
        this.RSOfferIdMapped = RSOfferIdMapped;
    }
}
