package uk.bolton.oom.factory;

import uk.bolton.oom.observer.ChannelListSubject;

public class ChannelListSubjectFactory {

    private final ChannelListSubject channelListSubject;
    private static ChannelListSubjectFactory channelListSubjectFactory;

    private ChannelListSubjectFactory() {
        this.channelListSubject = new ChannelListSubject();
    }

    public ChannelListSubject getChannelListSubject() {
        return channelListSubject;
    }

    public static ChannelListSubjectFactory getInstance() {
        if (channelListSubjectFactory == null) {
            channelListSubjectFactory = new ChannelListSubjectFactory();
        }
        return channelListSubjectFactory;
    }
}
