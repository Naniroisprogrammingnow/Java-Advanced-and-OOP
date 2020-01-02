package RawData;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        List<Car> carList = new ArrayList<>();
        
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            String model = info[0];
            int engineSpeed = Integer.parseInt(info[1]);
            int enginePower = Integer.parseInt(info[2]);
            Engine engine = new Engine(engineSpeed, enginePower);
            int cargoWeight = Integer.parseInt(info[3]);
            Cargo cargo = new Cargo(info[4], cargoWeight);
            Tire tire1 = getTire(info[5], info[6]);
            Tire tire2 = getTire(info[7], info[8]);
            Tire tire3 = getTire(info[9], info[10]);
            Tire tire4 = getTire(info[11], info[12]);
            Car car = new Car(model, engine, cargo, tire1, tire2, tire3, tire4);
            carList.add(car);
        }
        String command = scanner.nextLine();
        if(command.equals("fragile")){
            carList.stream().filter(e->e.getCargo().getType().equals(command))
                    .filter(e->{
                        boolean res = e.getTire1().getPressure()<1||e.getTire2().getPressure()<1
                                ||e.getTire3().getPressure()<1||e.getTire4().getPressure()<1;
                        return res;
                    }).forEach(e-> System.out.println(e.getModel()));
        }else{
            carList.stream().filter(e->e.getCargo().getType().equals(command))
                    .filter(e->e.getEngine().getPower()>250)
                    .forEach(e-> System.out.println(e.getModel()));
        }
    }

    private static Tire getTire(String s, String s1) {
        double pressure = Double.parseDouble(s);
        int age = Integer.parseInt(s1);
        Tire tire = new Tire(pressure, age);
        return tire;
    }


}
