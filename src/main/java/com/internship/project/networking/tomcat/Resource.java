package com.internship.project.networking.tomcat;

import com.internship.project.calculating.ArithmeticOperations;

import javax.ws.rs.*;

@Path("/calculations")
public class Resource {
    @POST
    @Path("/{expression}")
    @Produces("text/plain")
    public String calculate(@PathParam("expression") String expression) {
        ArithmeticOperations calculator = new ArithmeticOperations();
        String result = calculator.apply(expression);
        return "result = " + result;
    }
}