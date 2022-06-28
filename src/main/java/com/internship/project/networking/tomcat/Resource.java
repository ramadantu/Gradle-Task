package com.internship.project.networking.tomcat;

import com.internship.project.calculating.ArithmeticOperations;

import javax.ws.rs.*;

@Path("/calculations")
public class Resource {
    @POST
    @Consumes("text/plain")
    @Produces("text/plain")
    public String calculate(String expression) {
        ArithmeticOperations calculator = new ArithmeticOperations();
        return calculator.apply(expression);
    }
}