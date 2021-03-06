package org.laybe.whichveggie.events;

public interface EventBus {

	void post(Object event);
	
	void postSticky(Object event);
	
	void register(Object subscriber);

	void registerSticky(Object subscriber);
	
	void unregister(Object subscriber);
	
}
