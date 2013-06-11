package project.dmkm.feature.Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import prefuse.data.Graph;
import project.dmkm.feature.Methods.NameMethods;
import project.dmkm.feature.Methods.PaperMethod;
import project.dmkm.feature.visuals.GraphMethod;
import project.dmkm.features.objects.DAO.ArtInstitGet;
import project.dmkm.stores.StringArrayMap;

public class NameMethodsTest {

	
	
	
	@Test
	public void testGetLastName() 
	{
		assertEquals("de brian", NameMethods.getLastName("De Brian AMPWERA"));
	}
	
	@Test
	public void testGetNameMethod()
	{
		StringArrayMap mymap = NameMethods.getAuthorAdjMatrix("zighed");
		assertEquals(0.746,mymap.getValue("137542", "140398"),0.0000);
	}
	
	@Test
	public void testThresholding()
	{
		StringArrayMap mymap = NameMethods.getAuthorAdjMatrix("zighed");
		mymap = StringArrayMap.ThresholdMatrix(0.4, mymap);
		assertEquals(1,mymap.getValue("137542", "140398"),0.0000);
	}
	
	@Test
	public void TestGetPapers()
	{
		List<List<String>> mylis= new ArrayList<List<String>>();
		StringArrayMap	mymap = NameMethods.getAuthorAdjMatrix("daumas");
		mymap = StringArrayMap.ThresholdMatrix(0.5, mymap);
		Graph my = StringArrayMap.CreateGraph(mymap);
		Set<Set<String>> myresults = GraphMethod.getConnectedComponents(my);
		int i = 0;
		List<String> gotoanswers = new ArrayList<String>();
		for(Set<String> first : myresults)
		{
			//if(i==1)
			//{
			List<String> paperstoget = new ArrayList<String>();
			paperstoget.addAll(first);
				//mylis.add(NameMethods.getAuthorName(first, "daumas"));
				System.out.println(ArtInstitGet.getFullInstution(paperstoget));
				System.out.println("End of Componenet");
				gotoanswers.addAll(first);
				//}
		//	i++;
		}
		//PaperMethod.getAllNames(gotoanswers, "zighed");
		
		
		assertEquals(2, PaperMethod.getAllNames(gotoanswers, "daumas").size());
	
	}
 
	@Test
	public void TestGetPaper2()
	{
		
		assertEquals(16, NameMethods.getAuthorPaperList("Millange F").size());
	}
	
	
}
