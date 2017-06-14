package io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.logic.api.to;

import io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.common.api.TransportPoint;
import io.oasp.module.basic.common.api.to.AbstractEto;

/**
 * The {@link AbstractEto ETO} for a {@link TransportPoint}.
 *
 */
public class TransportPointEto extends AbstractEto implements TransportPoint {

  // UUID
  private static final long serialVersionUID = 1L;

  // private Long id;

  private String name;

  private boolean cgLocation;

  private String country;

  private String city;

  private String locationAddress;

  private String gpsCoordination;

  /**
   * The constructor.
   */
  public TransportPointEto() {
    super();
  }

  /*
   * @Override public Long getID() {
   *
   * return this.id; }
   */

  /*
   * @Override public void setID(Long id) {
   *
   * this.id = id; }
   */

  @Override
  public String getName() {

    return this.name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public void setCgLocation(boolean cgLocation) {

    this.cgLocation = cgLocation;
  }

  @Override
  public boolean getCgLocation() {

    return this.cgLocation;
  }

  @Override
  public void setCountry(String country) {

    this.country = country;
  }

  @Override
  public String getCountry() {

    return this.country;
  }

  @Override
  public void setCity(String city) {

    this.city = city;
  }

  @Override
  public String getCity() {

    return this.city;
  }

  @Override
  public void setLocationAddress(String locationAddress) {

    this.locationAddress = locationAddress;

  }

  @Override
  public String getLocationAddress() {

    return this.locationAddress;
  }

  @Override
  public void setGpsCoordination(String gpsCoordination) {

    this.gpsCoordination = gpsCoordination;
  }

  @Override
  public String getGpsCoordination() {

    return this.gpsCoordination;
  }

}
