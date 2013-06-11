package project.dmkm.feature.Methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import prefuse.data.Graph;
import project.dmkm.feature.visuals.GraphMethod;
import project.dmkm.features.objects.DAO.ArtInstitGet;
import project.dmkm.stores.StringArrayMap;

public class RunningExample {

	public static void main(String[] args)
	{
		/*
		 * OutPutVariable
		 */
		List<String> profileOfAuthors = new ArrayList<String>();
		String fullname = "";
		/*
		 * Data Cleaning Methods
		 * 
		 * Methods Cleans the lastname of the author as explained in the Paper
		 */
		fullname = NameMethods.getLastName(fullname);
		/*
		 * Get All Papers associated with the lastname
		 */
		List<String> papersoflast = new ArrayList<String>();
		PaperMethod Allpapers = new PaperMethod(fullname);
		papersoflast = Allpapers.firstRun();
		
		/*Create Matrix with Discipline Distance for author with  
		 */
		WritePaperComparision comparsionoflast = new WritePaperComparision(fullname);
		/* 
		 * Save the Matrix to the Databases
		 */
		comparsionoflast.SavePaper();
		/*
		 * Show the papers in the Comparison
		 */
		comparsionoflast.ShowPapers();
		/*
		 * write the results for the comparison for each paper
		 *
		 *
		 * @param Start (Integer to Declare where to start in the Matrix)
		 * @param End   (Integer to Declare where to stop in the Matrix)
		 */
		int start= 0;
		int end=100000;
		ComparePaperMethod paperMethodp = new ComparePaperMethod(start, end);
		paperMethodp.run();
		
		/* 
		 * Get the Adjacency matrix of the author
		 */
		StringArrayMap mapforlastname =  NameMethods.getAuthorAdjMatrix(fullname);
		mapforlastname = StringArrayMap.ThresholdMatrix(0.3, mapforlastname);
		/*
		 * Create the graph of the Author
		 */
		Graph graphforlastname = StringArrayMap.CreateGraph(mapforlastname);
		/*
		 * Get Connected Components for the Graph
		 */
		Set<Set<String>> connectedComp = GraphMethod.getConnectedComponents(graphforlastname) ;
		/*
		 * For Each Connected Components
		 */
		
		for(Set<String> component : connectedComp)
		{
			/*
			 * Get Top Institutes for each Connected Components
			 * 
			 * 
			 */
			Map<String,Integer> map = null;
			List<String> papers = new ArrayList<String>();
			papers.addAll(component);
			map = ArtInstitGet.getFullInstution(papers);
			/*
			 * Account for noise in institution using JaroWinkler Distance
			 * @param Distance (float)
			 */
			Float jaroDistance = new Float("0.7");
			map = ArtInstitGet.thresHoldMap(map, jaroDistance);
			/*
			 * Foreach the top two Institutions for the author
			 *  
			*/
			for(Entry<String, Integer> instustions : map.entrySet() )
			{
				List<String> papersbyinstitue = new ArrayList<String>();
				if(instustions.getValue()>1)
				{
					/*
					 * Get Name of Author annoated with the probality 
					 */
					papersbyinstitue = PaperMethod.getAllNames(papers, fullname);
				}
				profileOfAuthors.addAll(papersbyinstitue);
			}
		}
	}
	
	
}
