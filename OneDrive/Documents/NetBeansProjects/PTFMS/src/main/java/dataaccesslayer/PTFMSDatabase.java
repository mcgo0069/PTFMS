
package dataaccesslayer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Jenni
 */
public class PTFMSDatabase {

    // Marked volatile to ensure that multiple threads handle the connection
    private static volatile Connection connection = null;

    // Private constructor to prevent instantiation of this class.
    private PTFMSDatabase() { }

    
    /**
     * @return Database connection.
     */
    
    public static Connection getConnection() {
        //First check
        if (connection == null) {  
            synchronized (PTFMSDatabase.class) {
                // Second check to lock to ensure thread-safety
                if (connection == null) {  
                    //Get connection info from the properties file
                    String[] connectionInfo = openPropsFile();

                    try {
                        //Attempt a new database connection
                        connection = DriverManager.getConnection(
                            connectionInfo[0], connectionInfo[1], connectionInfo[2]);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } else {
            // If a connection already exists, print this message
            System.out.println("Unable to create a new connection. Will use an existing one.");
        }
        return connection;// Return the established connection
    }

    /**
     * Reads the database connection properties from the properties file.
     * @return A string array that contains the connection URL, username, and password.
     */
    
    private static String[] openPropsFile() {
        Properties props = new Properties(); //properties object to hold the connection info

        try (InputStream in = Files.newInputStream(Paths.get("src/main/java/database.properties"))) {
            //Load the properties from the file.
            props.load(in);
        } catch (IOException e) {
            
            e.printStackTrace();
        }

        // The connection details from the properties file.
        String connectionString = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        // Return the connection details as a string array.
        return new String[]{connectionString, username, password};
    }
}
