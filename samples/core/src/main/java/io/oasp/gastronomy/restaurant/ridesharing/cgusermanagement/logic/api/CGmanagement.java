package io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.logic.api;

import java.util.List;

import javax.validation.Valid;

import io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.logic.api.to.CGMemberEto;

/**
 * Interface for StaffManagement component.
 *
 */
public interface CGmanagement {

  /**
   * @return {@link List} of all existing {@link CGMemberEto staff members}.
   */
  List<CGMemberEto> findAllCGMembers();

  CGMemberEto findMember(Long id);

  CGMemberEto saveMember(@Valid CGMemberEto member);

  void deleteMember(Long memberId);

}
