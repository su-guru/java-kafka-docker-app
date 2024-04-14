package org.jaka.resources;

import org.jaka.kafka.ProducerClient;
import org.jaka.context.CreditContext;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/kafka")
@RequestScoped
public class KafkaResource {

    @Inject
    ProducerClient client;

    @Inject
    CreditContext context;

    @GET
    @Path("/message")
    public Response sendMessage(@QueryParam("param1") String message) {
        client.execute(message);
        return Response.ok("Success sending message to kafka platform").build();
    }

    @GET
    @Path("/context")
    public Response context() {
        context.process();
        return Response.ok("Success context").build();
    }

}
