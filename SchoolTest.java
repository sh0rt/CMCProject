import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SchoolTest {
	School school1;
	
	@Before
	public void setUp() throws Exception {
		school1 = new School(("University of Minnesota","Minnesota", "URBAN", "UNKNOWN", 500000, .45, 20,30,5000.0,.3,1000,.5,.3,4,3,5));
	}
	//-----------------------------------------------------------Test getters-------------------------------------------------------------
	@Test
	public void getState() {
		assertTrue("getState not working", school1.getState().equals("Minnesota"));
	}
	@Test
	public void getLocation() {
		assertTrue("getLocation not working", school1.getLocation().equals("URBAN"));
	}
	@Test
	public void getControl() {
		assertTrue("getControl not working", school1.getControl().equals("UNKNOWN"));
	}
	@Test
	public void getNumberOfStudents() {
		assertTrue("getNumberOfStudents not working", school1.getnumStudents().equals(500000));
	}
	@Test
	public void getPercentFemales() {
		assertTrue("getPercentFemales not working", school1.getPercentFemales().equals(.45));
	}
	@Test
	public void getSATVerbal() {
		assertTrue("getSatVerbal not working", school1.getSatVerbal().equals(20));
	}
	@Test
	public void getSatMath() {
		assertTrue("getSatMath not working", school1.getSatMath().equals(30));
	}
	@Test
	public void getExpenses() {
		assertTrue("getSatMath not working", school1.getExpenses().equals(5000.0));
	}
	@Test
	public void getPercentFinancialAid() {
		assertTrue("getPercentFinancialAid not working", school1.getPercentFinAid().equals(.3));
	}
	@Test
	public void getNumberOfAplicants() {
		assertTrue("getNumberOfApplicants not working", school1.getNumApplicants().equals(1000));
	}
	@Test
	public void getPercentAdmitted() {
		assertTrue("getPercentAdmitted not working", school1.getPercentAdmitted().equals(.5));
	}
	@Test
	public void getPercentEnrolled() {
		assertTrue("getPercentFinancialAid not working", school1.getPercentEnrolled().equals(.3));
	}
	@Test
	public void getAcademicScale() {
		assertTrue("getAcademicScale not working", school1.getAcademicScale().equals(4));
	}
	@Test
	public void getSocialScale() {
		assertTrue("getSocialScale not working", school1.getSocialScale().equals(3));
	}
	@Test
	public void getQualOfLifeScale() {
		assertTrue("getQualOfLifeScale not working", school1.getQualOfLife().equals(5));
	}
	//----------------------------------------------------------test setters---------------------------------------------------
	@test
	public void getQualOfLifeScale() {
		assertTrue("getQualOfLifeScale not working", school1.getQualOfLife().equals(5));
	}
}
