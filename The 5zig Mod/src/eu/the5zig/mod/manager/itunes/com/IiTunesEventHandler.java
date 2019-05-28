package eu.the5zig.mod.manager.itunes.com;

public interface IiTunesEventHandler {

	/**
	 * The ITEventPlayerPlay event is fired when a track begins playing.
	 * <p>
	 * When iTunes switches to playing another track, you will received an ITEventPlayerStop event followed by an ITEventPlayerPlay event, unless it is playing joined CD tracks
	 * (see _IiTunesEvents::OnPlayerPlayingTrackChangedEvent).
	 *
	 * @param track An IITTrack object corresponding to the track that has started playing.
	 */
	void onPlayerPlay(IITTrack track);

	/**
	 * The ITEventPlayerPlayingTrackChanged event is fired when information about the currently playing track has changed.
	 * <p>
	 * This event is fired when the user changes information about the currently playing track (e.g. the name of the track).
	 * <p>
	 * This event is also fired when iTunes plays the next joined CD track in a CD playlist, since joined CD tracks are treated as a single track.
	 *
	 * @param track An IITTrack object corresponding to the track that is now playing.
	 */
	void onPlayerPlayingTrackChanged(IITTrack track);

	/**
	 * The ITEventPlayerStop event is fired when a track stops playing.
	 * <p>
	 * When iTunes switches to playing another track, you will received an ITEventPlayerStop event followed by an ITEventPlayerPlay event, unless it is playing joined CD tracks
	 * (see _IiTunesEvents::OnPlayerPlayingTrackChangedEvent).
	 *
	 * @param track An IITTrack object corresponding to the track that has stopped playing.
	 */
	void onPlayerStop(IITTrack track);

	/**
	 * The ITEventQuitting event is fired when iTunes is about to quit.
	 * <p>
	 * If the user attempts to quit iTunes while a client still has outstanding iTunes COM objects instantiated, iTunes will display a warning dialog. The user can still choose to quit
	 * iTunes anyway, in which case this event will be fired. After this event is fired, any existing iTunes COM objects will no longer be valid.
	 * <p>
	 * This event is only used to notify clients that iTunes is quitting, clients cannot prevent this from happening.
	 */
	void onQuit();

}