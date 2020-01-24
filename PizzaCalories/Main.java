package PizzaCalories;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Pizza pizza;
        try {
            String [] pizzaInfo = scanner.nextLine().split(" ");
            pizza = new Pizza(pizzaInfo[1], Integer.parseInt(pizzaInfo[2]));
            try {
                String[] doughInfo = scanner.nextLine().split(" ");
                Dough dough = new Dough(doughInfo[1], doughInfo[2] ,Double.parseDouble(doughInfo[3]));
                pizza.setDough(dough);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
        String input = scanner.nextLine();
        while (!input.equals("END")){
            String[] tokens = input.split(" ");
            try {
                Topping topping = new Topping(tokens[1], Double.parseDouble(tokens[2]));
                try {
                    pizza.addTopping(topping);
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.format("%s - %.2f", pizza.getName(), pizza.getOverallCalories()));
    }
}
