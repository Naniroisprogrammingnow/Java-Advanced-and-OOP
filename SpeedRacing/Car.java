package SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelPerKm;
    private int distanceTravelled = 0;

    public Car(String model){
        this.model = model;
    }

    public Car(String model, double fuelAmount, double fuelPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelPerKm = fuelPerKm;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelPerKm() {
        return fuelPerKm;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public boolean isTravelPossible(int intendedKm){
        if(intendedKm*this.fuelPerKm<=this.fuelAmount){
            return true;
        }
        return false;
    }
}
