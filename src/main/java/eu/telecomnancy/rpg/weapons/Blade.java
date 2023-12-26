package eu.telecomnancy.rpg.weapons;

public class Blade extends Weapon {
    private int sharpness;
    public Blade(String name, int damage, int sharpness){
        super(name, damage);
        this.sharpness = sharpness;
    }

    public int getSharpness() {
        return sharpness;
    }
}
