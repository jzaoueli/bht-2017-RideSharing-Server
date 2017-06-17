package io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.dataaccess.api;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.ApplicationPersistenceEntity;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.common.api.RSOffer;

@Entity
@Table(name = "RSOffer")
public class RSOfferEntity extends ApplicationPersistenceEntity implements RSOffer {

  private long userId;

  private long fromLocation;

  private long toLocation;

  private Date departureTime;

  private int delay;

  private int numberOfPlaces;

  private String luggageSpace;

  private boolean status;

  /**
   * The constructor.
   */
  public RSOfferEntity() {
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
  public void setDepartureTime(Date departureTime) {

    this.departureTime = departureTime;
  }

  @Override
  public void setDelay(int delay) {

    this.delay = delay;
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
  public void setStatus(boolean status) {

    this.status = status;
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
  @Column(name = "DepartureTime", insertable = true, updatable = true)
  @Temporal(TemporalType.TIMESTAMP)
  public Date getDepartureTime() {

    return this.departureTime;
  }

  @Override
  public int getDelay() {

    return this.delay;
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
  public boolean getStatus() {

    return this.status;
  }
}
