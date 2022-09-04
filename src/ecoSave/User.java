package ecoSave;

/**
*
* @author Shahryar Panjwani
* #B1400290
*/

public abstract class User {
	
	/**
	* Initalizing Variables and array list
	*/
	
	private String username;
    private String password;
    private String fullname;
    private double totalpoints;

    public User(String username, String password, String fullname, double totalpoints) {
        setUsername(username);
        setPassword(password);
        setFullname(fullname);
        setTotalpoints(totalpoints);
    }
    
    public User() {
        this("not set", "not set", "not set", 0);
    }
    
    /**
     * @return the username
     */
    /*Getters and Setters*/
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
    public double getTotalpoints() {
        return totalpoints;
    }

    
    public void setTotalpoints(double totalpoints) {
        this.totalpoints = totalpoints;
    }
    
    public String toString() {
        return getUsername() + " (" + getPassword() + ") : " + getFullname() + " (" + getTotalpoints() + " )"; /*toString method showing all data in array list format*/
    }
}
