package project.dmkm.stores;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import prefuse.data.Graph;
import prefuse.data.Node;
import project.dmkm.features.objects.DAO.Matrix;

public class StringArrayMap
{
	private String name;
	private HashMap<String,Integer> localmap;
	private List<String> localheaders;
	private double[][] intstore;
	public StringArrayMap(List<String> headers, String name)
	{
		this.localheaders=headers;
		int matrixsize = headers.size();
		this.name = name;
		this.intstore = new double[matrixsize][matrixsize];
		this.localmap = new HashMap<String, Integer>();
		for(int i=0;i<matrixsize;i++)
		{
			this.localmap.put(headers.get(i), i);
		}
	}
	
	public StringArrayMap(String LastName)
	{			
		//Load Graph from Matrix in database;		
	}
	
	public String getName()
	{
		return this.name;
	}
	public double getValue(String S1, String S2)
	{
		int i = localmap.get(S1);
		int j = localmap.get(S2);
		return intstore[i][j];
	}
	public void setValue(String S1, String S2, double value)
	{
		int i = localmap.get(S1);
		int j = localmap.get(S2);
		intstore[i][j] = value;
		
		
	}
	public int CheckHashTable(String S1)
	{
		return this.localmap.get(S1);
	}
	public static StringArrayMap ThresholdMatrix( double thresholdValue, StringArrayMap oldMap)
	{
		StringArrayMap outValue = oldMap;
		int sizeOfMatrix = oldMap.intstore.length;
		for(int Startx=0;Startx<sizeOfMatrix;Startx++)
		{
		
			for(int Starty=0;Starty<sizeOfMatrix;Starty++)
			{
				if(outValue.intstore[Startx][Starty]>=thresholdValue)
				{
					outValue.intstore[Startx][Starty] = 1;
				}
				else
				{
					outValue.intstore[Startx][Starty] = 0;
				}
			}
			
		}
		return outValue;
	}
	public void buildFromListMatrix(List<Matrix> inputMatrix)
	{
	  for (Matrix bs: inputMatrix)
	  {
		  setValue(bs.getPaper1().toString(),bs.getPaper2().toString(), Double.valueOf(String.valueOf(bs.getDiscplinedistance())));
	  }
	}
	public static Graph CreateGraph(StringArrayMap mymap)
	{
		Graph returnValue = new Graph();
		returnValue.addColumn("label", String.class);

		
		for(String str : mymap.localheaders)
		{
			 Node n = returnValue.addNode();
			 n.setString("label", str);
			// System.out.println(str);
		}
		
		int sizeOfMatrix = mymap.localheaders.size();
		for(int Startx=0;Startx<sizeOfMatrix;Startx++)
		{
		
			for(int Starty=0;Starty<sizeOfMatrix;Starty++)
			{
				if(mymap.intstore[Startx][Starty]==1)
				{
					returnValue.addEdge(Startx, Starty);
					returnValue.addEdge(Starty, Startx);
					//System.out.println(Startx + ":" + Starty);
				}
				
			}
			
		}
	
		return returnValue;
	}
	


}
