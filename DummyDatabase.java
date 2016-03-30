package csci230.dropdatabase;
/**Dummy Database
 * @authors Megan Pekarek, Cassie Meyer, Tyler Weiss, Conor Lorsung
 * @version March 15th, 2016
 */

import java.util.ArrayList;
import java.util.Scanner;

public class DummyDatabase {
	String name, user, pass;
	private ArrayList<School> school;
	private ArrayList<User> users;
	private Scanner sc = new Scanner(System.in);

	/**
	 * Sets the values for all three instance fields to enable access to the
	 * specified database.
	 *
	 * @param database,
	 *            username, and password
	 * @throws java.lang.IllegalStateExpection
	 *             if driver can't load properly
	 */
	public DummyDatabase(String database, String username, String password) {
		users = new ArrayList<User>();
		school = new ArrayList<School>();
		this.name = database;
		this.user = username;
		this.pass = password;
	}
	// this is gitting tough

	/**
	 * Method creates a new university record using the information provided in
	 * the parameters. Must ensure that school name is unique among all
	 * universities, otherwise n changes occur and a-1 is returned.
	 *
	 * @param school,
	 *            state, location, control, numberOfStudents, percentFemales
	 *            SATverbal, SATMath, expenses, percentFinancialAid,
	 *            numberOfApplicants, percentAdmitted, percentEnrolled,
	 *            academicsScale, socialScale, and qualityOfLifeScale
	 * @return integer indicating number of university records inserted. -1 if
	 *         school name is NOT unique or if database error is encountered
	 */
	public int university_addUniversity(String school, String state, String location, String control, int numStudents,
			double percentFemale, int satVerbal, int satMath, double expenses, double percentFinAid, int numApplicants,
			double percentAdmitted, double percentEnrolled, int academicScale, int socialScale, int qualOfLife,
			String[] emphasis) {
		int returnValue = 0;
		School s = new School(school, state, location, control, numStudents, satVerbal, satMath, numApplicants,
				percentFemale, expenses, percentFinAid, percentAdmitted, percentEnrolled, academicScale, socialScale,
				qualOfLife, emphasis);

		this.school.add(s);

		return returnValue;
	}

	/**
	 * Method updates university record for the university whose name is
	 * specified as a parameter, using the information provided in the param.
	 * Method can update all university fields except school name and emphasis.
	 * 
	 * @param school,
	 *            state, location, control, numberOfStudents, percentFemales
	 *            SATverbal, SATMath, expenses, percentFinancialAid,
	 *            numberOfApplicants, percentAdmitted, percentEnrolled,
	 *            academicsScale, socialScale, and qualityOfLifeScale
	 * @return integer indicating number of university records affected by
	 *         update. -1 if database error is encountered
	 */
	public int university_editUniversity(java.lang.String school, java.lang.String state, java.lang.String location,
			java.lang.String control, int numberOfStudents, double percentFemales, double SATVerbal, double SATMath,
			double expenses, double percentFinancialAid, int numberOfApplicants, double percentAdmitted,
			double percentEnrolled, int academicsScale, int socialScale, int qualityOfLifeScale) {
		int returnValue = -1;

		for (int i = 0; i < this.school.size(); i++) {
			if (this.school.get(i).getSchool().equalsIgnoreCase(school)) {
				School s = this.school.get(i);
				s.setState(state);
				s.setLocation(location);
				s.setControl(control);
				s.setNumStudents(numberOfStudents);
				s.setPercentFemale(percentFemales);
				s.setSatVerbal(SATVerbal);
				s.setSatMath(SATMath);
				s.setExpenses(expenses);
				s.setPercentFinAid(percentFinancialAid);
				s.setNumApplicants(numberOfApplicants);
				s.setPercentAdmitted(percentAdmitted);
				s.setPercentEnrolled(percentEnrolled);
				s.setAcademicScale(academicsScale);
				s.setSocialscale(socialScale);
				s.setQualOfLife(qualityOfLifeScale);

				returnValue = 1;
			} else
				return returnValue;
		}

		return returnValue;
	}

