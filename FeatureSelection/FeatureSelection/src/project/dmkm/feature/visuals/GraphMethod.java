package project.dmkm.feature.visuals;


import java.util.Iterator;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import edu.uci.ics.jung.algorithms.cluster.WeakComponentClusterer;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.event.GraphEvent.Edge;

import prefuse.data.Node;
import prefuse.data.Table;
import prefuse.data.Tuple;
import prefuse.data.tuple.TupleSet;

public class GraphMethod {

	public GraphMethod()
	{
		
	}
	
	public static Set<Set<String>> getConnectedComponents(prefuse.data.Graph g)
	{
	  TupleSet b = g.getNodes();
	  Graph<String, Integer> g1 = new SparseMultigraph<>();
	  Iterator i = b.tuples();
	  int TupleMonitor = 0;
	while(i.hasNext()&&TupleMonitor<(b.getTupleCount()-1))
	{
		
		 Tuple n = (Tuple)i.next();
		 g1.addVertex((String) n.get("label"));
		 TupleMonitor++;
	}
	 
	
	TupleSet c = g.getEdges();
	Iterator j = c.tuples();
	int hg = 0;
	System.out.println(c.getTupleCount());
	
	  while(j.hasNext()&&hg<(c.getTupleCount()-1))
	  {
		 Tuple e = (Tuple)j.next();
		 System.out.println((g.getNode(Integer.valueOf(String.valueOf(e.get("source"))))).get("label") + ":"+(g.getNode(Integer.valueOf(String.valueOf(e.get("target"))))).get("label"));
		 g1.addEdge(hg, String.valueOf(g.getNode(Integer.valueOf(String.valueOf(e.get("source")))).get("label")),  String.valueOf(g.getNode(Integer.valueOf(String.valueOf(e.get("target")))).get("label")));
		 hg++;
	  }
	   
	  WeakComponentClusterer<String, Integer> results = new WeakComponentClusterer<String, Integer>();
	  return results.transform(g1);
	}
	
}
