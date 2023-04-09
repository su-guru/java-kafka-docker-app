package org.jaka;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("hello")
@RequestScoped
public class HelloResource {

    @Inject
    ProducerLogic logic;
    @GET
    public Response hello() {
        logic.execute();
        return Response.ok("Success Producer").build();
    }
}
