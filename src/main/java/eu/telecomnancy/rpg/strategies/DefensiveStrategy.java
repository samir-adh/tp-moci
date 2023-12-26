package eu.telecomnancy.rpg.strategies;

public class DefensiveStrategy implements Strategy{
    Double factor = 0.8;

    @Override
    public Integer damageDealt(Integer initialDamage) {
        return (int) (initialDamage * factor);
    }

    @Override
    public Integer damageTaken(Integer initialDamage) {
        return (int) (initialDamage * factor);
    }
}
