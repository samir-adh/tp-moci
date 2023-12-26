package eu.telecomnancy.rpg.gameCharacters;

import java.util.HashSet;
import java.util.Set;

import eu.telecomnancy.rpg.armors.Armor;
import eu.telecomnancy.rpg.strategies.StrategyContext;
import eu.telecomnancy.rpg.visitors.CharacterVisitor;
import eu.telecomnancy.rpg.weapons.Weapon;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public abstract class GameCharacter {
    private final String name;
    private int health;
    private int experiencePoints;
    private int level;
    private StrategyContext context;
    private Set<Armor> equipment;
    private Weapon weapon;

    public GameCharacter(String name) {
        this.name = name;
        this.health = 100;
        this.experiencePoints = 0;
        this.level = 1;
        this.context = new StrategyContext();
        this.equipment = new HashSet<>();
    }

    public abstract void accept(CharacterVisitor visitor);

    public void addArmor(Armor armor){
        this.equipment.add(armor);
        this.health+=armor.getDefence();
    }

    public Set<Armor> getEquipment(){
        return this.equipment;
    }

    public void takeDamage(int hpDamage) {
        hpDamage = context.damageTaken(hpDamage);
        health = Integer.max(0,health-hpDamage);
    }

    public void heal(int hpHeal) {
        health += hpHeal;
    }


    public abstract void attack(GameCharacter opponent);
}
