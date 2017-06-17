package io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.service.api.rest;

import java.util.List;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.logic.api.TransportPointmanagement;
import io.oasp.gastronomy.restaurant.ridesharing.transportpointmanagement.logic.api.to.TransportPointEto;

/**
 * The service class for REST calls in order to execute the methods in {@link TransportPointmanagement}.
 *
 */
@Path("/transportpoint")
@Named("TransportPointmanagementRestService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface TransportPointmanagementRestService {

  @GET
  @Path("/")
  @Deprecated
  List<TransportPointEto> getAllTransportPoints();

  @GET
  @Path("/{id}/")
  TransportPointEto getTransportPoint(@PathParam("id") long id);

  @PUT
  @Path("/{id}")
  @Deprecated
  void updateTransportPoint(TransportPointEto transportPoint);

  @POST
  @Path("/")
  TransportPointEto saveTransportPoint(TransportPointEto transportPoint);

  @DELETE
  @Path("/{id}/")
  void deleteTransportPoint(@PathParam("id") long id);

}
