/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_transfer_object.vehicle;

/**
 *
 * @author Owner
 */
public class DieselElectricTrain extends Vehicle {
	private FuelType fuelType2;
	private double consumptionRate2;
	
	public DieselElectricTrain(int vehicleNumber) {
		super(VehicleType.Diesel_Electric_Train, vehicleNumber, FuelType.Electric, 400);
		this.fuelType2 = FuelType.Diesel;
		this.consumptionRate2 = 0;	
	}
	
	public void setSecondConsumptionRate(double consumption) {
		this.consumptionRate2 = consumption;
	}
	
	public double getSecondConsumptionRate() {
		return consumptionRate2;
	}
	
	public FuelType getSecondFuelType() {
		return fuelType2;
	}
}

