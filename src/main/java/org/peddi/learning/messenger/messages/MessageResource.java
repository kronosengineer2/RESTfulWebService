package org.peddi.learning.messenger.messages;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.peddi.learning.messenger.model.Message;
import org.peddi.learning.messenger.service.MessageService;

@Path("/messages")
// URI to map the resource
public class MessageResource {
	MessageService messageService = new MessageService();

	@GET
	// HTTP method
	@Produces(MediaType.APPLICATION_JSON)
	// Return format of the request
	public List<Message> getMessages() {
		return messageService.getAllMessages();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	// To tell that it consumes JSON
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}

	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	// To tell that it consumes JSON
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void removeMessage(@PathParam("messageId") long id) {
		messageService.removeMessage(id);
	}

	@Path("/{messageId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	/*
	 * Jersey is smart enough to convert the String messageID in the path
	 * variable to long
	 */
	public Message getMessage(@PathParam("messageId") long id) {
		return messageService.getMessage(id);
	}

}
