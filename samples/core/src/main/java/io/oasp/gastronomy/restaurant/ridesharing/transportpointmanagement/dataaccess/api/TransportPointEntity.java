package io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.dataaccess.api;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.ApplicationPersistenceEntity;
import io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.common.api.TransportPoint;

@Entity
@javax.persistence.Table(name = "TRANSPORTPOINT")
public class TransportPointEntity extends ApplicationPersistenceEntity implements TransportPoint {

  private static final long serialVersionUID = 1L;

  /*
   * @Id
   *
   * @GeneratedValue(strategy = GenerationType.AUTO)
   *
   * @Column(name = "ID") private Long id;
   *
   * @Column(name = "modificationCounter") private int modificationCounter;
   */
  @Column(name = "Name")
  private String name;

  @Column(name = "CGLocation")
  private boolean cgLocation;

  @Column(name = "Country")
  private String country;

  @Column(name = "City")
  private String city;

  @Column(name = "LocationAddress")
  private String locationAddress;

  @Column(name = "GPSCoordination")
  private String gpsCoordination;

  public TransportPointEntity() {
    super();
  }

  @Override
  public String getName() {

    return this.name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public boolean getCgLocation() {

    return this.cgLocation;
  }

  @Override
  public void setCgLocation(boolean cgLocation) {

    this.cgLocation = cgLocation;
  }

  @Override
  public String getCountry() {

    return this.country;
  }

  @Override
  public void setCountry(String country) {

    this.country = country;
  }

  @Override
  public String getCity() {

    return this.city;
  }

  @Override
  public void setCity(String city) {

    this.city = city;
  }

  @Override
  public String getLocationAddress() {

    return this.locationAddress;
  }

  @Override
  public void setLocationAddress(String locationAddress) {

    this.locationAddress = locationAddress;
  }

  @Override
  public String getGpsCoordination() {

    return this.gpsCoordination;
  }

  @Override
  public void setGpsCoordination(String gpsCoordination) {

    this.gpsCoordination = gpsCoordination;
  }

}