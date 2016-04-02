import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserHomeTest {

	DataBaseHome db;

	@Before
	public void setUp() throws Exception {
		UserHome uh = new UserHome(db);
	}

	@Test
	public void testLogin() {
		Assert.assertTrue("user is logged in", UserHome.login("ImadUser", "Edited"));
	}
}
