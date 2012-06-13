package com.kurento.commons.ua;

public interface Conference extends Call {

	public void terminateConference();

	public void invite(String remoteParty);

	public void invite(String remoteParty, CallAttributes attributes);

	public void setMain(String connectionId);

	public void setMute(String connectionId, Boolean mute);

	/**
	 * Add a new listener object that will receive conference events
	 */
	public void addListener(ConferenceListener listener);

	/**
	 * Remove an object from the list of elements receiving conference event
	 * notifications
	 * 
	 * @param listener
	 */
	public void removeListener(ConferenceListener listener);
}