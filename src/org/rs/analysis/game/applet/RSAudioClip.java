package org.rs.analysis.game.applet;

import java.applet.AudioClip;
import java.net.URL;

/**
 * Created by Francis on 21/03/16.
 */
public class RSAudioClip implements AudioClip {

    private static final short STATE_STOPPED = 0;
    private static final short STATE_PLAYING = 1;
    private static final short STATE_LOOPING = 2;

    private final URL sourceURL;
    private short audioClipState;

    public RSAudioClip(final URL sourceURL) {
        this.sourceURL = sourceURL;
        audioClipState = 0;
    }

    private short getAudioClipState() {
        return audioClipState;
    }

    private URL getURL() {
        return sourceURL;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RSAudioClip)) {
            return false;
        }
        final RSAudioClip ac = (RSAudioClip) obj;
        return ac.getAudioClipState() == audioClipState && ac.getURL().equals(sourceURL);
    }

    public void play() {
        audioClipState = STATE_PLAYING;
    }

    public void loop() {
        audioClipState = STATE_LOOPING;
    }

    public void stop() {
        audioClipState = STATE_STOPPED;
    }
}
