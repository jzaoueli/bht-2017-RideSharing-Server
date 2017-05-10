package io.oasp.logistic.ridesharing.userprofilemanagement.dataaccess.api;


import io.oasp.logistic.ridesharing.general.dataaccess.api.ApplicationPersistenceEntity;
import io.oasp.logistic.ridesharing.userprofilemanagement.common.api.CGUserProfile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CGUserProfile")
public class CGUserProfileEntity extends ApplicationPersistenceEntity implements CGUserProfile {

    private static final long serialVersionUID = 1L;

    private String name;

    private String firstName;

    private String lastName;

//  private Role role;

    /**
     * The constructor.
     */
    public CGUserProfileEntity() {

        super();
    }

    @Column(name = "login", unique = true)
    @Override
    public String getName() {

        return this.name;
    }

    @Override
    public void setName(String login) {

        this.name = login;
    }

    @Override
    public String getFirstName() {

        return this.firstName;
    }

    @Override
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    @Override
    public String getLastName() {

        return this.lastName;
    }

    @Override
    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

  /*
  @Override
  public Role getRole() {

    return this.role;
  }

  @Override
  public void setRole(Role role) {

    this.role = role;
  }
*/

}