	/**
	 * Method adds new emphasis area for the specified school. No changes occur
	 * if an invalid school name is specified, if emphasis already exists for
	 * specified school, or if database error is encountered.
	 * 
	 * @param school,emphasis
	 * @return integer indicating number of database records inserted by this
	 *         operation. -1 if an invalid school name is specified, if emphasis
	 *         already exists for specified school, or if database error is
	 *         encountered.
	 */
	public void university_addUniversityEmphasis(String school, String emphasis) {
		for (int i = 0; i < this.school.size(); i++) {
			if (this.school.get(i).getSchool().equalsIgnoreCase(school)) {
				School s = this.school.get(i);
				s.setEmphasis(emphasis);
			}
		}
	}

	/**
	 * @return 2-D array of Strings containing all possible university emphases
	 *         that occur in the database. Records in the array are sorted by
	 *         emphasis in ascending order.
	 */
	public String[][] university_getEmphasis() {
		String[][] s = new String[school.size()][6];
		for (int i = 0; i < school.size(); i++) {
			s[i] = school.get(i).getEmphasis();
		}
		return s;
	}

	/**
	 * Method that contains university names with emphases in database. Every
	 * array row contains a pair of Strings (university name, emphasis).
	 * 
	 * @return 2-D array of Strings containing all (university name, emphasis)
	 *         pairs in the database. Null returned if no universities have
	 *         emphases in database or if database error is encountered. Null
	 *         returned if no universities have emphases in the database or
	 *         error is encountered.
	 */
	public String[][] university_getNamesWithEmphasis() {
		return new String[5][6];
	}

	/**
	 * Method that contains all universities in the database. Every array row
	 * contains university record made up of a number of different fields
	 * 
	 * @return 2-D array of Strings containing all universities in the database
	 */
	public String[][] university_getUniversities() {
		String[][] s = new String[this.school.size()][17];

		for (int i = 0; i < school.size(); i++) {
			s[i][0] = school.get(i).getState();
			s[i][1] = school.get(i).getLocation();
			s[i][2] = school.get(i).getControl();
			s[i][3] = String.valueOf(school.get(i).getNumStudents());
			s[i][4] = String.valueOf(school.get(i).getPercentFemale());
			s[i][5] = String.valueOf(school.get(i).getSatVerbal());
			s[i][6] = String.valueOf(school.get(i).getSatMath());
			s[i][7] = String.valueOf(school.get(i).getExpenses());
			s[i][8] = String.valueOf(school.get(i).getPercentFinAid());
			s[i][9] = String.valueOf(school.get(i).getNumApplicants());
			s[i][10] = String.valueOf(school.get(i).getPercentAdmitted());
			s[i][11] = String.valueOf(school.get(i).getPercentEnrolled());
			s[i][12] = String.valueOf(school.get(i).getAcademicScale());
			s[i][13] = String.valueOf(school.get(i).getSocialscale());
			s[i][14] = String.valueOf(school.get(i).getQualOfLife());
			s[i][15] = school.get(i).getEmphasisString();
			s[i][16] = school.get(i).getSchool();

		}
		return s;
	}

	/**
	 * Method deletes the given emphasis area for the specified school from the
	 * database.
	 * 
	 * @param school,
	 *            emphasis
	 * @return integer indicating number of database records removed by this
	 *         operation. -1 if an invalid school name is specified, specified
	 *         emphasis doesn't exist for the specified school, or database
	 *         error is encountered
	 */
	public int university_removeUniversityEmphases(String school, String emphasis) {
		int i = 0;
		while (!(this.school.get(i)).getSchool().equals(school)) {
			i++;
		}
		this.school.get(i).removeEmphasis(emphasis);

		return i;
	}

