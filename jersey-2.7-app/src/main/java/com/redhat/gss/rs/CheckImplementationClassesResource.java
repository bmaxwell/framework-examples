package com.redhat.gss.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.RuntimeDelegate;

@Path("/check")
public class CheckImplementationClassesResource {

	@Context
	HttpHeaders httpHeaders;

	@Context
	UriInfo uriInfo;

	@Context
	Request request;

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String doGet() {
		StringBuffer output = new StringBuffer();
		output.append("<h1>" + JAXRSUtil.getJAXRSVersion() + " with " + JAXRSUtil.getImpl() + " </h1>");
		output.append("<h2> Implementation class </h2>");
		output.append("<b>RuntimeDelegate </b> " + JAXRSUtil.clName(RuntimeDelegate.getInstance()));
		output.append("<br />");
		output.append("<b>ResponseBuilder:</b> " + JAXRSUtil.clName(Response.ok()));
		output.append("<br />");
		output.append("<b>UriBuilder:</b> " + JAXRSUtil.clName(UriBuilder.fromUri("test")));
		output.append("<br />");
		return output.toString();
	}
}