package com.avisow.web.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.avisow.web.messenger.model.Message;
import com.avisow.web.messenger.model.Profile;

public class DatabaseStub {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<Long, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static Map<Long, Profile> getProfiles() {
		return profiles;
	}

}
