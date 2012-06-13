package com.kurento.commons.ua;


public interface ConferenceListener {

	void onMainStatusChanged(String connectionId, Boolean main);

	void onMuteStatusChanged(String connectionId, Boolean muteStatus);

	void onConnectionAdded(String connectionId);

	void onConnectionRemoved(String connectionId);

	void onTerminated();
}
