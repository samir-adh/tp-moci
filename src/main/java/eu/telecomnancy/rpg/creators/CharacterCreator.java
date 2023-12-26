package eu.telecomnancy.rpg.creators;

import eu.telecomnancy.rpg.gameCharacters.GameCharacter;

interface CharacterCreator {
    public abstract GameCharacter createCharacter(String name);
}
