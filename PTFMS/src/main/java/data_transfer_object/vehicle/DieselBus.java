/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_transfer_object.vehicle;

/**
 *
 * @author Owner
 */
public class DieselBus extends Vehicle {
	public DieselBus(int vehicleNumber) {
		super(VehicleType.Diesel_Bus, vehicleNumber, FuelType.Diesel, 40);
	}
}