	/**
	 * Method creates a new user record using the information provided in the
	 * parameters
	 * 
	 * @param firstName,
	 *            lastName, username, password, type
	 * @return integer indicating number of database records affected by the
	 *         updated operation. -1 if database error is encountered
	 */
	public int user_addUser(String firstName, String lastName, String username, String password, char type) {
		User u = new User(firstName, lastName, username, password, type, 'a');
		if (users.add(u))
			return 1;
		else
			return -1;

	}

	/**
	 * Method updates the record of the user, whose username is specified as a
	 * parameter, using the info provided in parameters
	 * 
	 * @param username,
	 *            firstName, lastName, password, type, status
	 * @return integer indicating number of database records affected by update.
	 *         -1 if database error is encountered
	 */
	public void user_editUser(String username, String firstName, String lastName, String password, char type,
			char status) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUsername().equals(username)) {
				User u = users.get(i);

				u.setFirstName(firstName);
				u.setLastName(lastName);
				u.setPassword(password);
			}
		}
	}

	/**
	 * Method containing all usernames along with their saved schools in
	 * database. Users with multiple saved schools will have their usernames
	 * repeat multiple times in the array with different school
	 * 
	 * @return 2-D array of Strings containing all (username, school) pairs in
	 *         the database. Null returned if no user have saved schools in the
	 *         database or if a database error is encountered.
	 */
	public String[][] user_getUsernamesWithSavedSchools() {
		return null;
	}

	/**
	 * Method containing all user records in the database. Records in the array
	 * are sorted by usernames in ascending order.
	 * 
	 * @return 2-D array of Strings containing all user records in database
	 */
	public String[][] user_getUsers() {
		String[][] ua = new String[users.size()][6];

		for (int i = 0; i < users.size(); i++) {
			ua[i][0] = users.get(i).getFirstName();
			ua[i][1] = users.get(i).getLastName();
			ua[i][2] = users.get(i).getUsername();
			ua[i][3] = users.get(i).getPassword();
			ua[i][4] = users.get(i).getType() + "";
			ua[i][5] = users.get(i).getStatus() + "";
		}

		return ua;
	}

	/**
	 * Method removes the specified school from the user's list of saved
	 * schools. No changes occur if specified invalid user or specified school
	 * is not already in user's list of saved schools.
	 * 
	 * @param user,
	 *            school
	 * @return integer indicating the number of schools removed due to tits
	 *         update operation. -1 if database error is encountered. @throws
	 */
	public int user_removeSchool(String user, String school) {
		int test = -1;

		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).equals(user)) {
				User u = users.get(i);
				for (int j = 0; j < this.school.size(); j++) {
					if (u.getSchools(1).remove(school)) {
						test = 1;
					}
				}
			}
		}
		return test;
	}

	/**
	 * Method containing all possible university emphases that occur in
	 * database. Every array row contains single field storing an existing
	 * emphasis. Duplicate emphases are eliminated. Sorted in ascending order.
	 * 
	 * @return 2-D array of Strings containing all possible university emphases
	 *         that occur in the database.
	 */
	public String[][] university_getEmphases() {
		String[][] temp = new String[school.size()][6];
		for (int i = 0; i < school.size(); i++) {
			temp[i] = school.get(i).getEmphasis();
		}
		return temp;
	}

	/**
	 * Method saves specified school to the user's list of saved schools and
	 * returns true.
	 * 
	 * @param user,
	 *            school
	 * @return integer indicating the number of schools inserted due to this
	 *         update operation. @throws
	 */
	public int user_saveSchool(String user, String school) {
		int test = -1;
		ArrayList<School> schools = new ArrayList<School>();
		for (int j = 0; j < users.size(); j++) {
			if (users.get(j).equals(user)) {
				User u = users.get(j);
				for (int i = 0; i < this.school.size(); i++) {
					if (this.school.get(i).equals(school)) {
						schools.add(this.school.get(i));
						test = 1;
					}
				}
			}
		}
		return test;
	}
}