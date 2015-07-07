package com.example.rest.filter.server;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

/**
 * @author Maulik
 * 
 */
public class ContainerResponseFilterDemo implements ContainerResponseFilter {

	@Override
	public ContainerResponse filter(ContainerRequest request,
			ContainerResponse response) {
		System.out.println(" >>>> In Container Response Filter >>>>>>");
		System.out.println("Status : " + response.getStatus());
		System.out.println("Entity : " + response.getResponse().getEntity());
		return response;
	}

}
