package com.kurento.commons.ua;

import java.text.ParseException;

import com.kurento.commons.ua.exception.ServerInternalErrorException;

/**
 * The User Agent (UA) is the common interface provided by communications
 * components to applications. There will be an UA implementation for each
 * domain and platform where Kurento connects <br>
 * The UA can host multiple EndPoints, each one with a single URI representing a
 * service point or user. The UA can host multiple EndPoints, being able to manage
 * simultaneously communications for different users.
 * <br> Th User Agent is the software element that manages protocol internals.
 * Its functions are:
 * <ul>
 * <li>Encode and decode messages. It must be able to handle header values
 * <li>Send and receive packets
 * <li>Register and un-register URI contacts. It manages a list of active {@link EndPoint}
 * <li>Multiplex messages among EndPoints. Automatically discard messages not addressed
 * to any known EndPoint
 * 
 * @version 1.0.0
 */
public interface UA {

	// public UserAgentHeader getUserAgentHeader();
	
	/**
	 * Returns IP address where stack listens
	 * @return Local IP address
	 */
	@Deprecated
	public String getLocalAddress();

	/**
	 * Returns port number where local stack is binded
	 * @return Local port
	 */
	@Deprecated
	public int getLocalPort();

	/**
	 * Returns Proxy IP address where messages are sent
	 * @return Proxy address
	 */
	@Deprecated
	public String getProxyAddress();

	/**
	 * Returns Proxy port number where messages are sent
	 * @return Proxy port
	 */
	@Deprecated
	public int getProxyPort();

	/**
	 * Terminate the UA. This process will perform the procedure below
	 * <ul>
	 * <li>Terminate all Call managed by this UA
	 * <li>Un-register URI from all EndPoint
	 * <li>Terminate the stack and free the network socket
	 * </ul>
	 */
	public void terminate();

	/**
	 * Creates a new EndPoint for the given URI (user@realm) and registers
	 * a contact for that URI in the configured REGISTRAR. On registration
	 * it is mandatory to provide a reference to the listener object that will
	 * receive all events generated by the EndPoint
	 * 
	 * @param user
	 *            User name of the URI
	 * @param realm
	 *            Domain name of the URI
	 * @param password
	 *            User password if authentication is enabled on the REGISTRAR
	 * @param expires
	 *            Contact expire time
	 * @param handler
	 *            Listener object receiving events from the created EndPoint
	 * @return Created EndPoint managing URI
	 * @throws ParseException
	 *             if forbidden characters are provided for the user or realm
	 *             parameters
	 * @throws ServerInternalErrorException
	 *             if an internal error is found that prevents the registration
	 *             process to complete
	 */
	public EndPoint registerEndPoint(String user, String realm,
			String password, int expires, EndPointListener handler)
			throws ParseException, ServerInternalErrorException;

}