package uk.bolton.oom.observer;

import uk.bolton.oom.enums.ObserverUpdateContentType;
import uk.bolton.oom.exception.ChannelCustomException;
import uk.bolton.oom.exception.UserCustomException;
import uk.bolton.oom.model.NewChannel;

import java.util.HashSet;
import java.util.Set;

import static uk.bolton.oom.constant.ApplicationConstant.*;

public class ChannelListSubject implements Subject {

    private final Set<Observer> observers;
    private final Set<ChannelSubject> channelList;
    private ChannelSubject latestChannel;

    public ChannelListSubject() {
        observers = new HashSet<>();
        channelList = new HashSet<>();
    }

    @Override
    public boolean registerObserver(Observer observer) {
        if(observer == null)
            throw new UserCustomException(ERROR_MSG_USER_SIGN_UP);

        return observers.add(observer);
    }

    @Override
    public boolean unRegisterObserver(Observer observer) {
        return observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
           observer.update(new NewChannel(ObserverUpdateContentType.NEW_CHANNEL_REGISTRATION, latestChannel));
        }
    }


    public Set<ChannelSubject> getChannelList() {
        return channelList;
    }


    public void registerNewChannel(ChannelSubject channelSubject) {
        if(channelSubject == null)
            throw new ChannelCustomException(ERROR_MSG_CHANNEL_SIGN_UP);

        if(channelSubject.getChannelName() == null || channelSubject.getChannelName().isEmpty())
            throw new ChannelCustomException(ERROR_MSG_CHANNEL_SIGN_UP);

        this.channelList.add(channelSubject);
        this.latestChannel = channelSubject;
        publishChannel();
    }

    private void publishChannel() {
        notifyObservers();
    }
}
