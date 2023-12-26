package eu.telecomnancy.rpg.creators;

import eu.telecomnancy.rpg.gameCharacters.GameCharacter;
import eu.telecomnancy.rpg.gameCharacters.Healer;

public class HealerCreator implements CharacterCreator {
    @Override
    public GameCharacter createCharacter(String name) {
        return new Healer(name);
    }
}
