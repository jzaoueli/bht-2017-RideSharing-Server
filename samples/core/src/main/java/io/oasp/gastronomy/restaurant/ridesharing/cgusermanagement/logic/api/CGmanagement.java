package io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.logic.api;

import java.util.List;

import javax.validation.Valid;

import io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.logic.api.to.CGMemberEto;
import io.oasp.gastronomy.restaurant.staffmanagement.logic.api.to.StaffMemberEto;

/**
 * Interface for StaffManagement component.
 *
 */
public interface CGmanagement {

  /**
   * @return {@link List} of all existing {@link StaffMemberEto staff members}.
   */
  List<CGMemberEto> findAllCGMembers();

  CGMemberEto findMember(Long id);

  CGMemberEto saveMember(@Valid CGMemberEto member);

  void deleteMember(Long memberId);

}
