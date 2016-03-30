package csci230.dropdatabase;

/** UserHome
 * @authors Megan Pekarek, Cassie Meyer, Tyler Weiss, Conor Lorsung
 * @version March 15th, 2016
 */

import java.util.*;

/**
 * Constructor for User Home
 */
public class UserHome {

	private DataBaseHome database;

	/**
	 * Database of users
	 * 
	 * @param database
	 */
	public UserHome(DataBaseHome database) {
		super();
		this.database = database;
	}

	/**
	 * Logs user on with parameters
	 * 
	 * @param username,
	 *            password
	 * @return successful login
	 */
	public User login(String username, String password) {
		return database.login(username, password);
	}
}
