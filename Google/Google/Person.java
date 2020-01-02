package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    Company company;
    List<Pokemon> pokemonList;
    List<Child> children;
    List<Parent> parents;
    Car car;

    public Person(String name) {
        this.name = name;
        this.pokemonList = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public List<Child> getChildren() {
        return children;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public Car getCar() {
        return car;
    }
}
