package RawData;

public class Cargo {
    String type;
    int weight;

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public Cargo(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }
}
