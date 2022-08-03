package uk.bolton.oom.controller;

import uk.bolton.oom.observer.ChannelSubject;
import uk.bolton.oom.observer.Observer;

public interface ChannelController extends SuperController {

    boolean subscribeUserToChannel(ChannelSubject channelSubject, Observer userObserver);

    boolean unSubscribeUserFromChannel(ChannelSubject channelSubject, Observer userObserver);

    boolean shareNewPost(ChannelSubject channelSubject, String content);

    boolean signUpChannel(ChannelSubject channelSubject);

}
