package data_transfer_object.vehicle;

/**
 *
 * @author Owner
 */
public abstract class Vehicle {

    private VehicleType vehicleType;
    private int vehicleNumber;
    private FuelType fuelType;
    private double consumptionRate;
    private int maxPassengers;
    private int currentRoute;

    protected Vehicle(VehicleType vehicleType, int vehicleNumber, FuelType fuelType, int maxPassengers) {
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.fuelType = fuelType;
        this.maxPassengers = maxPassengers;
        this.consumptionRate = 0;
        this.currentRoute = -1;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setVehicleNumber(int num) {
        this.vehicleNumber = num;
    }
    
    public void setVehicleType(VehicleType type) {
        this.vehicleType = type;
    }

    public void addConsumption(double consumption) {
        this.consumptionRate += consumption;
    }

    public void setConsumptionRate(double consumption) {
        this.consumptionRate = consumption;
    }

    public double getConsumptionRate() {
        return consumptionRate;
    }

    public void setRoute(int route) {
        this.currentRoute = route;
    }

    public int getRoute() {
        return currentRoute;
    }
}
