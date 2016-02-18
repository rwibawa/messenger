package com.avisow.web.messenger.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.avisow.web.messenger.database.DatabaseStub;
import com.avisow.web.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseStub.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1L, "Hello World!", "Ryan Wibawa"));
		messages.put(2L, new Message(2L, "Hello Jersey", "Koushik"));
	}
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
		
		/*List<Message> list = new ArrayList<>(Arrays.asList(
				new Message(1L, "Hello World!", "Ryan Wibawa"),
				new Message(2L, "Hello Jersey", "Koushik")));
		
		return list;*/
	}

	public Message addMessages(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		
		messages.put(message.getId(), message);
		return message;
	}

	public void removeMessage(long messageId) {
		messages.remove(messageId);
	}

	public Message getMessage(long messageId) {
		return messages.get(messageId);
	}
}
