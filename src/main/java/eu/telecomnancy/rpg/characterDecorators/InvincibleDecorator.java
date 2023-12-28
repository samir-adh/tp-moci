package eu.telecomnancy.rpg.characterDecorators;

import eu.telecomnancy.rpg.gameCharacters.GameCharacter;
import eu.telecomnancy.rpg.visitors.CharacterVisitor;

public class InvincibleDecorator extends CharacterDecorator{
    public InvincibleDecorator(GameCharacter character){
        super(character, character.getName() + "(🦸)");
    }

    @Override
    public void attack(GameCharacter opponent) {
        character.attack(opponent);
    }

    @Override
    public void accept(CharacterVisitor visitor) {
        character.accept(visitor);
    }

    @Override
    public void takeDamage(int hpDamage) {
        character.takeDamage(0);
    }
}
