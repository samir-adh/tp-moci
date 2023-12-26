package eu.telecomnancy.rpg.creators;

import eu.telecomnancy.rpg.gameCharacters.GameCharacter;
import eu.telecomnancy.rpg.gameCharacters.Warrior;

public class WarriorCreator implements CharacterCreator {
    @Override
    public GameCharacter createCharacter(String name) {
        return new Warrior(name);
    }
}

