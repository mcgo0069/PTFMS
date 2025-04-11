package data_transfer_object;

import java.sql.Date;

/**
 * Energy_Usage class is a DTO that represents energy consumption data for a
 * specific vehicle over a period.
 *
 * @author Jenni
 */
public class Energy_Usage {

    /**
     * Unique identifier for the energy usage record.
     */
    private int usage_id;
    /**
     * ID of the vehicle associated with this energy usage record.
     */
    private int vehicle_id;
    /**
     * Date when the energy usage data was recorded.
     */
    private Date date;
    /**
     * Number of kilometers traveled by the vehicle.
     */
    private int kms_traveled;
    /**
     * Amount of fuel consumed (in liters).
     */
    private int fuel_consumed;
    /**
     * Total energy used.
     */
    private int energy_used;

    /**
     * Calculated value (gas or energy per kilometer).
     */
    private int efficiency;

    /**
     * Constructor for an Energy_Usage object with all fields initialized.
     *
     * @param usage_id unique identifier for this usage record
     * @param vehicle_id the ID of the vehicle associated with this record
     * @param date the date of the record
     * @param kms_traveled kilometers traveled during the period
     * @param fuel_consumed fuel consumed during the period
     * @param energy_used energy used during the period
     * @param efficiency calculated efficiency
     */
    public Energy_Usage(int usage_id, int vehicle_id, Date date, int kms_traveled, int fuel_consumed, int energy_used, int efficiency) {
        this.usage_id = usage_id;
        this.vehicle_id = vehicle_id;
        this.date = date;
        this.kms_traveled = kms_traveled;
        this.fuel_consumed = fuel_consumed;
        this.energy_used = energy_used;
        this.efficiency = efficiency;
    }

    /**
     * Default constructor for Energy_Usage. Initializes an empty object with
     * default values.
     */
    public Energy_Usage() {

    }

    /**
     * Gets the usage ID of a report.
     *
     * @return usage ID
     */

    public int getUsageID() {
        return usage_id;
    }

    /**
     * Sets the usage ID.
     *
     * @param usage_id the ID of the Usage report
     */
    public void setUsageID(int usage_id) {
        this.usage_id = usage_id;
    }

    /**
     * Gets the vehicle ID on the record.
     *
     * @return vehicle ID The vehicle associated with the usage_id.
     */
    public int getVehicleID() {
        return vehicle_id;
    }

    /**
     * Sets the vehicle ID on the record.
     *
     * @param vehicle_id the vehicle ID associated with the usage_id.
     */
    public void setVehicleID(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    /**
     * Gets the date of the energy usage record.
     *
     * @return the date of the record
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the energy usage record.
     *
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the kilometers traveled.
     *
     * @return kilometers traveled
     */
    public int getKmsTraveled() {
        return kms_traveled;
    }

    /**
     * Sets the kilometers traveled in a record.
     *
     * @param kms_traveled the kilometers traveled associated with usage_id.
     */
    public void setKmsTraveled(int kms_traveled) {
        this.kms_traveled = kms_traveled;
    }

    /**
     * Gets the amount of fuel consumed.
     *
     * @return fuel consumed
     */
    public int getFuelConsumed() {
        return fuel_consumed;
    }

    /**
     * Sets the amount of fuel consumed.
     *
     * @param fuel_consumed the fuel amount consumed on the record.
     */
    public void setFuelConsumed(int fuel_consumed) {
        this.fuel_consumed = fuel_consumed;
    }

    /**
     * Gets the total energy used.
     *
     * @return energy used
     */
    public int getEnergyUsed() {
        return energy_used;
    }

    /**
     * Sets the total energy used.
     *
     * @param energy_used the energy used on the record.
     */
    public void setEnergyUsed(int energy_used) {
        this.energy_used = energy_used;
    }

    /**
     * Gets the efficiency value.
     *
     * @return efficiency
     */
    public int getEfficiency() {
        return efficiency;
    }

    /**
     * Sets the efficiency value.
     *
     * @param efficiency the efficiency value associated with the record.
     */
    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }

}
