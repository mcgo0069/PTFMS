/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business_layer;

import CustomException.NoResultsFoundException;
import data_access_layer.PTFMSDaoImpl;
import data_transfer_object.AssignedRoute;
import data_transfer_object.Credential;
import data_transfer_object.ScheduleMaintenance;
import data_transfer_object.Station;
import data_transfer_object.Transit_Log;
import data_transfer_object.Users;
import data_transfer_object.vehicle.Vehicle;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

/**
 * A utility class that gets data from the database
 *
 * @author Eddy Su
 * @see BookManagerDAOImpl
 * @see Author
 * @see Book
 * @see Credential
 * @see ResultSetMetaData
 * @see List
 * @see NoResultsFoundException
 * @see SQLException
 */
public class Ptfms_db_Manager {

    /**
     * username credential
     */
    private static String username = null;
    /**
     * password credential
     */
    private static String password = null;

    /**
     * The data access program for accessing the database and retrieving data
     * about the authors
     */
    private static PTFMSDaoImpl ptfms_manager = new PTFMSDaoImpl();

    /**
     * default constructor
     */
    private Ptfms_db_Manager() {
    }

    public static Users getByUserCredentials(Credential cred) {
        return ptfms_manager.getByCredential(cred);
    }

    public static int insertUser(Users user) {
        try {
            return ptfms_manager.insertUser(user);
        } catch (SQLException sqlE) {
            System.out.println(sqlE.getMessage());
            sqlE.printStackTrace();
        }
        return 0;
    }

    public static int insertVehicle(Vehicle vehicle) {
        try {
            return ptfms_manager.insertVehicle(vehicle);
        } catch (SQLException sqlE) {
            System.out.println(sqlE.getMessage());
            sqlE.printStackTrace();
        }
        return 0;
    }

    public static List<Vehicle> getAllVehicles() {
        return ptfms_manager.getAllVehicles();
    }
    
    public static List<Station> getAllStations() {
        return ptfms_manager.getAllStations();
    }
    
    public static int insertLog(Transit_Log log){
     try {
            return ptfms_manager.insertTransitLog(log);
        } catch (SQLException sqlE) {
            System.out.println(sqlE.getMessage());
            sqlE.printStackTrace();
        }
        return 0; 
    }
    
    public static int insertScheduleMaintenance(ScheduleMaintenance maintenance){
     try {
            return ptfms_manager.insertScheduleMaintenance(maintenance);
        } catch (SQLException sqlE) {
            System.out.println(sqlE.getMessage());
            sqlE.printStackTrace();
        }
        return 0; 
    }
    
    public static List<Transit_Log> getAllTransitLogs() {
        return ptfms_manager.getAllTransitLogs();
    }
    
    public static List<AssignedRoute> getAllAssignedRoutes() {
        return ptfms_manager.getAllAssignedRoutes();
    }
}
