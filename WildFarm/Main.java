package WildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String command = bufferedReader.readLine();
        List<Animal> animals = new ArrayList<>();

        while (!command.equals("End")){
            String[] tokens = command.split("\\s+");
            Animal animal = createAnimal(tokens);
            Food food = createFood(bufferedReader.readLine().split("\\s+"));
            try {
                animal.makeSound();
                animal.eat(food);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            animals.add(animal);
            command = bufferedReader.readLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal);

        }

    }

    private static Food createFood(String[] tokens) {
        Food food = null;
        if (tokens[0].equals("Meat")){
            food = new Meat(Integer.parseInt(tokens[1]));
        }else {
            food = new Vegetable(Integer.parseInt(tokens[1]));
        }
        return food;
    }

    private static Animal createAnimal(String[] tokens) {
        Animal animal = null;
        switch (tokens[0]){
            case "Cat":
                animal = new Cat(tokens[1],
                        tokens[0],
                        Double.parseDouble(tokens[2]),
                        tokens[3],
                        tokens[4]);
                break;
            case "Tiger":
                animal = new Tiger(tokens[1],
                        tokens[0],
                        Double.parseDouble(tokens[2]),
                        tokens[3]);
                break;
            case "Zebra":
                animal = new Zebra(tokens[1],
                        tokens[0],
                        Double.parseDouble(tokens[2]),
                        tokens[3]);
                break;
            case "Mouse":
                animal = new Mouse(tokens[1],
                        tokens[0],
                        Double.parseDouble(tokens[2]),
                        tokens[3]);
                break;
        }
        return animal;
    }
}
