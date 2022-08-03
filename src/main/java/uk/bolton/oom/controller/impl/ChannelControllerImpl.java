package uk.bolton.oom.controller.impl;

import uk.bolton.oom.controller.ChannelController;
import uk.bolton.oom.exception.ChannelCustomException;
import uk.bolton.oom.factory.ChannelListSubjectFactory;
import uk.bolton.oom.observer.ChannelListSubject;
import uk.bolton.oom.observer.ChannelSubject;
import uk.bolton.oom.observer.Observer;

import java.util.logging.Logger;

import static uk.bolton.oom.constant.ApplicationConstant.*;

public class ChannelControllerImpl implements ChannelController {

    private final ChannelListSubject channelListSubject;

    public ChannelControllerImpl() {
        channelListSubject = ChannelListSubjectFactory.getInstance().getChannelListSubject();
    }

    @Override
    public boolean subscribeUserToChannel(ChannelSubject channelSubject, Observer userObserver) {
        try {

            return channelSubject.registerObserver(userObserver);
        } catch (Exception e) {
            throw new ChannelCustomException(ERROR_MSG_SUBSCRIBE);
        }
    }

    @Override
    public boolean unSubscribeUserFromChannel(ChannelSubject channelSubject, Observer userObserver) {
        try {
            return channelSubject.unRegisterObserver(userObserver);
        } catch (Exception e) {
            throw new ChannelCustomException(ERROR_MSG_UNSUBSCRIBE);
        }
    }

    @Override
    public boolean shareNewPost(ChannelSubject channelSubject, String content) {
        try {
            channelSubject.shareNewPost(content);
            return true;
        } catch (Exception e) {
            throw new ChannelCustomException(ERROR_MSG_POST_SHARE);
        }
    }

    @Override
    public boolean signUpChannel(ChannelSubject channelSubject) {
        try {
            channelListSubject.registerNewChannel(channelSubject);
            return true;
        } catch (Exception e) {
            throw new ChannelCustomException(ERROR_MSG_CHANNEL_SIGN_UP);
        }
    }
}
