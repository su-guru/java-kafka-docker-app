package org.jaka.resources;

import org.jaka.model.Message;
import org.jaka.service.MessageService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

@ApplicationScoped
@Path("message")
public class MessageResource {
    @Inject
    MessageService messageService;

    @GET
    @Path("add")
    public Message add(@QueryParam("message") String message) {
        return messageService.create(message);
    }

    @GET
    public List<Message> list() {
        return messageService.findAll();
    }
}
