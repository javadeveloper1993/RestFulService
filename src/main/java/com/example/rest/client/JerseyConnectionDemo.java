package com.example.rest.client;

import java.net.ConnectException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @author maulik.patel
 * 
 */
public class JerseyConnectionDemo {

	static Logger logger = Logger.getLogger(JerseyConnectionDemo.class);

	public static void main(String[] args) throws ConnectException {

		Client client = Client.create();
		WebResource webResource = client
				.resource("http://localhost:8080/MyWebApp/rest/echo");

		ClientResponse clientResponse = webResource.type(
				MediaType.APPLICATION_JSON).get(ClientResponse.class);

		if (clientResponse.getStatus() == Status.OK.getStatusCode()) {
			String output = clientResponse.getEntity(String.class);
			System.out.println(output);
		} else {
			throw new ConnectException();
		}

	}

}
