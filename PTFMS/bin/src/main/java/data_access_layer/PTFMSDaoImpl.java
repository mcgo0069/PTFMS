package data_access_layer;

import data_transfer_object.AssignedRoute;
import data_transfer_object.Credential;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import data_transfer_object.Energy_Usage;
import data_transfer_object.Operator_Status;
import data_transfer_object.ScheduleMaintenance;
import data_transfer_object.Station;
import data_transfer_object.Transit_Log;
import data_transfer_object.Users;
import data_transfer_object.vehicle.FuelType;
import data_transfer_object.vehicle.Vehicle;
import data_transfer_object.vehicle.VehicleFactory;
import data_transfer_object.vehicle.VehicleType;

/**
 * PTFMSDaoImpl class implements the PTFMSDao interface and provides methods for
 * interacting with the database, specifically for accessing and manipulating
 * data related to Users, Transit Logs, and Vehicles in the PTFMS system.
 *
 * @author Jennifer Goodchild 040683485
 */
public class PTFMSDaoImpl implements PTFMSDao {

    /**
     * Retrieves all users from the 'users' table, sorts them by user_id, and
     * returns them as a list of Users objects.
     *
     * @return List<Users> A list containing all Users retrieved from the
     * database.
     */
    @Override
    public List<Users> getAllUsers() {
        ArrayList<Users> users = new ArrayList<>();// Initialize the list to store Users objects

        try {
            Connection con = PTFMSDatabase.getConnection(); //get database connection.
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users ORDER BY user_id");
            ResultSet rs = pstmt.executeQuery(); //Execute the query

            // Retrieve metadata from ResultSet to display column attributes.
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Display column metadata (name, type, class).
            System.out.println("\nPTFMS Users");
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-8s\t", metaData.getColumnName(i));
                System.out.printf("%-8s\t", metaData.getColumnTypeName(i));
                System.out.printf("%-8s\t", metaData.getColumnClassName(i));
                System.out.printf("\n");
            }

            System.out.println();
            // Display the column names as headers for the ResultSet data.    
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-25s\t", metaData.getColumnName(i));
            }
            System.out.println();

            // Process each row in the ResultSet and add it to the list.     
            while (rs.next()) {

                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%-25s\t", rs.getObject(i));
                }
                System.out.println();
                Users user = new Users();

                // Get the data from ResultSet and populate the recipient object.
                int user_id = rs.getInt("user_id");
                user.setUserID(user_id);

                String user_name = rs.getString("user_name");
                user.setUsername(user_name);

                String first_name = rs.getString("first_name");
                user.setFirstName(first_name);

                String last_name = rs.getString("last_name");
                user.setLastName(last_name);

                String email = rs.getString("email");
                user.setEmail(email);

