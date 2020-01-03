package pokeTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemonList;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemonList = new ArrayList<>();
    }

    public int getBadges() {
        return badges;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }
}
