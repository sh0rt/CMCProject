package csci230.dropdatabase;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserInterfaceTest {
	UserInterface user;
	String username, password;
	
	@Before
	public void setUp() throws Exception {
		user = new UserInterface();
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUserInterface() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogin() {
		String validUser = juser;
		String validPass = user;
		String expResult = user.login(validUser,user);
		fail("Not yet implemented");
	}

}
