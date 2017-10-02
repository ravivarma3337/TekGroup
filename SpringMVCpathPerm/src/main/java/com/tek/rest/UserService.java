package com.tek.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserService {

	@GET
	@Path("{id}")
	public Response getUserById(@PathParam("id") String id) {

		return Response.status(200).entity("getUserById , id : " + id).build();

	}

	@GET
	@Path("{year}/{month}/{day}")
	public Response getUserHistory(@PathParam("year") int year, @PathParam("month") int month,
			@PathParam("day") int day) {

		String date = year + "/" + month + "/" + day;

		return Response.status(200).entity("getUserHistory , year/month/day : " + date).build();

	}

}