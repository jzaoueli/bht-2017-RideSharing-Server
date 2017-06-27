package io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.dataaccess.dao;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.dataaccess.CGMemberEntity;
import io.oasp.gastronomy.restaurant.ridesharing.general.CGUserProfile;
import io.oasp.module.jpa.dataaccess.api.MasterDataDao;

/**
 * {@link ApplicationDao Data Access Object} for {@link CGMemberEntity} entity.
 *
 */
public interface CGMemberDao extends ApplicationDao<CGMemberEntity>, MasterDataDao<CGMemberEntity> {

    CGUserProfile findByName(String name);
}
