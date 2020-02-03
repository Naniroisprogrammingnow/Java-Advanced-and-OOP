package WildFarm;

public class Mouse extends Mammal {


    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")){
            super.eat(food);
        }else {
            throw new IllegalArgumentException(
                    "Mice are not eating that type of food!");
        }
    }

    /*
    @Override
    public void denyFood() {
        System.out.println("Mice are not eating that type of food!");
    }*/
}
