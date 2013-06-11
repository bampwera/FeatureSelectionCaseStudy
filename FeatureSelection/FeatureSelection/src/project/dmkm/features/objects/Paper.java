package project.dmkm.features.objects;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import org.apache.commons.lang3.*;


public class Paper 
{
	private int id;
	public List<Author> pAuthors;
	public List<Integer> citations;
	public String ptitle;
	public Paper()
	{
		this.citations = new ArrayList<Integer>();
		this.pAuthors =  new ArrayList<Author>();
		
	}
	public Paper(int id)
	{
	
	}
	public static Paper getXmlAuthors(byte[] bXmlInput) throws UnsupportedEncodingException
	{
		String XmlInput = new String(bXmlInput,"UTF-8");
		Paper returnvalue = new Paper();
		Map<String,String> MapLocations = new HashMap<String,String>();
		Map<String,String> MapAuthors = new HashMap<String,String>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
	    DocumentBuilder builder;  
	    try  
	    {  
	        builder = factory.newDocumentBuilder();  
	        Document document = builder.parse( new InputSource( new StringReader( XmlInput ) ) );  
	    
	        NodeList Locations = document.getElementsByTagName("locations");
	        NodeList Authors = document.getElementsByTagName("author");
	        for(int i=0;i<Locations.getLength();i++)
	        {
	        	MapLocations.put(Locations.item(i).getAttributes().getNamedItem("ref").getTextContent().trim(),Locations.item(i).getTextContent().trim());
	        }
	        for(int i =0;i<Authors.getLength();i++)
	        {
	        	String name = Authors.item(i).getTextContent().trim();
	        	String affid = Authors.item(i).getAttributes().getNamedItem("aff").getTextContent().trim();
	        	MapAuthors.put(affid,name);
	        	String LocationName = MapLocations.get(affid);
	        	Location toaddLocation = new Location(LocationName);
	        	Author toadd = new Author(name);
	        	toadd.homeUni.add(toaddLocation);
	        	returnvalue.pAuthors.add(toadd);
	        }
	     
	    } 
	    catch (Exception e)
	    {  
	        e.printStackTrace();  
	    }
		return returnvalue; 
		
		
	}
}

