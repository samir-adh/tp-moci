package eu.telecomnancy.rpg.observers;

import java.util.HashSet;
import java.util.Set;

import eu.telecomnancy.rpg.events.EventType;
import eu.telecomnancy.rpg.gameCharacters.GameCharacter;

/**
 * DeathObserver
 */
public class DeathObserver implements StatusObserver {
    private Set<GameCharacter> deadCharacters;

    public DeathObserver() {
        this.deadCharacters = new HashSet<>();
    }

    @Override
    public void update(EventType event, GameCharacter caller) {
        if (event.equals(EventType.DEATH))
            this.deadCharacters.add(caller);
    }

    public boolean isDead(GameCharacter character){
        return deadCharacters.contains(character);
    }
}