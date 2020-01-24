package PizzaCalories;

import java.util.ArrayList;
import java.util.List;

import static PizzaCalories.Validator.*;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza (String name, int numberOfToppings){
        this.setName(name);
        this.setToppings(numberOfToppings);
        this.toppings = new ArrayList<>(numberOfToppings);
    }
    private void setName(String name){
        validatePizzaName(name);
        this.name = name;
    }
    private void setToppings(int numberOfToppings){
        validateNumberOfToppings(numberOfToppings);
        this.numberOfToppings = numberOfToppings;

    }
    public void setDough(Dough dough){
        this.dough=dough;
    }
    public String getName(){
        return this.name;
    }
    public void addTopping(Topping topping){
        validateNumberOfToppings(toppings.size()+1);
        toppings.add(topping);
    }
    public double getOverallCalories(){
        return dough.calculateCalories() +
                toppings.stream().
                mapToDouble(Topping::calculateCalories)
                        .sum();
    }
}
