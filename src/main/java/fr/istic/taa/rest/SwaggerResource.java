package fr.istic.taa.rest;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.apache.log4j.Logger;

public class SwaggerResource {
	 private static final Logger logger = Logger.getLogger(SwaggerResource.class.getName());

	    @GET
	    public byte[] Get1() {
	        try {
	            return Files.readAllBytes(FileSystems.getDefault().getPath("src/main/webapp/index.html"));
	        } catch (IOException e) {
	            return null;
	        }
	    }

	    @GET
	    @Path("{path:.*}")
	    public byte[] Get(@PathParam("path") String path) {
	        try {
	            return Files.readAllBytes(FileSystems.getDefault().getPath("src/main/webapp/"+path));
	        } catch (IOException e) {
	            return null;
	        }
	    }
}
