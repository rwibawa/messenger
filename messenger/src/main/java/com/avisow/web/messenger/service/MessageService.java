package com.avisow.web.messenger.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.avisow.web.messenger.model.Message;

public class MessageService {
	public List<Message> getAllMessages() {
		List<Message> list = new ArrayList<>(Arrays.asList(
				new Message(1L, "Hello World!", "Ryan Wibawa"),
				new Message(2L, "Hello Jersey", "Koushik")));
		
		return list;
	}
}
