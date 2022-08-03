package uk.bolton.oom.observer;

public interface Subject {

    boolean registerObserver(Observer observer);

    boolean unRegisterObserver(Observer observer);

    void notifyObservers();
}
