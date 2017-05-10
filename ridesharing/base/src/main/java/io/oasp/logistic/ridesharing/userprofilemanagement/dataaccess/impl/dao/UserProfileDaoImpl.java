package io.oasp.logistic.ridesharing.userprofilemanagement.dataaccess.impl.dao;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;
import io.oasp.logistic.ridesharing.general.common.api.constants.NamedQueries;
import io.oasp.logistic.ridesharing.userprofilemanagement.dataaccess.api.CGUserProfileEntity;
import io.oasp.logistic.ridesharing.userprofilemanagement.dataaccess.api.dao.UserProfileDao;
import io.oasp.logistic.ridesharing.userprofilemanagement.logic.api.to.UserProfileSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

import javax.inject.Named;
import javax.persistence.TypedQuery;

import static com.mysema.query.alias.Alias.$;

import io.oasp.logistic.ridesharing.general.dataaccess.base.dao.ApplicationMasterDataDaoImpl;

/**
 * Implementation of {@link UserProfileDao}.
 */
@Named
public class UserProfileDaoImpl extends ApplicationMasterDataDaoImpl<CGUserProfileEntity> implements UserProfileDao {

    /**
     * The constructor.
     */
    public UserProfileDaoImpl() {

        super();
    }

    @Override
    public Class<CGUserProfileEntity> getEntityClass() {

        return CGUserProfileEntity.class;
    }

    @Override
    public CGUserProfileEntity findByLogin(String login) {

        TypedQuery<CGUserProfileEntity> query =
                getEntityManager().createNamedQuery(NamedQueries.GET_USER_PROFILE_BY_LOGIN, CGUserProfileEntity.class);
        query.setParameter("login", login);
        return query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginatedListTo<CGUserProfileEntity> findUserProfiles(UserProfileSearchCriteriaTo criteria) {

        CGUserProfileEntity userProfile = Alias.alias(CGUserProfileEntity.class);
        EntityPathBase<CGUserProfileEntity> alias = $(userProfile);
        JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

        String firstName = criteria.getFirstName();
        if (firstName != null) {
            query.where($(userProfile.getFirstName()).eq(firstName));
        }
        String lastName = criteria.getLastName();
        if (lastName != null) {
            query.where($(userProfile.getLastName()).eq(lastName));
        }
        String name = criteria.getName();
        if (name != null) {
            query.where($(userProfile.getName()).eq(name));
        }

        //Role role = criteria.getRole();
        //if (role != null) {
        //  query.where($(userProfile.getRole()).eq(role));
        //}

        return findPaginated(criteria, query, alias);
    }
}
