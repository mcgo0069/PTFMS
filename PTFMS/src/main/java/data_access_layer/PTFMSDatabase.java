
package data_access_layer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Makes an instance for the database using singleton pattern.
 *
 */
public class PTFMSDatabase {

    // Marked volatile to ensure that multiple threads handle the connection
    private static volatile Connection connection = null;

    // Private constructor to prevent instantiation of this class.
    private PTFMSDatabase() {
    }

    /**
     * Provides a thread-safe method to get a singleton instance of the
     * database. Uses double-checked locking.
     *
     * @return Database connection.
     */
    public static Connection getConnection() {

        //First check
        if (connection == null) {
            synchronized (PTFMSDatabase.class) {
                // Second check to lock to ensure thread-safety
                //Get connection info from the properties file
                String[] connectionInfo = openPropertyFile();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    //Attempt a new database connection
                    connection = DriverManager.getConnection(
                            connectionInfo[0], connectionInfo[1], connectionInfo[2]);
                } catch (SQLException ex) {
                    System.out.println("Failed to get Connection");
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PTFMSDatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            // If a connection already exists, print this message
            System.out.println("Unable to create a new connection. Will use an existing one.");
        }
        return connection;// Return the established connection
    }

    /**
     * Gets the data for the connection from a properties file and stores it in
     * a string array array index: [0] connection string, [1] username, [2]
     * password
     *
     * @return string array with connection data
     */
    private static String[] openPropertyFile() {
        Properties properties = new Properties();
        String connectionString;
        String username;
        String password;
        String[] info = new String[3];

        try (InputStream input = PTFMSDatabase.class.getClassLoader().getResourceAsStream("database.properties")) {
            if (input == null) {
                System.err.println("Could not find database.properties in classpath");
            } else {
                properties.load(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //jdbc
        password = properties.getProperty("database.password");
        connectionString = properties.getProperty("database.url");
        username = properties.getProperty("database.username");

        info[0] = connectionString;
        info[1] = username;
        info[2] = password;

        return info;
    }
}
