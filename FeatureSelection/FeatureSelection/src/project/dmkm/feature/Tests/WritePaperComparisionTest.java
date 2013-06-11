package project.dmkm.feature.Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import project.dmkm.feature.Methods.PaperMethod;
import project.dmkm.feature.Methods.WritePaperComparision;

public class WritePaperComparisionTest {

	PaperMethod mypaper = null;
	WritePaperComparision answers = null;
	
	@Before
	public void SetupTest()
	{
		answers = new WritePaperComparision("lancaster");
	}
	
	
	@Test
	public void testWritePaperComparision() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowPapers() {

		answers.ShowPapers();
		assertEquals("0","1");
	}
	
	@Test
	public void Size()
	{
		assertEquals(11,answers.Size());
	}

	@Test
	public void SavePapers()
	{
		assertEquals(0,answers.SavePaper());
	}
}
