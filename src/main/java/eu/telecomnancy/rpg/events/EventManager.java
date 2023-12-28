package eu.telecomnancy.rpg.events;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import eu.telecomnancy.rpg.gameCharacters.GameCharacter;
import eu.telecomnancy.rpg.observers.StatusObserver;

public class EventManager {
    private Map<EventType,Set<StatusObserver>> observers;  
    public EventManager(){
        this.observers = new HashMap<>();
    }  

    public void subscribe(EventType event,StatusObserver observer){
        if (!this.observers.containsKey(event)) {
            this.observers.put(event, new HashSet<>());
        }
        this.observers.get(event).add(observer);
    }

    public void unsubscribe(EventType event, StatusObserver observer){
        if (!this.observers.containsKey(event)) {
            return;
        }
        Set<StatusObserver> eventObservers = this.observers.get(event);
        eventObservers.remove(observer);
        if (eventObservers.isEmpty()) {
            this.observers.remove(event);
        }
    }

    public void notifyObservers(EventType event,GameCharacter caller){
        Set<StatusObserver> eventObservers = this.observers.get(event);
        if (eventObservers==null) return;
        for (StatusObserver statusObserver : eventObservers) {
            statusObserver.update(event,caller);
        }
    }
}
