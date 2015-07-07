package com.example.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.rest.model.Customer;
import com.example.rest.util.JsonUtil;

/**
 * @author maulik.patel
 * 
 */
@Path("/json")
public class JSONService {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomerInJSON() {
		Customer track = new Customer();
		track.setName("Parth J Patel");
		track.setAddress("Ahmedabad");
		return track;
	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCustomerInJSON(Customer customer) {
		return Response.status(201)
				.entity(JsonUtil.prettyPrinter(customer)).build();
	}

}
