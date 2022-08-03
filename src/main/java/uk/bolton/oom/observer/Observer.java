package uk.bolton.oom.observer;

import uk.bolton.oom.model.ObserverUpdateContent;

public interface Observer {

    void update(ObserverUpdateContent observerUpdateContent);
}
