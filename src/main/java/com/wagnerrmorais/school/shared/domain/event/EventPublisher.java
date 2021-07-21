package com.wagnerrmorais.school.shared.domain.event;

import java.util.ArrayList;
import java.util.List;

public class EventPublisher {

    private List<EventListener> listeners = new ArrayList<>();

    public void addListener(EventListener eventListener) {
        this.listeners.add(eventListener);
    }

    public void publishEvent(Event event) {
        this.listeners.forEach(eventListener -> {
            eventListener.process(event);
        });
    }

}
