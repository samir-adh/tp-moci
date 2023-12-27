package eu.telecomnancy.rpg.observers;

import java.util.HashMap;
import java.util.Map;

import eu.telecomnancy.rpg.events.EventType;
import eu.telecomnancy.rpg.gameCharacters.GameCharacter;

public class LevelUpObserver implements StatusObserver {
     private Map<GameCharacter,Integer> charactersLevel;

    public LevelUpObserver(){
        this.charactersLevel = new HashMap<>();
    }

    @Override
    public void update(EventType event, GameCharacter caller) {
        this.charactersLevel.put(caller,caller.getLevel());
    }
   
    public int getLevel(GameCharacter character){
        return this.charactersLevel.get(character);
    }
}
