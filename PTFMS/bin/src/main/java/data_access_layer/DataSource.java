/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access_layer;

import data_transfer_object.Credential;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Utility class that connects to the database
 *
 * @author Eddy Su
 * @see IOException
 * @see InputStream
 * @see Files
 * @see Paths
 * @see Connection
 * @see DriverManager
 * @see SQLException
 * @see Properties
 */
public class DataSource {

    /**
     * connection to the database
     */
    private static Connection connection = null;

    /**
     * username credential
     */
    private static String username = null;

    /**
     * password credential
     */
    private static String password = null;

    /**
     * url of db
     */
    private static final String URL = "jdbc:mysql://localhost:3306/books";

    /**
     * default constructor
     */
    private DataSource() {
    }//constructor

    /**
     * setter for db credentials used
     *
     * @param cred credentials (username, password) for the database
     */
    public static void setCredentials(Credential cred) {
        username = cred.getUsername().trim();
        password = cred.getPassword().trim();
    }

    /**
     * getter for db credentials used
     *
     * @return credentials (username, password) for the database
     */
    public static Credential getCredentials() {
        return new Credential(username, password);
    }

    /**
     * gets connection to the database
     *
     * @return connection to the database
     */
    public static Connection getConnection() {

        try {
            //if connection does not exist or is closed
            if (connection == null || connection.isClosed()) {
                if (username != null && password != null) {
                    // Explicitly load MySQL JDBC driver class
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    //url, username, password
                    connection = DriverManager.getConnection(URL, username, password);
                } else {
                    System.out.println("username or password were not set");
                }
            } else {
                System.out.println("Connection already exists");
            }
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Driver Error: ClassNotFoundException");
            cnfe.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to initiate connection");
            e.printStackTrace();
        }

        return connection;
    }//connection
}//DataSource
