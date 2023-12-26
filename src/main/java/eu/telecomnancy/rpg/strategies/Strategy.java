package eu.telecomnancy.rpg.strategies;

public interface Strategy {
    // Cette méthode renvoie la quantité de dégats infligés par le personnage
    Integer damageDealt(Integer initialDamage);
    // Cette méthode renvoie la quantité de dégats subie par le personnage
    Integer damageTaken(Integer initialDamage);
}
