/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business_layer;

import CustomException.NoResultsFoundException;
import data_access_layer.PTFMSDaoImpl;
import data_transfer_object.AssignedRoute;
import data_transfer_object.Credential;
import data_transfer_object.Operator_Status;
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

    /**
     * Sets the credentials needed to use the database. Must be used before
     * using any of the utilities in this class
     *
     * @param cred DTO that stores the username and password for db
     *//*
    public static void setCredentials(Credential cred) {
        username = cred.getUsername();
        password = cred.getPassword();
    }

    /**
     * gets the credentials being used
     *
     * @return the credentials currently being used
     *//*
    public static Credential getCredentials() {
        return new Credential(username, password);
    }

    /**
     * gets a list of all authors
     *
     * @return list of authors in the db
     *//*
    public static List<Author> getAllAuthors() {
        try {
            //sends the query request for all author data
            return book_manager.getAllAuthors();
        } catch (NoResultsFoundException nrfe) {
            //error message for when no data was found
            System.out.println("There is no author data found\n");
        }
        return null;
    }

    /**
     * gets the data on a specific author (identified by their id)
     *
     * @param id author's id
     * @return author in the db with given id
     *//*
    public static List<Author> getByAuthorID(int id) {
        try {
            return book_manager.getByAuthorId(id);
        } catch (NoResultsFoundException nrfe) {
            //error message for when no data was found
            System.out.println("No results found for id: " + id + "\n");
        }
        return null;
    }

    /**
     * updates the Authors in the database
     *
     * @param author A DTO that holds data about an author
     * @return true if successful, false if not
     *//*
    public static boolean updateAuthorByID(Author author) {
        int changed;

        try {
            changed = book_manager.updateAuthorByID(author);
            System.out.println(changed + " row(s) have been updated");
            return changed != 0;
        } catch (SQLException sqlE) {
            System.out.println(sqlE.getMessage());
        }
        return false;
    }

    /**
     * Deletes an entry in the table
     *
     * @param id author's id
     * @return true if successful, false if not
     * @throws SQLException for throwing SQLException message
     *//*
    public static boolean deleteAuthorByID(int id) throws SQLException {
        int changed = book_manager.deleteAuthorByID(id);
        System.out.println(changed + " row(s) have been deleted");
        return changed != 0;
    }

    /**
     * inserts new data into the database
     *
     * @param author A DTO that holds data about an author
     * @return true if successful, false if not
     *//*
    public static boolean insertAuthor(Author author) {
        int changed;
        try {
            changed = book_manager.insertAuthor(author);
            System.out.println(changed + " row(s) have been inserted");
            return true;
        } catch (SQLException sqlE) {
            System.out.println(sqlE.getMessage());
        }
        return false;
    }
     */

    public static Users getByUserCredentials(Credential cred) {
        return ptfms_manager.getByCredential(cred);
    }

    public static int insertUser(Users user) {
        try {
            return ptfms_manager.insertUser(user);
        } catch (SQLException sqlE) {
            System.out.println(sqlE.getMessage());
        }
        return 0;
    }

    public static int insertVehicle(Vehicle vehicle) {
        try {
            return ptfms_manager.insertVehicle(vehicle);
        } catch (SQLException sqlE) {
            System.out.println(sqlE.getMessage());
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
        }
        return 0; 
    }
    
    public static int insertScheduleMaintenance(ScheduleMaintenance maintenance){
     try {
            return ptfms_manager.insertScheduleMaintenance(maintenance);
        } catch (SQLException sqlE) {
            System.out.println(sqlE.getMessage());
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
