package FoodShortage;

import java.util.Map;

public class Calcilator {
    public static int calculateFood(Map<String, Buyer> mapBuyers){
        int totalFood = 0;
        for (Map.Entry<String, Buyer> entry: mapBuyers.entrySet()){
            totalFood+=entry.getValue().getFood();
        }
        return totalFood;
    }
}
