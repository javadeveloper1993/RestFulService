package com.example.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.sun.jersey.multipart.FormDataParam;

/**
 * @author maulik.patel
 * 
 */
@Path("/file")
public class FileService {

	@GET
	@Path("/getText")
	@Produces("text/plain")
	public Response getFile(@Context ServletContext servletContext) {
		String FILE_PATH = servletContext.getRealPath("") + File.separator
				+ "resources" + File.separator + "Log.txt";
		System.out.println("FILE_PATH :" + FILE_PATH);
		File file = new File(FILE_PATH);
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
				"attachment; filename=\"file_from_server.txt\"");
		return response.build();
	}

	@GET
	@Path("/getPdf")
	@Produces("application/pdf")
	public Response getPdfFile(@Context ServletContext servletContext) {
		String FILE_PATH = servletContext.getRealPath("") + File.separator
				+ "resources" + File.separator + "Log.pdf";
		System.out.println("FILE_PATH :" + FILE_PATH);
		File file = new File(FILE_PATH);
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
				"attachment; filename=\"file_from_server.pdf\"");
		return response.build();
	}

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(
			@FormDataParam("file") InputStream uploadedInputStream,
			@Context ServletContext servletContext) {
		String FILE_PATH = servletContext.getRealPath("") + File.separator
				+ "resources" + File.separator + "Upload.pdf";
		System.out.println("FILE_PATH :" + FILE_PATH);
		// save it
		writeToFile(uploadedInputStream, FILE_PATH);
		String output = "File uploaded to : " + FILE_PATH;
		return Response.status(200).entity(output).build();
	}

	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream,
			String uploadedFileLocation) {
		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
