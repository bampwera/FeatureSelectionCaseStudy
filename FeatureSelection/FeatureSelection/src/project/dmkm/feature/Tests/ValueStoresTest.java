package project.dmkm.feature.Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;

import prefuse.data.Graph;
import prefuse.demos.GraphView;
import project.dmkm.stores.StringArrayMap;

public class ValueStoresTest {
	
	
	public List<String> mylist = new ArrayList<String>();
	public StringArrayMap mytest;
	
	@Before
	public void setUpClass()
	{
		mylist.add("a");
		mylist.add("b");
		mylist.add("c");
		mylist.add("d");
		mytest = new StringArrayMap(mylist,"testclass");
		mytest.setValue("a", "b", 0);
		mytest.setValue("b", "a", 1);
		mytest.setValue("a", "a", 1);
		mytest.setValue("b", "b", 2);
		mytest.setValue("d", "c", 0.3);
	}
	

	@Test
	public void testGetName() {
		assertEquals("testclass",mytest.getName());
	}

	@Test
	public void testGetValue() {
		assertEquals(0.0,mytest.getValue("a", "b"),0.001);
		assertEquals(2.0,mytest.getValue("b", "b"),0.001);
		assertEquals(0.3,mytest.getValue("d", "c"),0.001);

	}

	@Test
	public void testSetValue() {
		Random myrand = new Random();
		int value = myrand.nextInt();
		mytest.setValue("a", "d", value);
		assertEquals(value, mytest.getValue("a", "d"),0.0001);
	}
	
	
	@Test
	public void testCheckHashTable()
	{
		assertEquals(0, mytest.CheckHashTable("a"));
	}
	@Test
	public void TestThreshold()
	{
	  assertEquals(1,StringArrayMap.ThresholdMatrix(2.00, mytest).getValue("b", "b"),0.00001);
		
	}

	@Test
	public void GraphTest()
	{
		Graph my = StringArrayMap.CreateGraph(mytest);
		JFrame frame = GraphView.demo(my, "label");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		assertEquals("","");
	}
}
