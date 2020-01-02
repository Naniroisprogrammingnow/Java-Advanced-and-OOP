package cats;

public class Cat {
    private String breed;
    private String name;
    private double charachteristic;

    public void setCharachteristic(double charachteristic) {
        this.charachteristic = charachteristic;
    }

    public String getName() {
        return name;
    }

    public Cat(String breed, String name) {
        this.breed = breed;
        this.name = name;
    }
    @Override
    public String toString(){
        return String.format("%s %s %.2f", this.breed, this.name, this.charachteristic);
    }
}
