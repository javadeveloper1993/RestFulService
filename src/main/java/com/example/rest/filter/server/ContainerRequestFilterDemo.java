package com.example.rest.filter.server;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

/**
 * @author Maulik
 * 
 */
public class ContainerRequestFilterDemo implements ContainerRequestFilter {

	@Override
	public ContainerRequest filter(ContainerRequest request) {
		System.out.println(" >>>> In Container Request Filter >>>>>>");
		System.out.println("isSecure : " + request.isSecure());
		System.out.println("Method : " + request.getMethod());
		System.out.println("Path : " + request.getPath());
		System.out.println("RequestUri : " + request.getRequestUri());
		return request;
	}

}
