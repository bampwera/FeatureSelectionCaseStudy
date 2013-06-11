package project.dmkm.feature.Methods;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;

/*
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
*/

import prefuse.data.Graph;
import prefuse.demos.GraphView;
import prefuse.demos.RadialGraphView;
import project.dmkm.features.objects.DAO.*;
import project.dmkm.feature.Methods.LastNameThreadMethod;
import project.dmkm.feature.visuals.FeatureGraphBuilder;
import project.dmkm.feature.visuals.GraphMethod;
import project.dmkm.stores.StringArrayMap;

public class MainMethods 
{
	public static void main(String[] args)
	{
		   
		try
		{ 
			
			StringArrayMap	mymap = NameMethods.getAuthorAdjMatrix("lancaster");
			mymap = StringArrayMap.ThresholdMatrix(0.8, mymap);
			
			
			
			
			Graph my = StringArrayMap.CreateGraph(mymap);
			Set<Set<String>> myresults = GraphMethod.getConnectedComponents(my);
			System.out.println("Connected Components " + myresults.size());
			for(Set<String> comp : myresults)
			{
				printComponent(comp);
			}
			
			FeatureGraphBuilder myGraph = new FeatureGraphBuilder(my);
			JFrame frame = myGraph.getVisual();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			
			/*ThreadComparePaperMethod b = new ThreadComparePaperMethod(30033681, 30033695, 1);
			b.start();
			while(b.isAlive())
			{
				System.out.println("Sleeping ");
				Thread.sleep(1000);
				
			}
			/*
			ThreadMethod b = new ThreadMethod(363919, 663919);
			Thread first = new Thread(b);
			first.start();
			
			ThreadMethod c = new ThreadMethod(663919,963919);
			Thread second = new Thread(c);
			second.start();
			
			while(first.isAlive()|| second.isAlive())
			{
				System.out.println("Waiting");
				Thread.sleep(1000);
			}
			
			ThreadManager myManager = new ThreadManager(2328528, 2328540, 1);
			myManager.runAll();
			while(myManager.areAlive())
			{
				System.out.println("Running");
				Thread.sleep(1000);
			}
			
			*
				int start = 210880;
				ThreadManager myManager = null;
				List<String> myanswer = null;
				for(int i=0; i<1; i++)
				{
				
				int end = start+200;
				myanswer = PaperMethod.getAllLastName().subList(start,end);
				System.out.println("Working with sublist of size :" + myanswer.size() + myanswer.get(0));
				myManager = new ThreadManager(myanswer, 0, myanswer.size(), 5);
				myManager.runAll();
				while(myManager.areAlive())
				{
					System.out.println("Running");
					Thread.sleep(1000);
				}
				start = end;
				myManager = null;
				myanswer = null;
				System.gc();
				}
				*/
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		

		}
				
		
	}
	public static void printComponent(Set<String> g)
	{
		for(String str : g)
		{
			System.out.println(str);
			
		}
		System.out.println("End of Component");
	}
	
	
}
