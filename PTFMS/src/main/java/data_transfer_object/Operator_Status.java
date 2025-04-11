package data_transfer_object;

/**
 * Operator_Status class is a Data Transfer Object (DTO) used to represent the
 * current operational status of a Transit Manager/Operator.
 *
 * @author Jennifer Goodchild 040683485
 */
public class Operator_Status {

    /**
     * Unique identifier for the operator status record.
     */
    private int status_id;
    /**
     * ID of the user (Transit Manager/ Operator) associated with this status.
     */
    private int user_id;
    /**
     * Type of status (e.g., "On Duty", "Break", "Off Duty").
     */
    private String status_type;
    /**
     * Timestamp of when the status was recorded (stored as a string).
     */
    private String timestamp;

    /**
     * Default constructor for Operator_Status}. Initializes an empty object
     * with default values.
     */
    public Operator_Status() {

    }

    /**
     * Constructor for an Operator_Status object with all fields initialized.
     *
     * @param status_id unique identifier for the status record
     * @param user_id ID of the associated Transit Manager/ Operator
     * @param status_type description of the operator's status
     * @param timestamp time the status was recorded
     */
    public Operator_Status(int status_id, int user_id, String status_type, String timestamp) {
        this.status_id = status_id;
        this.user_id = user_id;
        this.status_type = status_type;
        this.timestamp = timestamp;
    }

    /**
     * Gets the status ID.
     *
     * @return the unique identifier for this status record
     */
    public int getStatusID() {
        return status_id;
    }

    /**
     * Sets the status ID for the record.
     *
     * @param status_id the unique identifier for the record.
     */
    public void setStatusID(int status_id) {
        this.status_id = status_id;
    }

    /**
     * Gets the user ID associated with this status record.
     *
     * @return the user ID The user who created the record.
     */
    public int getUserID() {
        return user_id;
    }

    /**
     * Sets the user ID associated with this status record.
     *
     * @param user_id the user ID who created the record.
     */
    public void setUserID(int user_id) {
        this.user_id = user_id;
    }

    /**
     * Gets the type of the operator status.
     *
     * @return the status type (e.g., "On Duty", "Break", "Off Duty")
     */
    public String getStatusType() {
        return status_type;
    }

    /**
     * Sets the type of the operator status.
     *
     * @param status_type the updated status type
     */
    public void setStatusType(String status_type) {
        this.status_type = status_type;
    }

    /**
     * Gets the timestamp of the status record.
     *
     * @return the timestamp string
     */
    public String getTimeStamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp of the status record.
     *
     * @param timestamp the timestamp of the record.
     */
    public void setTimeStamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
