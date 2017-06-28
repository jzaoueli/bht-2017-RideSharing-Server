package io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.logic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import io.oasp.gastronomy.restaurant.general.common.api.Usermanagement;
import io.oasp.gastronomy.restaurant.general.common.api.constants.PermissionConstants;
import io.oasp.gastronomy.restaurant.ridesharing.general.CGUserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.oasp.gastronomy.restaurant.general.logic.base.AbstractComponentFacade;
import io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.dataaccess.CGMemberEntity;
import io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.dataaccess.dao.CGMemberDao;
import io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.logic.api.CGmanagement;
import io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.logic.api.to.CGMemberEto;

@Named
@Component
@Transactional
public class CGmanagementImpl extends AbstractComponentFacade implements CGmanagement, Usermanagement {

  private static final Logger LOG = LoggerFactory.getLogger(CGmanagementImpl.class);

  private CGMemberDao cgMemberDao;

  @Inject
  public void setCGMemberDao(CGMemberDao cgMemberDao) {

    this.cgMemberDao = cgMemberDao;
  }

  public CGMemberDao getCGMemberDao() {

    return this.cgMemberDao;
  }

  @RolesAllowed(PermissionConstants.FIND_CG_MEMBER)
  @Override
  public CGMemberEto findMember(Long id) {

    return getBeanMapper().map(getCGMemberDao().find(id), CGMemberEto.class);
  }

  @RolesAllowed(PermissionConstants.FIND_CG_MEMBER)
  @Override
  public List<CGMemberEto> findAllCGMembers() {

    List<CGMemberEntity> members = getCGMemberDao().findAll();
    List<CGMemberEto> membersBo = new ArrayList<>();

    for (CGMemberEntity member : members) {
      membersBo.add(getBeanMapper().map(member, CGMemberEto.class));
    }

    return membersBo;
  }

  @RolesAllowed(PermissionConstants.SAVE_CG_MEMBER)
  @Override
  public CGMemberEto saveMember(CGMemberEto cgMember) {

    Objects.requireNonNull(cgMember, "cgMember");

    Long id = cgMember.getId();
    CGMemberEntity targetCGMember = null;

    if (id != null) {
      targetCGMember = getCGMemberDao().find(id);
    }
    if (targetCGMember == null) {
      // CGMember is new: -> create
      LOG.debug("Saving CGMember with id '{}' to the database.", id);
    } else {
      // CGMember already exists: -> Update
      LOG.debug("Updating StaCGMemberffMember with id '{}' in the database.", id);
      if (!Objects.equals(targetCGMember.getName(), cgMember.getName())) {
        LOG.debug("Changing login of StaffMember with id '{}' from '{}' to '{}' in the database.", id,
            targetCGMember.getName(), cgMember.getName());
      }
    }
    CGMemberEntity persistedcgMember = getCGMemberDao().save(getBeanMapper().map(cgMember, CGMemberEntity.class));
    return getBeanMapper().map(persistedcgMember, CGMemberEto.class);
  }

  @RolesAllowed(PermissionConstants.DELETE_CG_MEMBER)
  @Override
  public void deleteMember(Long memberId) {

    getCGMemberDao().delete(memberId);
  }

  @Override
  public CGUserProfile findUserProfileByLogin(String name) {
    return privateFindMemberByName(name);
  }

  private CGMemberEto privateFindMemberByName(String name) {
    return getBeanMapper().map(getCGMemberDao().findByName(name), CGMemberEto.class);
  }
}
