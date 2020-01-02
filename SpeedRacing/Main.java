package SpeedRacing;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Car> carMap = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            String model = info[0];
            double fuel = Double.parseDouble(info[1]);
            double fuelPerKm = Double.parseDouble(info[2]);
            Car car = new Car(model, fuel, fuelPerKm);
            carMap.put(model, car);
        }
        String command;
        while (!"End".equals(command=scanner.nextLine())){
            String[] tokens = command.split("\\s+");
            String model = tokens[1];
            int distance = Integer.parseInt(tokens[2]);
            if(carMap.containsKey(model)){
                Car current = carMap.get(model);
                if(current.isTravelPossible(distance)){
                    current.setDistanceTravelled(current.getDistanceTravelled()+distance);
                    current.setFuelAmount(current.getFuelAmount()-(distance*current.getFuelPerKm()));
                }else{
                    System.out.println("Insufficient fuel for the drive");
                }
            }
        }
        carMap.entrySet().stream().forEach(e-> System.out.println(String.format("%s %.2f %d",
                e.getValue().getModel(), e.getValue().getFuelAmount(), e.getValue().getDistanceTravelled())));
    }
}
