import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentHomeTest {

	User u;
	DatabaseHome database;

	@Before
	public void setUp() throws Exception {
		u = new User("Conor", "Lorsung", "clorsung", "password", 'A', 'y');
		StudentHome sh = new StudentHome(u, database);
	}

	@Test
	public void testGetUser() {
		Assert.assertTrue("User is u", sh.getUser().equals(u));
	}

	@Test
	public void testEditProfile() {
		sh.editProfile("C-Man", "LastName", "hardPass");
		Assert.assertTrue("u first name is C-Man", u.getFirstName().equals("C-Man"));
		Assert.assertTrue("u last name is LastName", u.getLastName().equals("LastName"));
		Assert.assertTrue("u password is hardPass", u.getPassword().equals("hardPass"));
	}

	@Test
	public void testGetSavedSchools() {
		sh.addSchool("SJU");
		Assert.assertTrue("u saved schools is SJU", sh.getSavedSchools().equals("SJU"));
	}

	@Test
	public void testRemoveSchool() {
		//???
	}

	@Test
	public void testAddSchool() {
		sh.addSchool("SJU");
		//???
	}

	@Test
	public void testSearch() {
		//???
	}

	@Test
	public void testGetRecommend() {
		//???
	}

	@Test
	public void testGetSearch() {
		//???
	}

	@Test
	public void testGetSearchID() {
		//???
	}

}
