package FootballTeam;

import java.util.List;

public class Validator {
    public static void checkName(String name){
        if (name==null || name.isEmpty() || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }

    public static void checkStat(int stat, String typeStat){
        if (stat<0 || stat>100){
            throw new IllegalArgumentException(
                    typeStat + " should be between 0 and 100.");
        }
    }
    public static int checkPlayer(String name, List<Player> players){
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    public static int checkTeam(String name, List<Team> teams){
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
}
