package FootballTeam;

import java.util.ArrayList;
import java.util.List;

import static FootballTeam.Validator.checkName;
import static FootballTeam.Validator.checkPlayer;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        checkName(name);
        this.name = name;
    }
    public void addPlayer(Player player){
        this.players.add(player);
    }
    public void removePlayer (String name){
        int index=checkPlayer(name, this.players);
        if (index!=-1){
            this.players.remove(index);
        }else{
            System.out.println(String.format("Player %s is not in %s team.",
                    name, this.name));

        }
    }
    public double getRating(){
        return players.stream()
                .mapToDouble(Player::overallSkillLevel)
                .sum()/this.players.size();
    }
}
