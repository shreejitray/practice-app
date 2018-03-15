package com;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Component
@Path("/query")
public class QueryService {

    @GET
    @Path("/name")
    @Produces("application/JSON")
    public Response getName() {
        System.out.println("inside getname");
        Response response = Response.ok("Shreejit").build();
        return response;
    }


}
