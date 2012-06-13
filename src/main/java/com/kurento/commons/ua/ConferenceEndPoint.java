package com.kurento.commons.ua;

import com.kurento.commons.ua.exception.ServerInternalErrorException;

public interface ConferenceEndPoint extends EndPoint {

	/**
	 * Creates a new outgoing call to a conference and initiates the negotiation
	 * with the called party specified. In order to start the procedure it must
	 * be provided a CallListener and a ConferenceListener that will receive
	 * call events
	 * <p>
	 * Method returns control immediately after it is called. Negotiation and
	 * setup is carried out asynchronously and progress is notified through
	 * events to the controller
	 * 
	 * @param remoteParty
	 *            Called party
	 * @param conference
	 *            The conference name that will be initiated
	 * @param callController
	 *            Listener of Call events
	 * @param conferenceListener
	 *            A listener to manage conference events
	 * @return the conference object
	 * @throws ServerInternalErrorException
	 *             If an error occurs preventing the local UA to initiate the
	 *             procedure
	 */
	public Conference dial(String remoteParty, String conference,
			CallListener callController, ConferenceListener conferenceListener)
			throws ServerInternalErrorException;

	/**
	 * Creates a new outgoing call to a conference and initiates the negotiation
	 * with the called party specified. In order to start the procedure it must
	 * be provided a CallListener and a ConferenceListener that will receive
	 * call events
	 * <p>
	 * Method returns control immediately after it is called. Negotiation and
	 * setup is carried out asynchronously and progress is notified through
	 * events to the controller
	 * 
	 * @param remoteParty
	 *            Called party
	 * @param conference
	 *            The conference name that will be initiated
	 * @param attributes
	 *            Extra attributes to be added to the call object
	 * @param callController
	 *            Listener of Call events
	 * @param conferenceListener
	 *            A listener to manage conference events
	 * @return the conference object
	 * @throws ServerInternalErrorException
	 *             If an error occurs preventing the local UA to initiate the
	 *             procedure
	 */
	public Conference dial(String remoteParty, String conference,
			CallAttributes attributes, CallListener callController,
			ConferenceListener conferenceListener)
			throws ServerInternalErrorException;

}
