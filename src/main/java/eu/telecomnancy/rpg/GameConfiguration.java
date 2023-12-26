package eu.telecomnancy.rpg;


public class GameConfiguration {
    private static GameConfiguration instance;
    private Difficulty gameDifficulty;
    private Integer maxTeamSize;
    private GameConfiguration(){

    }

    public static GameConfiguration getInstance(Difficulty gameDifficulty, Integer maxTeamSize){
        if(instance==null){
            instance = new GameConfiguration();
            instance.gameDifficulty = gameDifficulty;
            instance.maxTeamSize = maxTeamSize;
        }
        return instance;
    }

    public Difficulty getGameDifficulty() {
        return gameDifficulty;
    }

    public Integer getMaxTeamSize() {
        return maxTeamSize;
    }
}

