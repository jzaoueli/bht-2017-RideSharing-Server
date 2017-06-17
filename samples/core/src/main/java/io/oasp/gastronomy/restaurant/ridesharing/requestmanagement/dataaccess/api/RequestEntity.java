package io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.dataaccess.api;

import java.util.Date;

import javax.persistence.*;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.ApplicationPersistenceEntity;
import io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.common.api.Request;

@Entity
@Table(name = "Request")
public class RequestEntity extends ApplicationPersistenceEntity implements Request {

  private long userId;

  private long fromLocation;

  private long toLocation;

  private Date earliestDepartureTime;

  private Date latestDepartureTime;

  private int numberOfPlaces;

  private String luggageSpace;

  private long rsOfferIdMapped;

  /**
   * The constructor.
   */
  public RequestEntity() {
    super();
  }

  @Override
  public void setUserId(long userId) {

    this.userId = userId;
  }

  @Override
  public void setFromLocation(long fromLocation) {

    this.fromLocation = fromLocation;
  }

  @Override
  public void setToLocation(long toLocation) {

    this.toLocation = toLocation;
  }

  @Override
  @Temporal(TemporalType.TIMESTAMP)
  public void setEarliestDepartureTime(Date earliestDepartureTime) {

    this.earliestDepartureTime = earliestDepartureTime;
  }

  @Override
  @Temporal(TemporalType.TIMESTAMP)
  public void setLatestDepartureTime(Date latestDepartureTime) {

    this.latestDepartureTime = latestDepartureTime;
  }

  @Override
  public void setNumberOfPlaces(int numberOfPlaces) {

    this.numberOfPlaces = numberOfPlaces;
  }

  @Override
  public void setLuggageSpace(String luggageSpace) {

    this.luggageSpace = luggageSpace;
  }

  @Override
  public void setRSOfferIdMapped(long rsOfferIdMapped) {

    this.rsOfferIdMapped = rsOfferIdMapped;
  }

  @Override
  public long getUserId() {

    return this.userId;
  }

  @Override
  public long getFromLocation() {

    return this.fromLocation;
  }

  @Override
  public long getToLocation() {

    return this.toLocation;
  }

  @Override
  @Basic(optional = false)
  @Column(name = "EarliestDepartureTime", insertable = true, updatable = true)
  public Date getEarliestDepartureTime() {

    return this.earliestDepartureTime;
  }

  @Override
  @Basic(optional = false)
  @Column(name = "LatestDepartureTime", insertable = true, updatable = true)
  public Date getLatestDepartureTime() {

    return this.latestDepartureTime;
  }

  @Override
  public int getNumberOfPlaces() {

    return this.numberOfPlaces;
  }

  @Override
  public String getLuggageSpace() {

    return this.luggageSpace;
  }

  @Override
  public long getRSOfferIdMapped() {

    return this.rsOfferIdMapped;
  }
}
