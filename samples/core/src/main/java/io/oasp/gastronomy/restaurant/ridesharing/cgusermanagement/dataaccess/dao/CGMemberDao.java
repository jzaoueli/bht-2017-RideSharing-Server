package io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.dataaccess.dao;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.dataaccess.CGMemberEntity;
import io.oasp.gastronomy.restaurant.staffmanagement.dataaccess.api.StaffMemberEntity;
import io.oasp.module.jpa.dataaccess.api.MasterDataDao;

/**
 * {@link ApplicationDao Data Access Object} for {@link StaffMemberEntity} entity.
 *
 */
public interface CGMemberDao extends ApplicationDao<CGMemberEntity>, MasterDataDao<CGMemberEntity> {

}
