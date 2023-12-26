package eu.telecomnancy.rpg.strategies;

public class NeutralStrategy implements Strategy{

    @Override
    public Integer damageDealt(Integer initialDamage) {
        return initialDamage;
    }

    @Override
    public Integer damageTaken(Integer initialDamage) {
        return initialDamage;
    }
}
