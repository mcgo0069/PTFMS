/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_transfer_object;

/**
 *
 * @author Owner
 */
public class AssignedRoute {
    private int userID;
    private int assigned_route_ID;
    private int vehicle_id;
    private int route_id;

    public AssignedRoute(){}
            
    public AssignedRoute(int userID,int assigned_route_ID,int vehicle_id,int route_id){
        this.userID = userID;
        this.assigned_route_ID = assigned_route_ID;
        this.vehicle_id = vehicle_id;
        this.route_id = route_id;
    }
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getAssigned_route_ID() {
        return assigned_route_ID;
    }

    public void setAssigned_route_ID(int assigned_route_ID) {
        this.assigned_route_ID = assigned_route_ID;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getRoute_id() {
        return route_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }
    
    
}
