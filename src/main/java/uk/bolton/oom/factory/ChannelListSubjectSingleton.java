package uk.bolton.oom.factory;

import uk.bolton.oom.observer.ChannelListSubject;

public class ChannelListSubjectSingleton {

    private final ChannelListSubject channelListSubject;
    
    private static ChannelListSubjectSingleton channelListSubjectSingleton;

    private ChannelListSubjectSingleton() {
        this.channelListSubject = new ChannelListSubject();
    }

    public ChannelListSubject getChannelListSubject() {
        return channelListSubject;
    }

    public static ChannelListSubjectSingleton getInstance() {
        if (channelListSubjectSingleton == null) {
            channelListSubjectSingleton = new ChannelListSubjectSingleton();
        }
        return channelListSubjectSingleton;
    }
}
