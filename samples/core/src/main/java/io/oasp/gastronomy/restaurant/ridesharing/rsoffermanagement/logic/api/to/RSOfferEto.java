package io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.logic.api.to;

import java.util.Date;

import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.common.api.RSOffer;
import io.oasp.module.basic.common.api.to.AbstractEto;

public class RSOfferEto extends AbstractEto implements RSOffer {

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
  public RSOfferEto() {
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
