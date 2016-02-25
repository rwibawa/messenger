package com.avisow.web.messenger.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.avisow.web.messenger.database.DatabaseStub;
import com.avisow.web.messenger.database.HibernateStub;
import com.avisow.web.messenger.model.Message;
import com.avisow.web.messenger.model.Profile;

public class ProfileService {
	
	private Map<Long, Message> messages = DatabaseStub.getMessages();
	private HibernateStub stub = new HibernateStub();
	
	public ProfileService() {
//		messages.put(1L, new Message(1L, "Hello World!", "Ryan Wibawa"));
//		messages.put(2L, new Message(2L, "Hello Jersey", "Koushik"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(stub.getProfiles());
	}

	public Profile addProfile(Profile profile) {
		profile = new Profile(profile.getProfileName(), profile.getFirstName(), profile.getLastName());
		stub.add(profile);
		
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getId() <= 0) {
			return null;
		}
		
		profile = stub.update(profile);
		return profile;
	}

	public Message removeMessage(long messageId) {
		return messages.remove(messageId);
	}

	public Profile getProfile(long profileId) {
		return stub.get(profileId);
	}
}
