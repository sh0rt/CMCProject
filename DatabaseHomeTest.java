import static org.junit.Assert.*;
import java.util.*;
import org.junit.Before;
import org.junit.Test;
import de
public class DatabaseHomeTest {
	DataBaseHome database;
	User user1, user2, user3;
	School school1, school2, school3;
	
	@Before
	public void setUp() throws Exception {
		database = new DataBaseHome();
		user1 = new User("Tyler", "Weiss", "tnweiss", "weiss", 'a');
		user2 = new User("T-$", "Weiss", "ball", "isLife", 'a');
		user3 = new User("T-Buckets", "Weiss", "get", "money", 'a');
		/*
		database.addUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(), 
				user1.getPassword(), user1.getType());
		database.addUser(user2.getFirstName(), user2.getLastName(), user2.getUsername(), 
				user2.getPassword(), user2.getType());
		database.addUser(user3.getFirstName(), user3.getLastName(), user3.getUsername(), 
				user3.getPassword(), user3.getType());
				*/
		school1 = new School("Saint Johns University","Minnesota", "SMALL-CITY", "PRIVATE", 5000, .5, 20,30,5000.0,.3,1000,.5,.3,4,3,5);
		school2 = new School("University of Minnesota Duluth","Minnesota", "UNKNOWN", "STATE", 50000, .7, 20,30,5000.0,.3,1000,.5,.3,4,3,5);
		school3 = new School(("University of Minnesota","Minnesota", "URBAN", "UNKNOWN", 500000, .45, 20,30,5000.0,.3,1000,.5,.3,4,3,5));
	}
//----------------------------------------------------Login----------------------------------------------------------
	@Test
	public void testLoginSuccess() {
		assertTrue("Login returned the incorrect user.",database.login("tnweiss", "weiss").equals(user1));
	}
	@Test
	public void testIncorrectLoginUsername() {
		assertTrue("Login returned a user that is was not supposed to (incorrect username).",database.login("tweiss", "weiss").equals(null));
	}
	@Test
	public void testIncorrectLoginPassword() {
		assertTrue("Login returned a user that is was not supposed to (incorrect password).",database.login("tweiss", "eiss").equals(null));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyLoginUsername() {
		database.login("", "weiss");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyLoginPassword() {
		database.login("tweiss", "");
	}
//---------------------------------------------------addUser----------------------------------------------------------
	@Test
	public void testAddUser() {
		user1.setFirstName("t");
		assertTrue("DatabaseHome encountered an error changing users first name.",database.addUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(), 
				user1.getPassword(), user1.getType()).equals(user1));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddUserWithTypeNotAorS() {
		database.addUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(), 
				user1.getPassword(), 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddUserWithEmptyFirstname() {
		database.addUser("", user1.getLastName(), user1.getUsername(),user1.getPassword(), 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddUserWithEmptyLastname() {
		database.addUser(user1.getFirstName(), "", user1.getUsername(),user1.getPassword(), 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddUserWithEmptyUsername() {
		database.addUser(user1.getFirstName(), user1.getLastName(), "",user1.getPassword(), 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddUserWithEmptyPassword() {
		database.addUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(),"", 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddUserWithEmptyType() {
		database.addUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(),user1.getPassword(), '');
	}
	//-----------------------------------------------getUsers--------------------------------------------------------
	@Test
	public void testGetUsers() {
		assertTrue("getUsers encountered a problem (user1).", database.getUsers().get(0).equals(user1));
		assertTrue("getUsers encountered a problem (user2).", database.getUsers().get(1).equals(user2));
		assertTrue("getUsers encountered a problem (user3).", database.getUsers().get(2).equals(user3));
	}
	//-----------------------------------------------editUsers-------------------------------------------------------
	@Test
	public void testEditUser() {
		user1.setFirstName("t");
		assertTrue("DatabaseHome encountered an error editing user firstname",database.editUser("t", user1.getLastName(), user1.getUsername(), 
				user1.getPassword(), user1.getType()).equals(user1));
		user1.setLastName("t");
		assertTrue("DatabaseHome encountered an error editing user lastname.",database.editUser(user1.getFirstName(), "t", user1.getUsername(), 
				user1.getPassword(), user1.getType()).equals(user1));
		user1.setUsername("t");
		assertTrue("DatabaseHome encountered an error editing user username.",database.editUser(user1.getFirstName(), user1.getLastName(), " ", 
				user1.getPassword(), user1.getType()).equals(user1));
		user1.setPassword("t");
		assertTrue("DatabaseHome encountered an error editing user password.",database.editUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(), 
				"t", user1.getType()).equals(user1));
		user1.setType('s');
		assertTrue("DatabaseHome encountered an error editing user type.",database.editUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(), 
				user1.getPassword(), 's').equals(user1));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithTypeNotAorS() {
		database.editUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(), 
				user1.getPassword(), 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithEmptyFirstname() {
		database.editUser("", user1.getLastName(), user1.getUsername(),user1.getPassword(), 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithEmptyLastname() {
		database.editUser(user1.getFirstName(), "", user1.getUsername(),user1.getPassword(), 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithEmptyUsername() {
		database.editUser(user1.getFirstName(), user1.getLastName(), "",user1.getPassword(), 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithEmptyPassword() {
		database.editUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(),"", 'f');
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEditUserWithEmptyType() {

		database.editUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(),user1.getPassword(), '');
	}
	//----------------------------------------------deactivate user---------------------------------------------------
	@Test
	public void testDeactivateUser() {
		user2.setStatus('d');
		assertTrue("Deactivation error.", database.deactivateUser(0).equals(user2));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testDeactivateUserFailsForNegativeInteger() {
		database.deactivateUser(-1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testDeactivateUserFailsForIntegerOutOfRange() {
		database.deactivateUser(7);
	}
    //----------------------------------------------addSchool--------------------------------------------------------
	@Test
	public void testAddSchool(){
		assetTrue("add school failed",database.addSchool(s.getSchool(),school1.getState(state),school1.getLocation(location),
		school1.getControl(control),school1.getNumStudents(numberOfStudents),school1.getPercentFemale(percentFemales),
	    school1.getSatVerbal(SATVerbal),school1.getSatMath(SATMath),school1.getExpenses(expenses),
		school1.getPercentFinAid(percentFinancialAid),school1.getNumApplicants(numberOfApplicants),school1.getPercentAdmitted(percentAdmitted),
		school1.getPercentEnrolled(percentEnrolled),school1.getAcademicScale(academicsScale),school1.getSocialscale(socialScale),
		school1.getQualOfLife(qualityOfLifeScale)).equals(school1));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddSchoolWithEmpty{
		database.addSchool(s.getSchool(),school1.getState(state),school1.getLocation(location),
				school1.getControl(control),school1.getNumStudents(numberOfStudents),school1.getPercentFemale(percentFemales),
			    school1.getSatVerbal(SATVerbal),school1.getSatMath(SATMath),school1.getExpenses(expenses),
				school1.getPercentFinAid(percentFinancialAid),school1.getNumApplicants(numberOfApplicants),school1.getPercentAdmitted(percentAdmitted),
				school1.getPercentEnrolled(percentEnrolled),school1.getAcademicScale(academicsScale),school1.getSocialscale(socialScale),
				school1.getQualOfLife(qualityOfLifeScale));
	}
}
