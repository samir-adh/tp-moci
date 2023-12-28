package eu.telecomnancy.rpg.characterDecorators;

import eu.telecomnancy.rpg.gameCharacters.GameCharacter;

public abstract class CharacterDecorator extends GameCharacter {
    GameCharacter character;
    public CharacterDecorator(GameCharacter character, String name){
        super(name);
        this.character = character;
    }
}
