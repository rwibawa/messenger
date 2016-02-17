package com.avisow.web.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.avisow.web.messenger.model.Message;
import com.avisow.web.messenger.service.MessageService;

@Path("/messages")
public class MessageResources {
	
	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage(@PathParam("messageId") String messageId) {
		return "test";
	}

}
