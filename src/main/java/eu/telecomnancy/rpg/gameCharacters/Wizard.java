package eu.telecomnancy.rpg.gameCharacters;

import java.util.Random;

import eu.telecomnancy.rpg.visitors.CharacterVisitor;
import eu.telecomnancy.rpg.visitors.DamageVisitor;
import eu.telecomnancy.rpg.weapons.MagicWeapon;
import eu.telecomnancy.rpg.weapons.Weapon;
import lombok.Getter;
import lombok.Setter;

public class Wizard extends GameCharacter {
    @Getter
    @Setter
    private int intelligence;

    public Wizard(String name) {
        super(name);
        intelligence = getLevel() * 10 + new Random().nextInt(10);
    }

    @Override
    public void accept(CharacterVisitor visitor) {
        visitor.visit(this);
    }

    public void buff(Integer buffQuantity) {
        this.intelligence += buffQuantity;
    }

    @Override
    public void attack(GameCharacter opponent) {
        int attackPower = 5;
        Weapon weapon = this.getWeapon();
        if (weapon != null){
            if (weapon instanceof MagicWeapon) {
                MagicWeapon magicWeapon = (MagicWeapon) weapon;
                attackPower = intelligence + magicWeapon.getMagic();
            } else {
                attackPower = weapon.getDamage();
            }
        }
        attackPower = this.getContext().damageDealt(attackPower);
        DamageVisitor damageVisitor = new DamageVisitor(attackPower);
        opponent.accept(damageVisitor);
    }

}
