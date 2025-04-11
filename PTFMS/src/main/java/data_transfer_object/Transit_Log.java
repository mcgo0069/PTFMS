
package data_transfer_object;

/**
 * Transit_Log} class is a (DTO) representing a log entry for a vehicle's
 * movement at a station.
 *
 * @author Jennifer Goodchild 040683485
 */
public class Transit_Log {

    /**
     * Unique identifier for the transit log entry.
     */
    private int log_id;
    /**
     * ID of the station associated with this transit log.
     */
    private int station_id;
    /**
     * ID of the vehicle associated with this transit log.
     */
    private int vehicle_id;
    /**
     * Timestamp representing the arrival time of the vehicle.
     */
    private String arrival_time;
    /**
     * Timestamp representing the departure time of the vehicle.
     */
    private String departure_time;

    /**
     * Constructor for a Transit_Log object with all fields initialized.
     *
     * @param log_id unique ID of the transit log
     * @param station_id ID of the station
     * @param vehicle_id ID of the vehicle
     * @param arrival_time arrival time as a string (e.g., "2023-04-06 08:00")
     * @param departure_time departure time as a string
     */
    public Transit_Log(int log_id, int station_id, int vehicle_id, String arrival_time, String departure_time) {
        this.log_id = log_id;
        this.station_id = station_id;
        this.vehicle_id = vehicle_id;
        this.arrival_time = arrival_time;
        this.departure_time = departure_time;
    }
    
    public Transit_Log(int station_id, int vehicle_id, String arrival_time, String departure_time) {
        this.log_id = -1;
        this.station_id = station_id;
        this.vehicle_id = vehicle_id;
        this.arrival_time = arrival_time;
        this.departure_time = departure_time;
    }

    /**
     * Default constructor for a Transit_Log.
     */
    public Transit_Log() {

    }

    /**
     * Gets the log ID.
     *
     * @return the unique ID of this transit log
     */
    public int getLogID() {
        return log_id;
    }

    /**
     * Sets the log ID.
     *
     * @param log_id the unique log ID
     */
    public void setLogID(int log_id) {
        this.log_id = log_id;
    }

    /**
     * Gets the station ID.
     *
     * @return the ID of the station associated with the record.
     */
    public int getStationID() {
        return station_id;
    }

    /**
     * Sets the station ID for the record.
     *
     * @param station_id the station ID
     */
    public void setStationID(int station_id) {
        this.station_id = station_id;
    }

    /**
     * Gets the vehicle ID in the record.
     *
     * @return the ID of the vehicle in the log
     */
    public int getVehicleID() {
        return vehicle_id;
    }

    /**
     * Sets the vehicle ID in the record.
     *
     * @param vehicle_id the vehicle ID
     */
    public void setVehicleID(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    /**
     * Gets the arrival time of the vehicle to the station.
     *
     * @return the arrival time as a string
     */
    public String getArrivalTime() {
        return arrival_time;
    }

    /**
     * Sets the arrival time of the vehicle to the station.
     *
     * @param arrival_time the arrival time
     */
    public void setArrivalTime(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    /**
     * Gets the departure time of the vehicle from the station.
     *
     * @return the departure time as a string
     */
    public String getDepartureTime() {
        return departure_time;
    }

    /**
     * Sets the departure time of the vehicle from the station.
     *
     * @param departure_time the departure time
     */
    public void setDepartureTime(String departure_time) {
        this.departure_time = departure_time;
    }

}
