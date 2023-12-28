package eu.telecomnancy.rpg;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import eu.telecomnancy.rpg.gameCharacters.GameCharacter;
import eu.telecomnancy.rpg.gameCharacters.Healer;
import eu.telecomnancy.rpg.gameCharacters.Warrior;
import eu.telecomnancy.rpg.gameCharacters.Wizard;
import eu.telecomnancy.rpg.visitors.BuffVisitor;
import eu.telecomnancy.rpg.visitors.HealVisitor;

public class GameFacade {
    private Set<Team> fellowships;

    public GameFacade() {
        this.fellowships = new HashSet<>();
    }

    public boolean contains(Team team) {
        return this.fellowships.contains(team);
    }

    public void addFellowship(Team fellowship) {
        this.fellowships.add(fellowship);
    }

    public void removeFellowship(Team fellowship) {
        this.fellowships.remove(fellowship);
    }

    public void attack(Team attacking, Team defending) {
        Random random = new Random();
        for (GameCharacter attacker : attacking.getPlayers()) {
            int targetIndex = random.nextInt(defending.size());
            GameCharacter defender = defending.getPlayers().stream().toList().get(targetIndex);
            attacker.attack(defender);
        }
    }

    public void heal(Team fellowship) {
        HealVisitor healvVisitor = new HealVisitor(50);
        fellowship.accept(healvVisitor);
    }

    public void buff(Team fellowship) {
        BuffVisitor buffVisitor = new BuffVisitor(50);
        fellowship.accept(buffVisitor);
    }

    public static Team teamJJK() {
        Team teamJJK = new Team("Team Jujutsu Kaisen");
        GameCharacter itadori = new Warrior("Itadori Yuji");
        GameCharacter gojo = new Wizard("Satoru Gojo");
        GameCharacter shoko = new Healer("Ieri Shoko");

        List.of(itadori, gojo, shoko).forEach(teamJJK::addPlayer);

        return teamJJK;
    }

    public static Team teamNaruto() {
        Team teamNaruto = new Team("Team Naruto");
        GameCharacter jiraya = new Warrior("Jiraya");
        GameCharacter orochimaru = new Wizard("Orochimaru");
        GameCharacter tsunade = new Healer("Tsunade");

        List.of(jiraya, orochimaru, tsunade).forEach(teamNaruto::addPlayer);

        return teamNaruto;
    }
}
