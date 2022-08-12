package uk.bolton.oom.factory;

import uk.bolton.oom.observer.ChannelListSubject;

/**
 * This class created for get single object of ChannelListSubject
 */
public class ChannelListSubjectSingleton {

    // private field that refers to the object
    private final ChannelListSubject channelListSubject;

    // private static reference of class
    private static ChannelListSubjectSingleton channelListSubjectSingleton;

    // private constructor
    private ChannelListSubjectSingleton() {
        this.channelListSubject = new ChannelListSubject();
    }

    // public static method
    // write code that allows us to create only one object
    // access the object as per our need
    public static ChannelListSubjectSingleton getInstance() {
        if (channelListSubjectSingleton == null) {
            channelListSubjectSingleton = new ChannelListSubjectSingleton();
        }
        return channelListSubjectSingleton;
    }

    public ChannelListSubject getChannelListSubject() {
        return channelListSubject;
    }
}
