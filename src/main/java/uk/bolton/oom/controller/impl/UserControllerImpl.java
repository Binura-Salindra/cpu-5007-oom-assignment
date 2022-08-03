package uk.bolton.oom.controller.impl;

import uk.bolton.oom.controller.UserController;
import uk.bolton.oom.exception.UserCustomException;
import uk.bolton.oom.factory.ChannelListSubjectFactory;
import uk.bolton.oom.observer.ChannelListSubject;
import uk.bolton.oom.observer.ChannelSubject;
import uk.bolton.oom.observer.Observer;

import java.util.Set;

import static uk.bolton.oom.constant.ApplicationConstant.ERROR_MSG_CHANNEL_FETCH;
import static uk.bolton.oom.constant.ApplicationConstant.ERROR_MSG_USER_SIGN_UP;

public class UserControllerImpl implements UserController {

    private final ChannelListSubject channelListSubject;

    public UserControllerImpl() {
        channelListSubject = ChannelListSubjectFactory.getInstance().getChannelListSubject();
    }

    @Override
    public boolean signUpUser(Observer userObserver) {
        try {
            return channelListSubject.registerObserver(userObserver);
        } catch (Exception e) {
            throw new UserCustomException(ERROR_MSG_USER_SIGN_UP);
        }
    }

    @Override
    public Set<ChannelSubject> getAllChannelList() {
        try {
            return channelListSubject.getChannelList();
        } catch (Exception e) {
            throw new UserCustomException(ERROR_MSG_CHANNEL_FETCH);
        }
    }
}
