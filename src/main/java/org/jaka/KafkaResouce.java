package org.jaka;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("kafka")
@RequestScoped
public class KafkaResouce {

    @Inject
    ProducerClient client;
    
    @GET
    public Response sendMessage(@QueryParam("param1") String message) {
        client.execute(message);
        return Response.ok("Success sending message to kafka platform").build();
    }
}
