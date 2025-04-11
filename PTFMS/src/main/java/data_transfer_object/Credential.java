package data_transfer_object;

/**
 * a DTO used to store and transfer DBMS login credentials between businesslayer
 * and dataacesslayer
 *
 * @author Eddy Su
 */
public class Credential {

    /**
     * username credential
     */
    private String username;
    /**
     * password credential
     */
    private String password;

    /**
     * constructor
     */
    public Credential(){}
    
    /**
     * constructor
     * @param user username credential
     * @param pass password credential
     */
    public Credential(String user,String pass){
        this.username = user;
        this.password = pass;
    }
    
    /**
     * getter for username credentials
     *
     * @return user name portion of the credentials
     */
    public String getUsername() {
        return username;
    }

    /**
     * setter for username credentials
     *
     * @param username username credentials
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * getter for the password credentials
     *
     * @return password credentials
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter for the password credentials
     *
     * @param password password credentials
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
