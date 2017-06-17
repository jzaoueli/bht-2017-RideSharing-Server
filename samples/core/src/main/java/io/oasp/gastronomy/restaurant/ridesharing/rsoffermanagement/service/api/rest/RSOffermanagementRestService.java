package io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.service.api.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.oasp.gastronomy.restaurant.general.common.api.RestService;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.logic.api.RSOffermanagement;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.logic.api.to.RSOfferEto;

/**
 *
 * The service class for REST calls in order to execute the methods in {@link RSOffermanagement}.
 *
 */
@Path("/rsoffermanagement")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface RSOffermanagementRestService extends RestService {

  /**
   * @return a list of all {@link RSOfferEto}
   *
   */
  @GET
  @Path("/")
  @Deprecated
  List<RSOfferEto> getAllRSOffer();

  /**
   * @param id the id of a rsoffer
   * @return {@link RSOfferEto}
   */
  @GET
  @Path("/{id}")
  RSOfferEto getRSOffer(@PathParam("id") long id);

  /**
   * @param rsofferBo the rsoffer to be updated as JSON
   */
  @PUT
  @Path("/{id}")
  @Deprecated
  void updateRSOffer(RSOfferEto rsofferBo);

  /**
   * Calls {@link RSOffermanagement#saveRSOffer}.
   *
   * @param rsofferEto the rsoffer to be created or updated
   * @return the saved {@link RSOfferEto}
   */
  @POST
  @Path("/")
  RSOfferEto saveRSOffer(RSOfferEto rsofferEto);

  /**
   * @param id the id
   */
  @DELETE
  @Path("/{id}")
  void deleteRSOffer(@PathParam("id") long id);

}
