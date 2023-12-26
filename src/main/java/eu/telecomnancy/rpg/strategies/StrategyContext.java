package eu.telecomnancy.rpg.strategies;

public class StrategyContext {
    // On définit la stratégie neutre comme stratégie par défaut
private Strategy strategy = new NeutralStrategy();

public void setStrategy(Strategy strategy){
   this.strategy = strategy;
}

public Integer damageDealt(Integer initialDamage){
    return this.strategy.damageDealt(initialDamage);
}

public Integer damageTaken(Integer initialDamage){
    return this.strategy.damageTaken(initialDamage);
}

}
