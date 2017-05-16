package io.oasp.logistic.ridesharing.transportpointmanagement.dataaccess.api;


import io.oasp.logistic.ridesharing.general.dataaccess.api.ApplicationPersistenceEntity;

import javax.persistence.*;


@Entity
@javax.persistence.Table(name = "TransportPoint")
public class TransportPointEntity extends ApplicationPersistenceEntity implements TransportPoint {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean getCgLocation() {
        return cgLocation;
    }

    @Override
    public void setCgLocation(boolean cgLocation) {
        this.cgLocation = cgLocation;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String getLocationAddress() {
        return locationAddress;
    }

    @Override
    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    @Override
    public String getGpsCoordination() {
        return gpsCoordination;
    }

    @Override
    public void setGpsCoordination(String gpsCoordination) {
        this.gpsCoordination = gpsCoordination;
    }


}
