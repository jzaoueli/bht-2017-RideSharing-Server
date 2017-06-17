package io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.logic.api.CGmanagement;
import io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.logic.api.to.CGMemberEto;

/**
 */
@Named("CGUsermanagementRestService")
public class CGUsermanagementRestServiceImpl implements CGUsermanagementRestService {

  private CGmanagement cgmanagement;

  @Inject
  public void setCGmanagement(CGmanagement cgManagement) {

    this.cgmanagement = cgManagement;
  }

  @Override
  @Deprecated
  public List<CGMemberEto> getAllCGMember() {

    return this.cgmanagement.findAllCGMembers();
  }

  @Override
  public CGMemberEto getMember(long id) {

    return this.cgmanagement.findMember(id);
  }

  @Override
  @Deprecated
  public CGMemberEto createMember(CGMemberEto cgMemberEto) {

    return this.cgmanagement.saveMember(cgMemberEto);
  }

  @Override
  public CGMemberEto saveMember(CGMemberEto cgMemberEto) {

    return this.cgmanagement.saveMember(cgMemberEto);
  }

  @Override
  public void deleteMember(long id) {

    this.cgmanagement.deleteMember(id);
  }

}
