/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_transfer_object;

import java.sql.Date;

/**
 *
 * @author Owner
 */
public class ScheduleMaintenance {
private int scheduleID;
    private int vehicleID;
    private Date maintenanceTime;
    private String description;

    public ScheduleMaintenance() {
    }

    public ScheduleMaintenance(int scheduleID, int vehicleID, Date maintenanceTime, String description) {
        this.scheduleID = scheduleID;
        this.vehicleID = vehicleID;
        this.maintenanceTime = maintenanceTime;
        this.description = description;
    }
    
    public ScheduleMaintenance(int vehicleID, Date maintenanceTime, String description) {
        this.scheduleID = -1;
        this.vehicleID = vehicleID;
        this.maintenanceTime = maintenanceTime;
        this.description = description;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public Date getMaintenanceTime() {
        return maintenanceTime;
    }

    public void setMaintenanceTime(Date maintenanceTime) {
        this.maintenanceTime = maintenanceTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
