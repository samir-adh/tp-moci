package eu.telecomnancy.rpg;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import eu.telecomnancy.rpg.gameCharacters.GameCharacter;
import eu.telecomnancy.rpg.visitors.CharacterVisitor;
import lombok.Getter;

public class Team {
    @Getter
    private final String name;

    @Getter
    private Map<String, GameCharacter> players;

    public Team(String name) {
        this.name = name;
        players = new HashMap<>();
    }

    public void addPlayer(GameCharacter player) {
        players.put(player.getName(), player);
    }

    public void removePlayer(GameCharacter player) {
        players.remove(player.getName());
    }

    public void removePlayer(String name) {
        players.remove(name);
    }

    public GameCharacter getPlayer(String name) {
        return players.get(name);
    }

    public boolean containsPlayer(String name) {
        return players.containsKey(name);
    }

    public boolean containsPlayer(GameCharacter player) {
        return players.containsValue(player);
    }

    public int size() {
        return players.size();
    }

    public void accept(CharacterVisitor visitor) {
        visitor.visit(this);
    }

    public Collection<GameCharacter> getPlayers() {
        return this.players.values();
    }

    public int getHealth() {
        return this.getPlayers().stream().map(c -> c.getHealth()).reduce(0, (a, b) -> a + b);
    }
}
