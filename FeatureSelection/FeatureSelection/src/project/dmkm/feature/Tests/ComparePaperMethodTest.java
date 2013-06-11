package project.dmkm.feature.Tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import project.dmkm.feature.Methods.ComparePaperMethod;

public class ComparePaperMethodTest {

	ComparePaperMethod testObje = null;
	
	@Before
	public void test()
	{
		testObje = new ComparePaperMethod(2523344, 42230);
		//2417318
	}
	
	
	@Test
	public void testGetDispDistance() {
		assertEquals(0,testObje.GetDispDistance(0, 4),0.0001);
	}

	@Test
	public void testGetPaperDisp() {
		//List<String> myList = testObje.GetPaperDisp(10);
		//assertEquals("Zoology",myList.get(0));
	}

	@Test
	public void testGetKeyWordDistance() {
		fail("Not yet implemented");
	}
	
	@Test 
	public void PersistResults()
	{
		testObje.run();
		assertEquals("0","1");
	}

}
