import static org.junit.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.*;

public class UserTest {
	
	User user1, user2, user3;
	ArrayList<School> schools = new ArrayList<School>(null);
	
	@Before
	public void setUp() throws Exception {
		user1 = new User("Conor", "Lorsung", "clorsung", "password", 'A', 'y');
		user2 = new User("TheOther", "C-Lo", "another", "one", 'U', 'n');
		user3 = new User("Jeff", "Bullhorn", "blankyboy", "password", 'A', 'y');
	}

	@Test
	public void testGetFirstName() {
		Assert.assertTrue("First name of user1 is Conor", user1.getFirstName().equals("Conor"));
		Assert.assertTrue("First name of user2 is TheOther", user2.getFirstName().equals("TheOther"));
		Assert.assertTrue("First name of user3 is Jeff", user3.getFirstName().equals("Jeff"));
	}
	
	@Test
	public void testSetVars() {
		Assert.assertTrue("First name of user1 is Conor", user1.getFirstName().equals("Conor"));
		user1.setVars("C-man", "Lorsung", "clorsung", "password", 'A', 'y');
		Assert.assertTrue("First name of user1 is C-man", user1.getFirstName().equals("C-man"));
	}
	
	@Test
	public void testGetType() {
		Assert.assertTrue("Type of user1 is A", user1.getType().equals('A'));
		Assert.assertTrue("Type of user2 is U", user2.getType().equals('U'));
		Assert.assertTrue("Type of user3 is A", user3.getType().equals('A'));
	}
	
	@Test
	public void testSetType() {
		Assert.assertTrue("Type of user1 is A", user1.getType().equals('A'));
		user1.setType('U');
		Assert.assertTrue("Type of user1 is U", user1.getType().equals('U'));
		user1.setType('A');
	}
	
	@Test
	public void testSetFirstName() {
		Assert.assertTrue("First name of user2 is TheOther", user2.getFirstName().equals("TheOther"));
		user2.setFirstName("TheOnly");
		Assert.assertTrue("First name of user2 is TheOnly", user2.getFirstName().equals("TheOnly"));
	}
	
	@Test
	public void testGetLastName() {
		Assert.assertTrue("Last name of user3 is Bullhorn", user3.getLastName().equals("Bullhorn"));
	}
	
	@Test
	public void testSetLastName() {
		Assert.assertTrue("Last name of user3 is Bullhorn", user3.getLastName().equals("Bullhorn"));
		user3.setLastName("Foghorn");
		Assert.assertTrue("Last name of user3 is Foghorn", user3.getLastName().equals("Foghorn"));
	}
	
	@Test
	public void testGetStatus() {
		Assert.assertTrue("Type of user3 is y", user3.getStatus().equals('y'));
		Assert.assertTrue("Type of user2 is n", user2.getStatus().equals('n'));
	}
	
	@Test
	public void testSetStatus() {
		Assert.assertTrue("Type of user2 is n", user2.setStatus().equals('n'));
		user2.setType('y');
		Assert.assertTrue("Type of user2 is y", user2.getStatus().equals('y'));
	}
	
	@Test
	public void testGetPassword() {
		Assert.assertTrue("Password for user1 is password", user1.getPassword().equals("password"));
	}
	
	@Test
	public void testSetPassword() {
		Assert.assertTrue("Password for user1 is password", user1.getPassword().equals("password"));
		user1.setPassword("drowssap");
		Assert.assertTrue("Password for user1 is drowssap", user1.getPassword().equals("drowssap"));
		user1.setPassword("password");
	}
	
	@Test
	public void testGetSchools() {} //???
	
	@Test
	public void testSetSchools() {} //???
	
	@Test
	public void testGetID() {
		Assert.assertTrue("user1 ID is 1", user1.getID().equals(1));
		Assert.assertTrue("user2 ID is 2", user2.getID().equals(2));
		Assert.assertTrue("user3 ID is 3", user3.getID().equals(3));
	}

}