                // Add the recipient object to the list. 
                users.add(user);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Users getByUserID(int user_id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Users user = null;

        try {
            con = PTFMSDatabase.getConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM users WHERE user_id = ?");
            pstmt.setInt(1, user_id); //Set the AwardID parameter in the query.
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new Users();// Create a new recipient object.
                user.setUserID(rs.getInt("user_id"));
                user.setUsername(rs.getString("user_name"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int insertUser(Users user) throws SQLException {
        String query = "INSERT INTO users(user_name, first_name, last_name, email, password, role) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = PTFMSDatabase.getConnection(); //connect to db
                 PreparedStatement ps = connection.prepareStatement(query); //prepare query
                ) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getRole());

            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error: There is something wrong with the query");
        }
    }

    @Override
    public int updateUserByID(Users user) throws SQLException {
        String query = "UPDATE users "
                + "SET user_name = ?, first_name = ?,last_name = ?, email = ?, password = ?"
                + "WHERE user_id = ?;";

        try (Connection connection = PTFMSDatabase.getConnection(); //connect to db
                 PreparedStatement ps = connection.prepareStatement(query); //prepare query
                ) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getUserID());

            return ps.executeUpdate(); //returns the number of rows changed

        } catch (SQLException e) {
            throw new SQLException("Error: There is something wrong with the query");
        }
    }

    @Override
    public int deleteUserByID(int user_id) throws SQLException {
        String query = "DELETE FROM users WHERE user_id = ?;";

        try (Connection connection = PTFMSDatabase.getConnection(); //connect to db
                 PreparedStatement ps = connection.prepareStatement(query); //prepare query
                ) {

            ps.setInt(1, user_id);

            return ps.executeUpdate(); //returns the number of rows changed
        } catch (SQLException e) {
            throw new SQLException("Error: The deletion involves other tables in the database and thus cannot be deleted");
        }
    }

    @Override
    public List<Transit_Log> getAllTransitLogs() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Transit_Log> logs = null;

        try {
            con = PTFMSDatabase.getConnection(); //get database connection.

            //Query to retrieve all records from the Recipients table.
            String query = "SELECT * FROM transit_log ORDER BY log_id";
            pstmt = con.prepareStatement(query);

            rs = pstmt.executeQuery(); //Execute the query
            logs = new ArrayList<Transit_Log>(); //Initialize the list to store data.

            // Retrieve metadata from ResultSet to display column attributes.
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Display column metadata (name, type, class).
            System.out.println("\nPTFMS Transit Log");
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-8s\t", metaData.getColumnName(i));
                System.out.printf("%-8s\t", metaData.getColumnTypeName(i));
                System.out.printf("%-8s\t", metaData.getColumnClassName(i));
                System.out.printf("\n");
            }

            System.out.println();
            // Display the column names as headers for the ResultSet data.    
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-25s\t", metaData.getColumnName(i));
            }
            System.out.println();

            // Process each row in the ResultSet and add it to the list.     
            while (rs.next()) {

                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%-25s\t", rs.getObject(i));
                }
                System.out.println();
                Transit_Log log = new Transit_Log();

                // Get the data from ResultSet and populate the recipient object.
                int log_id = rs.getInt("log_id");
                log.setLogID(log_id);

                int station_id = rs.getInt("station_id");
                log.setStationID(station_id);

                int vehicle_id = rs.getInt("vehicle_id");
                log.setVehicleID(vehicle_id);

                String arrival_time = rs.getString("arrival_time");
                log.setArrivalTime(arrival_time);

                String departure_time = rs.getString("departure_time");
                log.setDepartureTime(departure_time);

                // Add the recipient object to the list. 
                logs.add(log);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logs;
    }

    @Override
    public Transit_Log getByTransitLogID(int log_id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Transit_Log log = null;

        try {
            con = PTFMSDatabase.getConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM transit_log WHERE log_id = ?");
            pstmt.setInt(1, log_id); //Set the AwardID parameter in the query.
            rs = pstmt.executeQuery();
            while (rs.next()) {
                log = new Transit_Log();// Create a new recipient object.
                log.setLogID(rs.getInt("log_id"));
                log.setStationID(rs.getInt("station_id"));
                log.setVehicleID(rs.getInt("vehicle_id"));
                log.setArrivalTime(rs.getString("arrival_time"));
                log.setDepartureTime(rs.getString("departure_time"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return log;
    }

    @Override
    public int insertTransitLog(Transit_Log log) throws SQLException {
        String query = "INSERT INTO transit_log(station_id, vehicle_id, arrival_time, departure_time) VALUES(?, ?, ?, ?)";
        try (Connection connection = PTFMSDatabase.getConnection(); //connect to db
                 PreparedStatement ps = connection.prepareStatement(query); //prepare query
                ) {
            ps.setInt(1, log.getStationID());
            ps.setInt(2, log.getVehicleID());
            ps.setString(3, log.getArrivalTime());
            ps.setString(4, log.getDepartureTime());

            return ps.executeUpdate(); //returns the number of rows changed
        } catch (SQLException e) {
            throw new SQLException("Error: There is something wrong with the query");
        }
    }

    @Override
    public int updateTransitLogByID(Transit_Log log) throws SQLException {
        String query = "UPDATE transit_log "
                + "SET station_id = ?, vehicle_id = ?,arrival_time = ?, departure_time = ?"
                + "WHERE log_id = ?;";

        try (Connection connection = PTFMSDatabase.getConnection(); //connect to db
                 PreparedStatement ps = connection.prepareStatement(query); //prepare query
                ) {
            ps.setInt(1, log.getStationID());
            ps.setInt(2, log.getVehicleID());
            ps.setString(3, log.getArrivalTime());
            ps.setString(4, log.getDepartureTime());
            ps.setInt(5, log.getLogID());

            return ps.executeUpdate(); //returns the number of rows changed

        } catch (SQLException e) {
            throw new SQLException("Error: There is something wrong with the query");
        }
    }

    @Override
    public int deleteTransitLogByID(int log_id) throws SQLException {
        String query = "DELETE FROM transit_log WHERE log_id = ?;";

        try (Connection connection = PTFMSDatabase.getConnection(); //connect to db
                 PreparedStatement ps = connection.prepareStatement(query); //prepare query
                ) {

            ps.setInt(1, log_id);

            return ps.executeUpdate(); //returns the number of rows changed
        } catch (SQLException e) {
            throw new SQLException("Error: The deletion involves other tables in the database and thus cannot be deleted");
        }
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Vehicle> vehicles = null;

        try {
            con = PTFMSDatabase.getConnection(); //get database connection.

            //Query to retrieve all records from the Recipients table.
            String query = "SELECT * FROM vehicle ORDER BY vehicle_id";
            pstmt = con.prepareStatement(query);

            rs = pstmt.executeQuery(); //Execute the query
            vehicles = new ArrayList<Vehicle>(); //Initialize the list to store data.

            // Retrieve metadata from ResultSet to display column attributes.
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Display column metadata (name, type, class).
            System.out.println("\nPTFMS List of Vehicles");
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-8s\t", metaData.getColumnName(i));
                System.out.printf("%-8s\t", metaData.getColumnTypeName(i));
                System.out.printf("%-8s\t", metaData.getColumnClassName(i));
                System.out.printf("\n");
            }

            System.out.println();
            // Display the column names as headers for the ResultSet data.    
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-25s\t", metaData.getColumnName(i));
            }
            System.out.println();

            // Process each row in the ResultSet and add it to the list.     
            while (rs.next()) {

                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%-25s\t", rs.getObject(i));
                }
                System.out.println();
                Vehicle vehicle = switch (rs.getString("vehicle_type")) {
                    case "Diesel_Bus" ->
                        VehicleFactory.buildVehicle(VehicleType.Diesel_Bus);
                    case "Electric_Light_Rail" ->
                        VehicleFactory.buildVehicle(VehicleType.Electric_Light_Rail);
                    case "Diesel_Electric_Train" ->
                        VehicleFactory.buildVehicle(VehicleType.Diesel_Electric_Train);
                    default ->
                        null;
                };

                // Get the data from ResultSet and populate the recipient object.
                vehicle.setVehicleNumber(rs.getInt("vehicle_id"));

                // Add the recipient object to the list. 
                vehicles.add(vehicle);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    @Override
    public Vehicle getByVehicleID(int vehicle_id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Vehicle vehicle = null;

        try {
            con = PTFMSDatabase.getConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM vehicle WHERE vehicle_id = ?");
            pstmt.setInt(1, vehicle_id); //Set the AwardID parameter in the query.
            rs = pstmt.executeQuery();
            while (rs.next()) {
                vehicle = switch (rs.getString("vehicle_type")) {
                    case "Diesel_Bus" ->
                        VehicleFactory.buildVehicle(VehicleType.Diesel_Bus);
                    case "Electric_Light_Rail" ->
                        VehicleFactory.buildVehicle(VehicleType.Electric_Light_Rail);
                    case "Diesel_Electric_Train" ->
                        VehicleFactory.buildVehicle(VehicleType.Diesel_Electric_Train);
                    default ->
                        null;
                };

                vehicle.setVehicleNumber(rs.getInt("vehicle_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    @Override
    public int insertVehicle(Vehicle vehicle) throws SQLException {
        String query = "INSERT INTO vehicle(vehicle_type, energy_type, consumption_rate, max_passengers) VALUES(?, ?, ?, ?, ?)";
        try (Connection connection = PTFMSDatabase.getConnection(); //connect to db
                 PreparedStatement ps = connection.prepareStatement(query); //prepare query
                ) {

            ps.setString(1, vehicle.getVehicleType().toString());
            ps.setString(2, vehicle.getFuelType().toString());
            ps.setDouble(3, vehicle.getConsumptionRate());
            ps.setInt(4, vehicle.getMaxPassengers());

            return ps.executeUpdate(); //returns the number of rows changed
        } catch (SQLException e) {
            throw new SQLException("Error: There is something wrong with the query");
        }
    }

    @Override
    public int updateVehicleByID(Vehicle vehicle) throws SQLException {
        String query = "UPDATE vehicle "
                + "SET vehicle_type = ?, enery_type = ?,consumption_rate = ?, max_passengers = ?"
                + "WHERE vehicle_id = ?;";

        try (Connection connection = PTFMSDatabase.getConnection(); //connect to db
                 PreparedStatement ps = connection.prepareStatement(query); //prepare query
                ) {
            ps.setString(1, vehicle.getVehicleType().toString());
            ps.setString(2, vehicle.getFuelType().toString());
            ps.setDouble(3, vehicle.getConsumptionRate());
            ps.setInt(4, vehicle.getMaxPassengers());
            ps.setInt(5, vehicle.getVehicleNumber());

            return ps.executeUpdate(); //returns the number of rows changed

        } catch (SQLException e) {
            throw new SQLException("Error: There is something wrong with the query");
        }
    }

    @Override
    public int deleteVehicleByID(int vehicle_id) throws SQLException {
        String query = "DELETE FROM vehicle WHERE vehicle_id = ?;";

        try (Connection connection = PTFMSDatabase.getConnection(); //connect to db
                 PreparedStatement ps = connection.prepareStatement(query); //prepare query
                ) {

            ps.setInt(1, vehicle_id);

            return ps.executeUpdate(); //returns the number of rows changed
        } catch (SQLException e) {
            throw new SQLException("Error: The deletion involves other tables in the database and thus cannot be deleted");
        }
    }

    @Override
    public List<Operator_Status> getAllOperatorStatus() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Operator_Status> Operator_status = null;

        try {
            con = PTFMSDatabase.getConnection(); //get database connection.

            //Query to retrieve all records from the Recipients table.
            String query = "SELECT * FROM operator_status ORDER BY status_id";
            pstmt = con.prepareStatement(query);

            rs = pstmt.executeQuery(); //Execute the query
            Operator_status = new ArrayList<Operator_Status>(); //Initialize the list to store data.

            // Retrieve metadata from ResultSet to display column attributes.
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Display column metadata (name, type, class).
            System.out.println("\nPTFMS Operator Status'");
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-8s\t", metaData.getColumnName(i));
                System.out.printf("%-8s\t", metaData.getColumnTypeName(i));
                System.out.printf("%-8s\t", metaData.getColumnClassName(i));
                System.out.printf("\n");
            }

            System.out.println();
            // Display the column names as headers for the ResultSet data.    
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-25s\t", metaData.getColumnName(i));
            }
            System.out.println();

            // Process each row in the ResultSet and add it to the list.     
            while (rs.next()) {

                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%-25s\t", rs.getObject(i));
                }
                System.out.println();
                Operator_Status status = new Operator_Status();

                // Get the data from ResultSet and populate the recipient object.
                int status_id = rs.getInt("status_id");
                status.setStatusID(status_id);

                int user_id = rs.getInt("user_id");
                status.setUserID(user_id);

                String status_type = rs.getString("status_type");
                status.setStatusType(status_type);

                String timestamp = rs.getString("timestamp");
                status.setTimeStamp(timestamp);

                // Add the recipient object to the list. 
                Operator_status.add(status);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Operator_status;
    }

    @Override
    public Operator_Status getByOperatorStatusID(int status_id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Operator_Status status = null;

        try {
            con = PTFMSDatabase.getConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM operator_status WHERE status_id = ?");
            pstmt.setInt(1, status_id); //Set the AwardID parameter in the query.
            rs = pstmt.executeQuery();
            while (rs.next()) {
                status = new Operator_Status();// Create a new recipient object.
                status.setStatusID(rs.getInt("status_id"));
                status.setUserID(rs.getInt("user_id"));
                status.setStatusType(rs.getString("status_type"));
                status.setTimeStamp(rs.getString("timestamp"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int insertOperatorStatus(Operator_Status status) throws SQLException {
        String query = "INSERT INTO operator_status(user_id, status_type, timestamp) VALUES(?, ?, ?)";
        try (Connection connection = PTFMSDatabase.getConnection(); //connect to db
                 PreparedStatement ps = connection.prepareStatement(query); //prepare query
                ) {

            ps.setInt(1, status.getUserID());
            ps.setString(2, status.getStatusType());
            ps.setString(3, status.getTimeStamp());

            return ps.executeUpdate(); //returns the number of rows changed
        } catch (SQLException e) {
            throw new SQLException("Error: There is something wrong with the query");
        }
    }

    @Override
    public int updateOperatorStatusByID(Operator_Status status) throws SQLException {
        String query = "UPDATE operator_status "
                + "SET user_id = ?, status_type = ?, timestamp = ?"
                + "WHERE status_id = ?;";

        try (Connection connection = PTFMSDatabase.getConnection(); //connect to db
                 PreparedStatement ps = connection.prepareStatement(query); //prepare query
                ) {
            ps.setInt(1, status.getUserID());
            ps.setString(2, status.getStatusType());
            ps.setString(3, status.getTimeStamp());
            ps.setInt(4, status.getStatusID());

            return ps.executeUpdate(); //returns the number of rows changed

        } catch (SQLException e) {
            throw new SQLException("Error: There is something wrong with the query");
        }
    }

    @Override
    public int deleteOperatorStatusByID(int status_id) throws SQLException {
        String query = "DELETE FROM operator_status WHERE status_id = ?;";

        try (Connection connection = PTFMSDatabase.getConnection(); //connect to db
                 PreparedStatement ps = connection.prepareStatement(query); //prepare query
                ) {

            ps.setInt(1, status_id);

            return ps.executeUpdate(); //returns the number of rows changed
        } catch (SQLException e) {
            throw new SQLException("Error: The deletion involves other tables in the database and thus cannot be deleted");
        }
    }

    @Override
    public List<Energy_Usage> getAllEnergyUsage() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Energy_Usage> usage = null;

        try {
            con = PTFMSDatabase.getConnection(); //get database connection.

            //Query to retrieve all records from the Recipients table.
            String query = "SELECT * FROM operator_status ORDER BY status_id";
            pstmt = con.prepareStatement(query);

            rs = pstmt.executeQuery(); //Execute the query
            usage = new ArrayList<Energy_Usage>(); //Initialize the list to store data.

            // Retrieve metadata from ResultSet to display column attributes.
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Display column metadata (name, type, class).
            System.out.println("\nPTFMS Energy Use Report");
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-8s\t", metaData.getColumnName(i));
                System.out.printf("%-8s\t", metaData.getColumnTypeName(i));
                System.out.printf("%-8s\t", metaData.getColumnClassName(i));
                System.out.printf("\n");
            }

            System.out.println();
            // Display the column names as headers for the ResultSet data.    
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-25s\t", metaData.getColumnName(i));
            }
            System.out.println();

            // Process each row in the ResultSet and add it to the list.     
            while (rs.next()) {

                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%-25s\t", rs.getObject(i));
                }
                System.out.println();
                Energy_Usage energy_usage = new Energy_Usage();

                // Get the data from ResultSet and populate the recipient object.
                int usage_id = rs.getInt("usage_id");
                energy_usage.setUsageID(usage_id);

                int vehicle_id = rs.getInt("vehicle_id");
                energy_usage.setVehicleID(vehicle_id);

                Date date = rs.getDate("date");
                energy_usage.setDate(date);

                int kms_traveled = rs.getInt("kms_traveled");
                energy_usage.setKmsTraveled(kms_traveled);

                int fuel_consumed = rs.getInt("fuel_consumed");
                energy_usage.setFuelConsumed(fuel_consumed);

                int energy_used = rs.getInt("energy_used");
                energy_usage.setEnergyUsed(energy_used);

                int efficiency = rs.getInt("efficiency");
                energy_usage.setEfficiency(efficiency);

                // Add the recipient object to the list. 
                usage.add(energy_usage);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usage;
    }

    @Override
    public Energy_Usage getByUsageID(int usage_id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Energy_Usage usage = null;

        try {
            con = PTFMSDatabase.getConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM energy_usage WHERE usage_id = ?");
            pstmt.setInt(1, usage_id); //Set the AwardID parameter in the query.
            rs = pstmt.executeQuery();
            while (rs.next()) {
                usage = new Energy_Usage();// Create a new recipient object.
                usage.setUsageID(rs.getInt("usage_id"));
                usage.setVehicleID(rs.getInt("vehicle_id"));
                usage.setDate(rs.getDate("date"));
                usage.setKmsTraveled(rs.getInt("kms_traveled"));
                usage.setFuelConsumed(rs.getInt("fuel_consumed"));
                usage.setEnergyUsed(rs.getInt("energy_used"));
                usage.setEfficiency(rs.getInt("efficiency"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usage;
    }

    @Override
    public int insertEnergyUsage(Energy_Usage usage) throws SQLException {
        String query = "INSERT INTO energy_usage(vehicle_id, date, kms_traveled, fuel_consumed, energy_used, efficiency) VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection connection = PTFMSDatabase.getConnection(); //connect to db
                 PreparedStatement ps = connection.prepareStatement(query); //prepare query
                ) {

            ps.setInt(1, usage.getVehicleID());
            ps.setDate(2, usage.getDate());
            ps.setInt(3, usage.getKmsTraveled());
            ps.setInt(4, usage.getFuelConsumed());
            ps.setInt(5, usage.getEnergyUsed());
            ps.setInt(6, usage.getEfficiency());

            return ps.executeUpdate(); //returns the number of rows changed
        } catch (SQLException e) {
            throw new SQLException("Error: There is something wrong with the query");
        }
    }

    @Override
    public int updateEnergyUsageByID(Energy_Usage usage) throws SQLException {
        String query = "UPDATE energy_usage "
                + "SET vehicle_id = ?, date = ?, kms_traveled = ?, fuel_consumed = ?, energy_used = ?, efficiency = ?"
                + "WHERE usage_id = ?;";

        try (Connection connection = PTFMSDatabase.getConnection(); //connect to db
                 PreparedStatement ps = connection.prepareStatement(query); //prepare query
                ) {
            ps.setInt(1, usage.getVehicleID());
            ps.setDate(2, usage.getDate());
            ps.setInt(3, usage.getKmsTraveled());
            ps.setInt(4, usage.getFuelConsumed());
            ps.setInt(5, usage.getEnergyUsed());
            ps.setInt(6, usage.getEfficiency());

            return ps.executeUpdate(); //returns the number of rows changed

        } catch (SQLException e) {
            throw new SQLException("Error: There is something wrong with the query");
        }
    }

    @Override
    public int deleteEnergyUsageByID(int usage_id) throws SQLException {
        String query = "DELETE FROM energy_usage WHERE usage_id = ?;";

        try (Connection connection = PTFMSDatabase.getConnection(); //connect to db
                 PreparedStatement ps = connection.prepareStatement(query); //prepare query
                ) {

            ps.setInt(1, usage_id);

            return ps.executeUpdate(); //returns the number of rows changed
        } catch (SQLException e) {
            throw new SQLException("Error: The deletion involves other tables in the database and thus cannot be deleted");
        }
    }

    public Users getByCredential(Credential cred) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Users user = null;

        try {
            con = PTFMSDatabase.getConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM users WHERE user_name = ?, password = ?");
            pstmt.setString(1, cred.getUsername()); //Set the username parameter in the query.
            pstmt.setString(2, cred.getPassword()); //Set the password parameter in the query.
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new Users();// Create a new recipient object.
                user.setUserID(rs.getInt("user_id"));
                user.setUsername(rs.getString("user_name"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public Operator_Status getOperatorStatusByID(int user_id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Operator_Status status = null;

        try {
            con = PTFMSDatabase.getConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM operator_status WHERE user_id = ?");
            pstmt.setInt(1, user_id); //Set the AwardID parameter in the query.
            rs = pstmt.executeQuery();
            while (rs.next()) {
                status = new Operator_Status();// Create a new recipient object.
                status.setStatusID(rs.getInt("status_id"));
                status.setUserID(rs.getInt("user_id"));
                status.setStatusType(rs.getString("status_type"));
                status.setTimeStamp(rs.getString("timestamp"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    
   public List<Station> getAllStations() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Station> stations = new ArrayList<>();

        try {
            con = PTFMSDatabase.getConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM Station");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                stations.add(new Station(rs.getInt("station_id"),rs.getString("address")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stations;
    }
   
   public List<AssignedRoute> getAllAssignedRoutes() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<AssignedRoute> assigned_routes = new ArrayList<>();

        try {
            con = PTFMSDatabase.getConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM assigned_route");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                assigned_routes.add(new AssignedRoute(
                        rs.getInt("user_id"),
                        rs.getInt("assigned_route_id"),
                        rs.getInt("vehicle_id"),
                        rs.getInt("route_id")
                        ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assigned_routes;
    }
   
    public int insertScheduleMaintenance(ScheduleMaintenance schedule) throws SQLException {
        String query = "INSERT INTO Maintenance(vehicle_id, scheduledDate, description) VALUES(?, ?, ?)";
        try (Connection connection = PTFMSDatabase.getConnection(); //connect to db
                 PreparedStatement ps = connection.prepareStatement(query); //prepare query
                ) {

            ps.setInt(1, schedule.getVehicleID());
            ps.setDate(2, schedule.getMaintenanceTime());
            ps.setString(3, schedule.getDescription());

            return ps.executeUpdate(); //returns the number of rows changed
        } catch (SQLException e) {
            throw new SQLException("Error: There is something wrong with the query");
        }
    }
}
