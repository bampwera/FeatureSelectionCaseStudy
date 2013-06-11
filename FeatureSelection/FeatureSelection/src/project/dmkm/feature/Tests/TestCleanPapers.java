package project.dmkm.feature.Tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import project.dmkm.feature.Methods.NameMethods;

public class TestCleanPapers {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testCleaningMethod() {
		
		NameMethods.CleaningMethod(0, 10000);
		assertEquals("0","1");
	}

}
