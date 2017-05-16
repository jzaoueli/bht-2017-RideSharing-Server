package io.oasp.logistic.ridesharing.usermanagement.dataaccess.api.dao;

import io.oasp.logistic.ridesharing.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.module.jpa.dataaccess.api.MasterDataDao;
import io.oasp.logistic.ridesharing.usermanagement.dataaccess.api.CGUserProfileEntity;

public interface CGUserProfileDao extends ApplicationDao<CGUserProfileEntity>, MasterDataDao<CGUserProfileEntity> {
}
