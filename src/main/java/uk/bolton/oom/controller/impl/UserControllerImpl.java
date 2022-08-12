package uk.bolton.oom.controller.impl;

import uk.bolton.oom.controller.UserController;
import uk.bolton.oom.factory.ChannelListSubjectSingleton;
import uk.bolton.oom.observer.ChannelListSubject;
import uk.bolton.oom.observer.ChannelSubject;
import uk.bolton.oom.observer.Observer;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserControllerImpl implements UserController {

    private static final Logger LOGGER = Logger.getLogger(UserControllerImpl.class.getName());

    private final ChannelListSubject channelListSubject;

    public UserControllerImpl() {
        channelListSubject = ChannelListSubjectSingleton.getInstance().getChannelListSubject();
    }

    @Override
    public boolean signUpUser(Observer userObserver) {
        try {
            return channelListSubject.registerObserver(userObserver);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Method :  signUpUser", e);
            throw e;
        }
    }

    @Override
    public Set<ChannelSubject> getAllChannelList() {
        try {
            return channelListSubject.getChannelList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Method :  getAllChannelList", e);
            throw e;
        }
    }
}
