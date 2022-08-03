package uk.bolton.oom.controller;

import uk.bolton.oom.observer.ChannelSubject;
import uk.bolton.oom.observer.Observer;

import java.util.Set;

public interface UserController extends SuperController {

    boolean signUpUser(Observer userObserver);

    Set<ChannelSubject> getAllChannelList();
}
