package prefuse.demos;

import java.util.Iterator;
import java.util.Random;

import javax.swing.JFrame;

import prefuse.Constants;
import prefuse.data.Graph;
import prefuse.data.Node;
import prefuse.data.Schema;
import prefuse.util.GraphLib;
import prefuse.visual.AggregateItem;
import prefuse.visual.AggregateTable;
import prefuse.visual.VisualGraph;
import prefuse.visual.VisualItem;


public class MyDemo {

	
	public static void main(String [] args)
	{
		
		Graph my = new Graph();
		my.addColumn("id", Integer.class);
		my.addColumn("label", String.class,"");
		for(int i=0;i<100;i++)
		{
			 Node n = my.addNode();
			 n.set("id", i);
			 n.setString("label", String.valueOf(i));
			
		}
	
	
		Random myrand = new Random();
		
		for(int i=0;i<100;i++)
		{
			int first = myrand.nextInt(100);
			int second = myrand.nextInt(100);
			my.addEdge(first, second);
		}
		
		
		
		
	
		
		
		JFrame frame = GraphView.demo(my, "label");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	 public static Graph getNodes(int n) {
	        Graph g = new Graph();
	        g.getNodeTable().addColumns(LABEL_SCHEMA);
	        
	        for ( int i=0; i < n; i++ ) {
	            Node node = g.addNode();
	            node.setString(LABEL, String.valueOf(i));
	        }
	        return g;
	    }
	 public static final String LABEL = "label";
	    /** Node table schema used for generated Graphs */
	    public static final Schema LABEL_SCHEMA = new Schema();
	    static {
	        LABEL_SCHEMA.addColumn(LABEL, String.class, "");
	    }
}
