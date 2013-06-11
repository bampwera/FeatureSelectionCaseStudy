package project.dmkm.feature.Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import prefuse.data.Graph;
import project.dmkm.feature.Methods.NameMethods;
import project.dmkm.feature.visuals.GraphMethod;
import project.dmkm.features.objects.DAO.ArtInstitGet;
import project.dmkm.stores.StringArrayMap;

public class ArtInstitGetTest {

	Set<Set<String>> myresults = null;
	
	@Before
	public void Setup()
	{
		StringArrayMap	mymap = NameMethods.getAuthorAdjMatrix("daumas");
		mymap = StringArrayMap.ThresholdMatrix(0.3, mymap);
		Graph my = StringArrayMap.CreateGraph(mymap);
		myresults = GraphMethod.getConnectedComponents(my);
	}
	
	@Test
	public void testGetInsution() {
		assertEquals(2, ArtInstitGet.getInsution("0").size());
	}
	
	@Test
	public void getTopIns()
	{
		Map<String,Integer> map = null;
	    Map<String,Integer> finalmap = null;
		Set<String> myset = null;
		List<String> myList = new ArrayList<String>();
		for(int i=0;i<myresults.size();i++)
		{
			
				myset = (Set<String>) myresults.toArray()[i];
			
		}
			myList.addAll(myset);
			NameMethods.getAuthorName(myset, "daumas");
			map = ArtInstitGet.getFullInstution(myList);
			finalmap =  ArtInstitGet.thresHoldMap(map,(float) 0.7 );
			finalmap = ArtInstitGet.thresHoldMapInt(finalmap, 1);
		
		System.out.println("answers:" + finalmap);
		assertEquals(0, 1);
	}

}
