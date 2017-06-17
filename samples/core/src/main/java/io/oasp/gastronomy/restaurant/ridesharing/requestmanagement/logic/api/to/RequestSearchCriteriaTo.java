package io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.logic.api.to;

import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.common.api.RSOffer;
import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 */
public class RequestSearchCriteriaTo extends SearchCriteriaTo {

    private RSOffer rsOffer;

    /**
     * The constructor.
     */
    public RequestSearchCriteriaTo() {

        super();
    }

    /**
     * @return rsOffer
     */
    public RSOffer getRSOffer() {

        return this.rsOffer;
    }

    /**
     * @param rsOffer the rsOffer to set
     */
    public void setRSOffer(RSOffer rsOffer) {

        this.rsOffer = rsOffer;
    }

}
