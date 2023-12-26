package eu.telecomnancy.rpg.gameCharacters;

import eu.telecomnancy.rpg.visitors.CharacterVisitor;
import eu.telecomnancy.rpg.visitors.DamageVisitor;
import eu.telecomnancy.rpg.visitors.HealVisitor;
import eu.telecomnancy.rpg.weapons.MagicWeapon;
import eu.telecomnancy.rpg.weapons.Weapon;
import lombok.Getter;

import java.util.Random;

public class Healer extends GameCharacter {
    @Getter
    private int wisdom;

    public Healer(String name) {
        super(name);
        wisdom = getLevel() * 10 + new Random().nextInt(10);
    }

    @Override
    public void accept(CharacterVisitor visitor) {
        visitor.visit(this);
    }

    public void buff(Integer buffQuantity) {
        this.wisdom += buffQuantity;
    }

    public void healPlayer(GameCharacter player) {
        int healQuantity = wisdom;
        Weapon weapon = this.getWeapon();
        if (weapon != null && weapon instanceof MagicWeapon) {
            healQuantity += ((MagicWeapon) weapon).getMagic();
        }
        HealVisitor healVisitor = new HealVisitor(healQuantity);
        player.accept(healVisitor);
    }

    @Override
    public void attack(GameCharacter opponent) {
        int attackPower = 5;
        attackPower = this.getContext().damageDealt(attackPower);
        DamageVisitor damageVisitor = new DamageVisitor(attackPower);
        opponent.accept(damageVisitor);
    }
}
