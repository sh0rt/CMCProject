import static org.junit.Assert.*;

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
		database.addUser(user1.getFirstName(), user1.getLastName(), user1.getUsername(), 
				user1.getPassword(), user1.getType());
		database.addUser(user2.getFirstName(), user2.getLastName(), user2.getUsername(), 
				user2.getPassword(), user2.getType());
		database.addUser(user3.getFirstName(), user3.getLastName(), user3.getUsername(), 
				user3.getPassword(), user3.getType());
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


}
