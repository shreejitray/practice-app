package com;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/mark2")
public class Mark2Service {
    @GET
    @Path("/")
    public String getMark2Response(){
        return "Mark2 response";
    }
}
