package com.example.rest.client;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @author maulik.patel
 * 
 */
public class JerseyClientPostDemo {

	static Logger logger = Logger.getLogger(JerseyClientPostDemo.class);

	public static void main(String[] args) {
		try {

			// JacksonJsonProvider jacksonJsonProvider = new
			// JacksonJaxbJsonProvider()
			// .configure(
			// DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
			// false);
			// ClientConfig clientConfig = new DefaultClientConfig();
			// clientConfig.getFeatures().put(
			// JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			// clientConfig.getClasses().add(jacksonJsonProvider.getClass());
			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8080/MyWebApp/rest/json/post");

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("name", "Maulik J Patel");
			jsonObject.put("address", "Pratik Park Flat, Ranip, Ahmedabad");

			ClientResponse clientResponse = webResource.type(
					MediaType.APPLICATION_JSON).post(ClientResponse.class,
					jsonObject.toString());

			if (clientResponse.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ clientResponse.getStatus());
			}

			String output = clientResponse.getEntity(String.class);
			System.out.println(output);

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
