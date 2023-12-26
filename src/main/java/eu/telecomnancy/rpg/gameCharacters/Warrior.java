package eu.telecomnancy.rpg.gameCharacters;

import java.util.Random;

import eu.telecomnancy.rpg.visitors.CharacterVisitor;
import eu.telecomnancy.rpg.visitors.DamageVisitor;
import eu.telecomnancy.rpg.weapons.Blade;
import eu.telecomnancy.rpg.weapons.Weapon;
import lombok.Getter;
import lombok.Setter;

public class Warrior extends GameCharacter {
    @Getter
    @Setter
    private int strength;

    public Warrior(String name) {
        super(name);
        strength = getLevel() * 10 + new Random().nextInt(10);
    }

    @Override
    public void accept(CharacterVisitor visitor) {
        visitor.visit(this);
    }

    public void buff(Integer buffQuantity) {
        this.strength += buffQuantity;
    }

    @Override
    public void attack(GameCharacter opponent) {
        int attackPower = 5;
        Weapon weapon = this.getWeapon();
        if (weapon != null) {
            if (weapon instanceof Blade) {
                Blade blade = (Blade) weapon;
                attackPower = strength + blade.getSharpness();
            } else {
                attackPower = weapon.getDamage();
            }
        }
        attackPower = this.getContext().damageDealt(attackPower);
        DamageVisitor damageVisitor = new DamageVisitor(attackPower);
        opponent.accept(damageVisitor);
    }
}
