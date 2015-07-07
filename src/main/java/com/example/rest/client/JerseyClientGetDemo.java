package com.example.rest.client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @author maulik.patel
 * 
 */
public class JerseyClientGetDemo {

	public static void main(String[] args) {

		Client client = new Client();
		System.out.println("Client :" + client);

		WebResource webResource = client
				.resource("http://localhost:8080/MyWebApp/rest/json/get");

		ClientResponse clientResponse = webResource.accept(
				MediaType.APPLICATION_JSON).get(ClientResponse.class);

		if (clientResponse.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ clientResponse.getStatus());
		}
		String output = clientResponse.getEntity(String.class);
		System.out.println(output);
	}

}
