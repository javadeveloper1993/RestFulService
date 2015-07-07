package com.example.rest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author maulik.patel
 * 
 */
@Path("/hello")
public class HelloWorldRestService {

	@GET
	@Path("/{name}")
	public Response getMessage(@PathParam("name") String name) {
		String output = "Jersey say : " + name;
		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("/query")
	public Response getQueryMessage(
			@DefaultValue("Default Name") @QueryParam("name") String name,
			@DefaultValue("18") @QueryParam("age") int age) {
		String output = "Jersey Query Demo : " + name + " With Age : " + age;
		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("/query1")
	public Response getQuery1Message(@Context UriInfo uriInfo) {
		String output = "Jersey Query Demo Via Programatically : "
				+ uriInfo.getQueryParameters().getFirst("name")
				+ " With Age : " + uriInfo.getQueryParameters().getFirst("age");
		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("/matrix/{year}")
	public Response getBooks(@PathParam("year") String year,
			@DefaultValue("Default Name") @MatrixParam("name") String name,
			@MatrixParam("age") String age) {
		return Response
				.status(200)
				.entity("Matrix Demo : " + year + ", Name : " + name
						+ ", Age : " + age).build();
	}
}
