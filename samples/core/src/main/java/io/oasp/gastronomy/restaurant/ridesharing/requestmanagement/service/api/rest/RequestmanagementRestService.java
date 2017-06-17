package io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.service.api.rest;

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
import io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.logic.api.Requestmanagement;
import io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.logic.api.to.RequestEto;

/**
 *
 * The service class for REST calls in order to execute the methods in {@link Requestmanagement}.
 *
 */
@Path("/requestmanagement")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface RequestmanagementRestService extends RestService {

  /**
   * @return a list of all {@link RequestEto}
   *
   */
  @GET
  @Path("/")
  @Deprecated
  List<RequestEto> getAllRequest();

  /**
   * @param id the id of a request
   * @return {@link RequestEto}
   */
  @GET
  @Path("/{id}")
  RequestEto getRequest(@PathParam("id") long id);

  /**
   * @param requestBo the request to be updated as JSON
   */
  @PUT
  @Path("/{id}")
  @Deprecated
  void updateRequest(RequestEto requestBo);

  /**
   * Calls {@link Requestmanagement#saveRequest}.
   *
   * @param requestEto the request to be created or updated
   * @return the saved {@link RequestEto}
   */
  @POST
  @Path("/")
  RequestEto saveRequest(RequestEto requestEto);

  /**
   * @param id the id
   */
  @DELETE
  @Path("/{id}")
  void deleteRequest(@PathParam("id") long id);

}
