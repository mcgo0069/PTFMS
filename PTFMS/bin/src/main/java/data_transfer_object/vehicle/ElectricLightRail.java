/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_transfer_object.vehicle;

/**
 *
 * @author Owner
 */
public class ElectricLightRail extends Vehicle {
	public ElectricLightRail(int vehicleNumber) {
		super(VehicleType.Electric_Light_Rail, vehicleNumber, FuelType.Electric, 400);
	}
}
