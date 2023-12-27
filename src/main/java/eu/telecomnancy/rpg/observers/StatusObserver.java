package eu.telecomnancy.rpg.observers;

import eu.telecomnancy.rpg.events.EventType;
import eu.telecomnancy.rpg.gameCharacters.GameCharacter;

public interface StatusObserver {
    public void update(EventType event,GameCharacter caller);
}
