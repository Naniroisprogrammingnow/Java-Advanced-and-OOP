package FoodShortage;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Buyer> people = new HashMap<>();
        collectBuyerInfo(scanner, n, people);
        String whoBuys = scanner.nextLine();
        marketPlace(scanner, people, whoBuys);
        int totalFood = Calcilator.calculateFood(people);
        System.out.println( totalFood);
    }


    private static void marketPlace(Scanner scanner, Map<String, Buyer> people, String whoBuys) {
        while (!whoBuys.equals("End")){
            if (people.containsKey(whoBuys)){
                people.get(whoBuys).buyFood();
            }
            whoBuys = scanner.nextLine();
        }
    }

    private static void collectBuyerInfo(Scanner scanner, int n, Map<String, Buyer> people) {
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            if (tokens.length==4){
                Buyer citizen = new Citizen(tokens[0],
                        Integer.parseInt(tokens[1]),
                        tokens[2],
                        tokens[3]);
                people.put(tokens[0],citizen);
            }else{
                Buyer rebel = new Rebel(tokens[0],
                        Integer.parseInt(tokens[1]),
                        tokens[2]);
                people.put(tokens[0], rebel);
            }
        }
    }
}
