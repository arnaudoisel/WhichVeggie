package org.laybe.whichveggie.controllers;

import javax.inject.Inject;

import org.laybe.whichveggie.events.EventBus;
import org.laybe.whichveggie.events.RestartCurrentAndTerminateOthersActivitiesEvent;
import org.laybe.whichveggie.events.SessionUpdatedEvent;
import org.laybe.whichveggie.modules.ForApplication;

public class AppControllerImpl implements AppController {

	private EventBus eventBus;

	@Inject
	public AppControllerImpl(@ForApplication EventBus eventBus) {
		this.eventBus = eventBus;
		this.eventBus.register(this);
	}
	
	public void onEvent(SessionUpdatedEvent event) {
		doRestartCurrentActivityAndTerminateOthers();
	}
	
	private void doRestartCurrentActivityAndTerminateOthers() {
		eventBus.post(new RestartCurrentAndTerminateOthersActivitiesEvent());
	}
}
