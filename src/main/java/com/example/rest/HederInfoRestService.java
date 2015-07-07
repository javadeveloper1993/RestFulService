package com.example.rest;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 * @author maulik.patel
 * 
 */
@Path("/header")
public class HederInfoRestService {

	@GET
	@Path("/getInfo")
	public Response getMessage(@Context HttpHeaders httpHeaders) {
		return Response
				.status(200)
				.entity("Http Header Info : "
						+ getHttpHeaderString(httpHeaders)).build();
	}

	private String getHttpHeaderString(HttpHeaders httpHeaders) {
		String data = "";
		MultivaluedMap<String, String> requestHeaders = httpHeaders
				.getRequestHeaders();
		Set<Entry<String, List<String>>> entrySet = requestHeaders.entrySet();
		for (Entry<String, List<String>> entry : entrySet) {
			String key = entry.getKey();
			List<String> value = entry.getValue();
			data += "</br> \t <b>" + key + " : </b>";
			data += value;
		}
		return data;
	}
}
