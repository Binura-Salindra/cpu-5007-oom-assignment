package uk.bolton.oom.observer;

import uk.bolton.oom.enums.ObserverUpdateContentType;
import uk.bolton.oom.exception.ChannelCustomException;
import uk.bolton.oom.model.Post;

import java.util.HashSet;
import java.util.Set;

import static uk.bolton.oom.constant.ApplicationConstant.*;

public class ChannelSubject implements Subject {

    private final Set<Observer> observers;
    private String channelName;
    private String postContent;

    public ChannelSubject(String channelName) {
        this.channelName = channelName;
        observers = new HashSet<>();
    }

    @Override
    public boolean registerObserver(Observer observer) {
        if(observer == null)
            throw new ChannelCustomException(ERROR_MSG_SUBSCRIBE);

        return observers.add(observer);
    }

    @Override
    public boolean unRegisterObserver(Observer observer) {
        if(observer == null)
            throw new ChannelCustomException(ERROR_MSG_UNSUBSCRIBE);

        return observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(new Post(ObserverUpdateContentType.POST, channelName, postContent));
        }
    }

    private void publishNewPost() {
        notifyObservers();
    }

    public void shareNewPost(String postContent) {
        if(postContent == null || postContent.isEmpty())
            throw new ChannelCustomException(ERROR_MSG_POST_SHARE);

        this.postContent = postContent;
        publishNewPost();
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}
