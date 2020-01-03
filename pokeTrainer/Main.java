package pokeTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String info = bufferedReader.readLine();
        //събирам информация за треньорите и индивидуалните им покеАрмии;
        while (!info.equals("Tournament")){
            String [] tokens = info.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokeElement = tokens[2];
            int pokeHealth = Integer.parseInt(tokens[3]);
            Pokemon currPokemon = new Pokemon(pokemonName, pokeElement, pokeHealth);
            Trainer currTrainer = new Trainer(trainerName);
            trainers.putIfAbsent(trainerName, currTrainer);
            trainers.get(trainerName).getPokemonList().add(currPokemon);

            info = bufferedReader.readLine();
        }
        String command = bufferedReader.readLine();
        while (!command.equals("End")){
            for (Map.Entry<String, Trainer> currentTrainer : trainers.entrySet()) {
                int currentBadges = currentTrainer.getValue().getBadges();
                boolean loser = true;
                //Всеки треньор има ли поне един покемон от търсените
                List<Pokemon> currPokeList = currentTrainer.getValue().getPokemonList();
                for (Pokemon pokemon : currPokeList) {
                    if(pokemon.getElement().equals(command)){
                        //ако има увеличаваме значките и му казваме че няма да го наказваме
                        currentBadges++;
                        currentTrainer.getValue().setBadges(currentBadges);
                        loser = false;
                        break;
                    }
                }
                // ако ще се наказва
                if(loser){
                    losePokeHealth(currPokeList); // намаляваме на всеки покемон здравето
                    checkForDead(currPokeList); //прояверяваме и махаме мъртвите покемони
                }
            }
            command = bufferedReader.readLine();
        }
        trainers.entrySet().stream().sorted((a,b)->{
           int res = b.getValue().getBadges()-a.getValue().getBadges();
           return res;
        }).forEach(e->{
            System.out.printf("%s %d %d%n", e.getKey(), e.getValue().getBadges(), e.getValue().getPokemonList().size());
        });

    }

    private static void checkForDead(List<Pokemon> currPokeList) {
        int n = 0;
        while (n<currPokeList.size()){              //while защото итерацията копира обекта,
            if(currPokeList.get(n).getHealth()<=0){ //фор ще обърка бройката на кой сме махнали
                currPokeList.remove(n);             //ако махаме няма нужда да местим позицията, заради изместването наляво на др елементи
            }else {
                n++;                                //увеличавам каунтъра само ако местим напред
            }
        }
    }

    private static void losePokeHealth(List<Pokemon> currPokeList) {
        for (Pokemon pokemon : currPokeList) {
            pokemon.setHealth(pokemon.getHealth()-10);
        }
    }
}
