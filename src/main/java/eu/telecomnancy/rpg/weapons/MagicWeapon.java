package eu.telecomnancy.rpg.weapons;

public class MagicWeapon extends Weapon {
    private int magic;
    public MagicWeapon(String name, int damage,int magic){
        super(name,damage);
        this.magic = magic;
    }
    
    public int getMagic() {
        return magic;
    }
}
