package eu.telecomnancy.rpg.creators;

import eu.telecomnancy.rpg.gameCharacters.GameCharacter;
import eu.telecomnancy.rpg.gameCharacters.Wizard;

public class WizardCreator implements CharacterCreator{
    @Override
    public GameCharacter createCharacter(String name){
        return new Wizard(name);
    }
}
