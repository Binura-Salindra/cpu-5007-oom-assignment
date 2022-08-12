package uk.bolton.oom.controller.impl;

import uk.bolton.oom.controller.ChannelController;
import uk.bolton.oom.factory.ChannelListSubjectSingleton;
import uk.bolton.oom.observer.ChannelListSubject;
import uk.bolton.oom.observer.ChannelSubject;
import uk.bolton.oom.observer.Observer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ChannelControllerImpl implements ChannelController {

    private static final Logger LOGGER = Logger.getLogger(ChannelControllerImpl.class.getName());

    private final ChannelListSubject channelListSubject;

    public ChannelControllerImpl() {
        channelListSubject = ChannelListSubjectSingleton.getInstance().getChannelListSubject();
    }

    @Override
    public boolean subscribeUserToChannel(ChannelSubject channelSubject, Observer userObserver) {
        try {

            return channelSubject.registerObserver(userObserver);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Method :  subscribeUserToChannel", e);
            throw e;
        }
    }

    @Override
    public boolean unSubscribeUserFromChannel(ChannelSubject channelSubject, Observer userObserver) {
        try {
            return channelSubject.unRegisterObserver(userObserver);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Method :  unSubscribeUserFromChannel", e);
            throw e;
        }
    }

    @Override
    public boolean shareNewPost(ChannelSubject channelSubject, String content) {
        try {
            channelSubject.shareNewPost(content);
            return true;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Method :  shareNewPost", e);
            throw e;
        }
    }

    @Override
    public boolean signUpChannel(ChannelSubject channelSubject) {
        try {
            channelListSubject.registerNewChannel(channelSubject);
            return true;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Method :  signUpChannel", e);
            throw e;
        }
    }
}
