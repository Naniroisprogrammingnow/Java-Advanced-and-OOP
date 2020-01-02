package cats;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        Map<String, Cat> cats = new HashMap<>();
        String line;
        while (!"End".equals(line = scanner.nextLine())){
            String[] tokens = line.split("\\s+");
            String name = tokens[1];
            String breed = tokens[0];
            double chatacteristic = Double.parseDouble(tokens[2]);
            Cat cat = new Cat(breed, name);
            cat.setCharachteristic(chatacteristic);
            cats.put(name, cat);
        }
        String myCat = scanner.nextLine();
        if(cats.containsKey(myCat)){
            System.out.println(cats.get(myCat));
        }
    }
}
