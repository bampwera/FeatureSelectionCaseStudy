package project.dmkm.feature.Tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import project.dmkm.feature.Methods.PaperMethod;
import project.dmkm.feature.Methods.WritePaperComparision;

public class PaperMethodsTest {
	PaperMethod mypaper = null;
	WritePaperComparision answer = null;
	
	@Before
	public void SetupClass()
	{
		mypaper = new PaperMethod("lukic");
	}
	
	
	@Test
	public void testRun() {
	  List<String> answers =	mypaper.firstRun();
	  System.out.println("Count is " + answers.size());
	  assertEquals("0", answers.get(0));
	}

	@Test
	public void testFirstRun() {
		fail("Not yet implemented");
	}
	
	@Test
	public void TestComparision()
	{
		assertEquals("0","1");
	}
	
	@Test
	public void TestGetallLastNames()
	{
		List<String> myanswer = PaperMethod.getAllLastName();
		assertEquals(235198, myanswer.size());
		assertEquals("lukic", myanswer.subList(0, 120));
	}

}
