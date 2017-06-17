package io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.oasp.gastronomy.restaurant.general.common.api.RestService;
import io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.logic.api.to.CGMemberEto;

@Path("/cgusermanagement/v1/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CGUsermanagementRestService extends RestService {

  @GET
  @Path("/")
  @Deprecated
  List<CGMemberEto> getAllCGMember();

  @GET
  @Path("/{id}/")
  CGMemberEto getMember(@PathParam("id") long id);

  @POST
  @Path("/")
  @Deprecated
  CGMemberEto createMember(CGMemberEto cgMemberEto);

  @POST
  @Path("/")
  CGMemberEto saveMember(CGMemberEto cgMemberEto);

  @DELETE
  @Path("/{id}/")
  void deleteMember(@PathParam("id") long id);

}
