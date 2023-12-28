package eu.telecomnancy.rpg.characterDecorators;

import eu.telecomnancy.rpg.gameCharacters.GameCharacter;
import eu.telecomnancy.rpg.visitors.CharacterVisitor;

public class ArmoredDecorator extends CharacterDecorator {
    public ArmoredDecorator(GameCharacter character) {
        super(character, character.getName() + "(🛡️)");
    }

    @Override
    public void accept(CharacterVisitor visitor) {
        character.accept(visitor);
    }

    @Override
    public void attack(GameCharacter opponent) {
        character.attack(opponent);
    }

    @Override
    public void takeDamage(int hpDamage){
        double factor = 0.8; 
        int reducedDamage = (int)((double)hpDamage * factor);
        character.takeDamage(reducedDamage);
    }
}
