package com.example.rest.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class JsonUtil {

	static ObjectMapper mapper = new ObjectMapper();

	public static String prettyPrinter(Object object) {
		if (object == null) {
			return null;
		}
		try {
			ObjectWriter writer = mapper.writer().withDefaultPrettyPrinter();
			return writer.writeValueAsString(object);
		} catch (Exception e) {
		}
		return null;
	}
}
