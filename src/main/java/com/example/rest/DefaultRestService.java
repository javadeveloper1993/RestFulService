package com.example.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * @author maulik.patel
 * 
 */
@Path("/")
public class DefaultRestService {

	@GET
	@Path("echo")
	public Response getEchoMessage() {
		String message = "Jersey Server Connection Establish Sucessfully...!!!";
		return Response.status(Status.OK).entity(message).build();
	}

}
