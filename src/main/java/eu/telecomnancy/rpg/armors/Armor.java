package eu.telecomnancy.rpg.armors;

public class Armor {
    private final String name;
    private int defence;

    public Armor(String name, int defence) {
        this.name = name;
        this.defence = defence;
    }

    public String getName() {
        return name;
    }

    public int getDefence() {
        return defence;
    }
}
