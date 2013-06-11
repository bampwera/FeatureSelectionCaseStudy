package project.dmkm.feature.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import project.dmkm.feature.Methods.MainMethods;

public class MainTest {

	@Test
	public void testMain() {
		MainMethods.main(null);
		assertEquals(0,1);
	}

}
