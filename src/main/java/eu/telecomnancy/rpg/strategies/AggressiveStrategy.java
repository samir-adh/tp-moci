package eu.telecomnancy.rpg.strategies;

public class AggressiveStrategy implements Strategy {
    Double factor = 1.2;

    @Override
    public Integer damageDealt(Integer initialDamage) {
        return (int) (initialDamage * factor);
    }

    @Override
    public Integer damageTaken(Integer initialDamage) {
        return (int) (initialDamage * factor);
    }
}