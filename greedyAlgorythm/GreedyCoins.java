import java.util.*;
public class GreedyCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] coinsAvailable = scanner.nextLine().split(": ");
        int[] coins = Arrays.stream(coinsAvailable[1].split(", "))
                .mapToInt(e-> Integer.parseInt(e)).toArray();
        String sumLine = scanner.nextLine();
        int sum = Integer.parseInt(sumLine.substring(sumLine.indexOf(" ")+1));
        Map<Integer, Integer> result = new LinkedHashMap<>();
        result = getChange(coins, sum);
        printRes(result);
    }

    private static void printRes(Map<Integer, Integer> result) {
        if (result==null){
            System.out.println("Error");
            return;
        }
        System.out.println("Number of coins to take: " + totalCoins(result));
        for (Map.Entry<Integer, Integer> e: result.entrySet()){
            System.out.printf("%d coin(s) with value %d%n", e.getValue(), e.getKey());
        }
    }

    private static int totalCoins(Map<Integer, Integer> result) {
        int total = 0;
        for (Map.Entry<Integer, Integer> e: result.entrySet()){
            total+= e.getValue();
        }
        return total;
    }

    private static Map<Integer, Integer> getChange(int[] coins, int sum) {
        Map<Integer, Integer> result = new LinkedHashMap<>();
        Arrays.sort(coins);
        int index = coins.length-1;
        while (sum>0 && index>=0){
            int currCoinsNum = sum/coins[index];
            if (currCoinsNum==0){
                index--;
                continue;
            }
            result.put(coins[index], currCoinsNum);
            sum-=currCoinsNum*coins[index];
            index--;

        }
        if (sum>0){
            return null;
        }
        return result;
    }
}
