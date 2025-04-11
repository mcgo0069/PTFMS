package data_access_layer;

import java.sql.SQLException;
import java.util.List;
import data_transfer_object.Energy_Usage;
import data_transfer_object.Operator_Status;
import data_transfer_object.Transit_Log;
import data_transfer_object.Users;
import data_transfer_object.vehicle.Vehicle;

/**
 * This interface the performance of CRUD operations (Create, Read, Update,
 * Delete) on various entities in the PTFMS system.
 *
 * @author Jenni
 */
public interface PTFMSDao {

    /**
     * Retrieves all users from the database.
     * @return List of users.
     */
    public List<Users> getAllUsers();

    /**
     * Retrieves a list of users by their user_id.
     *
     * @param user_id ID of the user.
     * @return List of users.
     */
    public Users getByUserID(int user_id);

    /**
     * Deletes a user by ID.
     *
     * @param user_id ID of the user to delete.
     * @return Number of affected rows.
     * @throws NumberFormatException
     * @throws SQLException
     */
    public int deleteUserByID(int user_id) throws NumberFormatException, SQLException;

    /**
     * Updates a user record by ID.
     *
     * @param user Users object with updated data.
     * @return Number of affected rows.
     * @throws NumberFormatException
     * @throws SQLException
     */
    public int updateUserByID(Users user) throws NumberFormatException, SQLException;

    /**
     * Inserts a new user into the database.
     *
     * @param user Users object to insert.
     * @return Number of affected rows.
     * @throws NumberFormatException
     * @throws SQLException
     */
    public int insertUser(Users user) throws NumberFormatException, SQLException;

    /**
     * Retrieves all transit logs.
     *
     * @return List of Transit logs
     */
    public List<Transit_Log> getAllTransitLogs();

    /**
     * Retrieves a list of transit logs by log ID.
     *
     * @param log_id ID of the transit log.
     * @return List of matching transit logs.
     */
    public Transit_Log getByTransitLogID(int log_id);

    /**
     * Deletes a transit log by ID.
     *
     * @param log_id ID of the transit log to delete.
     * @return Number of affected rows.
     * @throws java.sql.SQLException
     */
    public int deleteTransitLogByID(int log_id) throws NumberFormatException, SQLException;

    /**
     * Updates a transit log by ID.
     *
     * @param transit_log Transit_Log object with updated data.
     * @return Number of affected rows.
     * @throws java.sql.SQLException
     */
    public int updateTransitLogByID(Transit_Log transit_log) throws NumberFormatException, SQLException;

    /**
     * Inserts a new transit log.
     *
     * @param transit_log Transit_Log object to insert.
     * @return Number of affected rows.
     * @throws java.sql.SQLException
     */
    public int insertTransitLog(Transit_Log transit_log) throws NumberFormatException, SQLException;

    /**
     * Retrieves all vehicles.
     *
     * @return List of all registered vehicles
     */
    public List<Vehicle> getAllVehicles();

    /**
     * Retrieves a list of vehicles by vehicle ID.
     *
     * @param vehicle_id ID of the vehicle.
     * @return List of matching vehicles.
     */
    public Vehicle getByVehicleID(int vehicle_id);

    /**
     * Deletes a vehicle by ID.
     *
     * @param vehicle_id ID of the vehicle to delete.
     * @return Number of affected rows.
     */
    public int deleteVehicleByID(int vehicle_id) throws NumberFormatException, SQLException;

    /**
     * Updates a vehicle record by ID.
     *
     * @param vehicle Vehicle object with updated data.
     * @return Number of affected rows.
     */
    public int updateVehicleByID(Vehicle vehicle) throws NumberFormatException, SQLException;

    /**
     * Inserts a new vehicle into the database.
     *
     * @param vehicle Vehicle object to insert.
     * @return Number of affected rows.
     */
    public int insertVehicle(Vehicle vehicle) throws NumberFormatException, SQLException;

    /**
     * Retrieves all operator statuses.
     *
     * @return List of all Operator status
     */
    public List<Operator_Status> getAllOperatorStatus();

    /**
     * Retrieves a list of operator statuses by status ID.
     *
     * @param status_id ID of the operator status.
     * @return List of matching operator statuses.
     */
    public Operator_Status getByOperatorStatusID(int status_id);

    /**
     * Deletes an operator status by ID.
     *
     * @param status_id ID of the status to delete.
     * @return Number of affected rows.
     */
    public int deleteOperatorStatusByID(int status_id) throws NumberFormatException, SQLException;

    /**
     * Updates an operator status by ID.
     *
     * @param status Operator_Status object with updated data.
     * @return Number of affected rows.
     */
    public int updateOperatorStatusByID(Operator_Status status) throws NumberFormatException, SQLException;

    /**
     * Inserts a new operator status.
     *
     * @param status Operator_Status object to insert.
     * @return Number of affected rows.
     */
    public int insertOperatorStatus(Operator_Status status) throws NumberFormatException, SQLException;

    /**
     * Retrieves all energy usage records.
     *
     * @return List of Operator Status
     */
    public List<Energy_Usage> getAllEnergyUsage();

    /**
     * Retrieves energy usage data by usage ID.
     *
     * @param usage_id ID of the energy usage record.
     * @return List of matching energy usage records.
     */
    public Energy_Usage getByUsageID(int usage_id);

    /**
     * Deletes an energy usage record by ID.
     *
     * @param usage_id ID of the record to delete.
     * @return Number of affected rows.
     */
    public int deleteEnergyUsageByID(int usage_id) throws NumberFormatException, SQLException;

    /**
     * Updates an energy usage record by ID.
     *
     * @param usage Energy_Usage object with updated data.
     * @return Number of affected rows.
     */
    public int updateEnergyUsageByID(Energy_Usage usage) throws NumberFormatException, SQLException;

    /**
     * Inserts a new energy usage record.
     *
     * @param usage Energy_Usage object to insert.
     * @return Number of affected rows.
     */
    public int insertEnergyUsage(Energy_Usage usage) throws NumberFormatException, SQLException;

}
