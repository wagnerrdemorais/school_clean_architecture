package com.wagnerrmorais.school.shared.domain.event;

public abstract class EventListener {
    
    public void process(Event event) {
        if(this.shouldProcess(event)) {
            this.reactTo(event);
        }
    }

    protected abstract void reactTo(Event event);

    protected abstract boolean shouldProcess(Event event);
}
