package com.example.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author maulik.patel
 * 
 */
@Path("/user")
public class FormParamRestService {

	@POST
	@Path("/add")
	public Response addUser(@FormParam("name") String name,
			@FormParam("age") int age) {
		return Response.status(200)
				.entity("Add User Is called, Name Is : " + name + ", Age Is : " + age)
				.build();
	}

}
