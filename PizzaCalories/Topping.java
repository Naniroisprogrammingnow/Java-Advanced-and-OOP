package PizzaCalories;

import static PizzaCalories.Validator.*;

public class Topping {
    private String type;
    private double weight;

    public Topping(String type, double weight) {
        this.setToppingType(type);
        this.setWeight(weight);
    }

    private void setToppingType(String type) {
        validateToppingType(type);
        this.type = type;
    }

    private void setWeight(double weight) {
        validateToppingWeight(this.type, weight);
        this.weight = weight;
    }
    public double calculateCalories(){
        double calories = weight*2;
        if (this.type.equals("Meat")){
            calories*=1.2;
        }else if (this.type.equals("Veggies")){
            calories*=0.8;
        }else if (this.type.equals("Cheese")){
            calories*=1.1;
        }else{
            calories*=0.9;
        }
        return calories;
    }
}
