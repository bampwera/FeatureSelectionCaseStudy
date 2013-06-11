package project.dmkm.feature.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import org.apache.lucene.search.spell.JaroWinklerDistance;
import org.apache.lucene.search.spell.LevensteinDistance;


public class DistanceTests {

	@Test
	public void test() {
		JaroWinklerDistance b = new JaroWinklerDistance();
		LevensteinDistance c = new LevensteinDistance();
	
		System.out.println("DA".hashCode()+ ":" + "D".hashCode() + ":" + "L".hashCode() );
		assertEquals(0.1,b.getDistance("DA", "L"), 0.000);
	
	}

}
