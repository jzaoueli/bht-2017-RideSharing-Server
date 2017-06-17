package io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.logic.api.to;

import io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.common.api.Request;
import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * Created by jihed zaoueli on 13.06.17 at 23:13.
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 */
public class RSOfferSearchCriteriaTo extends SearchCriteriaTo{

    private Request request;

    /**
     * The constructor.
     */
    public RSOfferSearchCriteriaTo() {

        super();
    }

    /**
     * @return request
     */
    public Request getRequest() {
        return request;
    }

    /**
     * @param request to as Criteria
     */
    public void setRequest(Request request) {
        this.request = request;
    }

}
