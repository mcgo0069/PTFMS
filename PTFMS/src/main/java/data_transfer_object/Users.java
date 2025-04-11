package data_transfer_object;

/**
 * Users class is a DTO representing a user in the PTFMS (Public Transit Fleet
 * Management System).
 *
 * @author Jennifer Goodchild 040683485
 */
public class Users {

    /**
     * Unique identifier for the user.
     */
    private Integer user_id;
    /**
     * User's first name.
     */
    private String first_name;
    /**
     * User's last name.
     */
    private String last_name;
    /**
     * Username used to log in.
     */
    private String user_name;
    /**
     * User's email address.
     */
    private String email;
    /**
     * User's password.
     */
    private String password;
    /**
     * User's role
     */
    private String role;

    /**
     * Constructor for a Users object with the specified user details.
     *
     * @param user_id the unique user ID
     * @param first_name the user's first name
     * @param last_name the user's last name
     * @param user_name the login username
     * @param email the user's email address
     * @param password the user's password.
     * @param role user's role 
     */
    public Users(Integer user_id, String first_name, String last_name, String user_name, String email, String password, String role) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    
    /**
     * Constructor for a Users object with the specified user details.
     *
     * @param first_name the user's first name
     * @param last_name the user's last name
     * @param user_name the login username
     * @param email the user's email address
     * @param password the user's password.
     * @param role user's role 
     */
    public Users(String first_name, String last_name, String email, String user_name, String password, String role) {
        this.user_id = -1;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    /**
     * Default constructor for Users
     */
    public Users() {
    }

    /**
     * Gets the user ID.
     *
     * @return the user's unique ID
     */
    public Integer getUserID() {
        return user_id; //Returns the award ID of the recipient.
    }

    /**
     * Sets the user ID.
     *
     * @param user_id the unique ID to assign to the user
     */
    public void setUserID(Integer user_id) {
        this.user_id = user_id;//Sets the award ID for the recipient.
    }

    /**
     * Gets the user's first name.
     *
     * @return the first name of the user
     */
    public String getFirstName() {
        return first_name; //Returns the name of the recipient.
    }

    /**
     * Sets the user's first name.
     *
     * @param first_name the first name to assign
     */
    public void setFirstName(String first_name) {
        this.first_name = first_name;//Sets the name of the recipient.
    }

    /**
     * Gets the user's last name.
     *
     * @return the last name of the user
     */
    public String getLastName() {
        return last_name; //Returns the year the award was received in.
    }

    /**
     * Sets the user's last name.
     *
     * @param last_name the last name to assign
     */
    public void setLastName(String last_name) {
        this.last_name = last_name; //Sets the year.
    }

    /**
     * Gets the user's username.
     *
     * @return the login username
     */
    public String getUsername() {
        return user_name;//Returns the city where the recipient is from.
    }

    /**
     * Sets the user's username.
     *
     * @param user_name the login username to assign
     */
    public void setUsername(String user_name) {
        this.user_name = user_name;//Sets the city the recipient is from.
    }

    /**
     * Gets the user's email.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;//Returns the award category.
    }

    /**
     * Sets the user's email.
     *
     * @param email the email address to assign
     */
    public void setEmail(String email) {
        this.email = email;//Sets the category of the award.
    }

    /**
     * Gets the user's password.
     *
     * @return the password string
     */
    public String getPassword() {
        return password;//Returns the award category.
    }

    /**
     * Sets the user's password.
     *
     * @param password the password to assign
     */
    public void setPassword(String password) {
        this.password = password;//Sets the category of the award.
    }

    /**
     * User's role
     * 
     * @param role user's role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * 
     * @return user's role
     */
    public String getRole(){
        return role;
    }
}
