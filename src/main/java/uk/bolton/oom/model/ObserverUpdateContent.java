package uk.bolton.oom.model;

import uk.bolton.oom.enums.ObserverUpdateContentType;

public class ObserverUpdateContent {

    private ObserverUpdateContentType observerUpdateContentType;
    private String name;

    public ObserverUpdateContent() {
    }

    public ObserverUpdateContent(ObserverUpdateContentType observerUpdateContentType, String name) {
        this.observerUpdateContentType = observerUpdateContentType;
        this.name = name;
    }

    public ObserverUpdateContentType getObserverUpdateContentType() {
        return observerUpdateContentType;
    }

    public void setObserverUpdateContentType(ObserverUpdateContentType observerUpdateContentType) {
        this.observerUpdateContentType = observerUpdateContentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
