package com.kurento.commons.sip;

import java.util.Map;

import com.kurento.commons.mscontrol.join.JoinableStream;
import com.kurento.commons.mscontrol.networkconnection.NetworkConnection;
import com.kurento.commons.sdp.enums.MediaType;
import com.kurento.commons.sdp.enums.Mode;
import com.kurento.commons.sip.exception.ServerInternalErrorException;

public interface SipCall {

	// Control interface
	public void accept() throws ServerInternalErrorException;

	public void reject() throws ServerInternalErrorException;

	public void hangup() throws ServerInternalErrorException;

	public void cancel() throws ServerInternalErrorException;

	// monitor interface
	public Boolean isConnected();

	// Callbacks
	public void addListener(SipCallListener listener);

	public void removeListener(SipCallListener listener);

	// Media
	public NetworkConnection getNetworkConnection(
			JoinableStream.StreamType media);

	public Map<MediaType, Mode> getMediaTypesModes();

	public String getRemoteUri();

	public String getRemoteDisplayName();

}
