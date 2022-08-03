package uk.bolton.oom.model;

import uk.bolton.oom.enums.ObserverUpdateContentType;
import uk.bolton.oom.observer.ChannelSubject;

public class NewChannel extends ObserverUpdateContent {

    private ChannelSubject channelSubject;

    public NewChannel(ObserverUpdateContentType observerUpdateContentType, ChannelSubject channelSubject) {
        super(observerUpdateContentType, channelSubject.getChannelName());
        this.channelSubject = channelSubject;
    }

    public ChannelSubject getChannelSubject() {
        return channelSubject;
    }

    public void setChannelSubject(ChannelSubject channelSubject) {
        this.channelSubject = channelSubject;
    }
}
