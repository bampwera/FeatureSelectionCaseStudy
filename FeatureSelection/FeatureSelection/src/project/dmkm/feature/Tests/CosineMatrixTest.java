package project.dmkm.feature.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import project.dmkm.stores.CosimMatrix;

public class CosineMatrixTest {

	@Test
	public void testGetColumnName() {
		assertEquals("BIOTECHNOLOGY & APPLIED MICROBIOLOGY", CosimMatrix.getColumnName("a21"));
	}

	@Test
	public void testGetReverseColumnName() {
		assertEquals("a21", CosimMatrix.getReverseColumnName("Zoology"));
	}
}
