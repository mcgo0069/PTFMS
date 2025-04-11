/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_transfer_object.vehicle;

/**
 *
 * @author Owner
 */
public class VehicleFactory {

    private static int vehicleNumber = -1;

    public VehicleFactory() {
    }

    public static void setVehicleNumber(int number) {
        vehicleNumber = number;
    }

    public static Vehicle buildVehicle(VehicleType type) {
        return switch (type) {
            case Diesel_Bus -> new DieselBus(vehicleNumber);
            case Electric_Light_Rail -> new ElectricLightRail(vehicleNumber);
            case Diesel_Electric_Train -> new DieselElectricTrain(vehicleNumber);
            default -> null;
        };
    }
}
