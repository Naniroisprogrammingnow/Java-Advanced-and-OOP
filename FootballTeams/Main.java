package FootballTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static FootballTeam.Validator.checkTeam;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        List<Team> teams = new ArrayList<>();
        while (!input.equals("END")){
            String[] tokens = input.split(";");
            String command = tokens[0];
            switch (tokens[0]){
                case "Team":
                    createTeam(teams, tokens[1]);
                    break;
                case "Add":
                    addPlayerToTeam(teams, tokens);
                    break;
                case "Remove":
                    removePlayerFromTeam(teams, tokens);
                    break;
                case "Rating":
                    getTeamRatings(teams, tokens[1]);
                    break;
            }
            input = bufferedReader.readLine();
        }
    }

    private static void getTeamRatings(List<Team> teams, String token) {
        int index = checkTeam(token,teams);
        if (index!=-1){
            System.out.println(token + " - " + Math.round(teams.get(index).getRating()));
        }else {
            System.out.println(String.format("Team %s does not exist.", token));

        }
        return;
    }

    private static void removePlayerFromTeam(List<Team> teams, String[] tokens) {
        int index = checkTeam(tokens[1], teams);
        if (index!=-1){
            try {
                teams.get(index).removePlayer(tokens[2]);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }else {
            System.out.println(String.format("Team %s does not exist.", tokens[1]));

        }
        return;
    }

    private static void addPlayerToTeam(List<Team> teams, String[] tokens) {
        int index = checkTeam(tokens[1], teams);
        if (index!=-1){
            try{
                Player player = new Player(tokens[2],
                        Integer.parseInt(tokens[3]),
                        Integer.parseInt(tokens[4]),
                        Integer.parseInt(tokens[5]),
                        Integer.parseInt(tokens[6]),
                        Integer.parseInt(tokens[7]));
                teams.get(index).addPlayer(player);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println(String.format("Team %s does not exist.", tokens[1]));
        }
    }

    private static void createTeam(List<Team> teams, String token) {
        try {
            Team team = new Team(token);
            teams.add(team);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
