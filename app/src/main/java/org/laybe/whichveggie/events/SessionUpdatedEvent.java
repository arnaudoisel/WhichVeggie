package org.laybe.whichveggie.events;

import org.laybe.whichveggie.models.User;

public class SessionUpdatedEvent {

	private User user;
	
	public SessionUpdatedEvent(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
}
