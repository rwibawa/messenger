package com.avisow.web.messenger.resources;

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

import com.avisow.web.messenger.model.Message;
import com.avisow.web.messenger.model.Profile;
import com.avisow.web.messenger.service.MessageService;
import com.avisow.web.messenger.service.ProfileService;

@Path("/profiles")
public class ProfileResources {
	
	ProfileService profileService = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles() {
		return profileService.getAllProfiles();
	}
	
	@GET
	@Path("/{profileId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfile(@PathParam("profileId") long profileId) {
		return profileService.getProfile(profileId);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile updateProfile(@PathParam("profileId") long profileId, Profile profile) {
		profile.setId(profileId);
		return profileService.updateProfile(profile);
	}
	
	/*
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message deleteMessage(@PathParam("messageId") long messageId) {
		return messageService.removeMessage(messageId);
	}*/

}
