package project.dmkm.features.requests;

import project.dmkm.features.objects.*;
import project.dmkm.features.objects.DAO.*;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.apache.commons.lang3.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.io.StringWriter;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


public class RequestDoi {
	
	public Paper _papername;
	private String _doi;
	private Document doc;
	public RequestDoi(String doi)
	{
		try
		{
			this._doi = doi;
			doc = Jsoup.connect("http://dx.doi.org/").data("hdl",_doi).post();
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String getAuthors()
	{
		
		return "Not Yet Implemented";
	}
	
	public String processPage()
	{
		Pattern my = Pattern.compile("://(.*).(com|edu)");
		Matcher p = my.matcher(getPageUrl());
		return p.group();
		
	
		
	}
	
	public String getPageUrl()
	{
		try 
		{
			Element link = doc.select("a").first();
			String outstring = link.absUrl("abs:href");
			return outstring;
		} 
		catch (Exception e) {
		
			e.printStackTrace();
			return ("Failed with " + e.getMessage() );
		}
		
		
	}
	
	public byte[] processZooKeys()
	{
		try
		{
			String outstring ="";
			Elements title = doc.select("a:contains(XML)");
			for(Element name : title)
			{
			  outstring = "http://www.pensoft.net/" + name.attr("href");
			}
		    Source fis = new StreamSource("Transforms\\pensoft.xsl");
		    Transformer myxsl = TransformerFactory.newInstance().newTransformer(fis);
		    Document XML = Jsoup.connect(outstring).get();
		    //XML.outputSettings().escapeMode(EscapeMode.extended);
		    XML.outputSettings().charset("UTF-8");
		    String mystring = " xmlns:mml=\"http://www.w3.org/1998/Math/MathML\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:tp=\"http://www.plazi.org/taxpub\">";
	        String inputstring = StringEscapeUtils.unescapeHtml4(XML.getElementsByTag("article-meta").outerHtml());
		    String wraps = "<article" + mystring + ">";
	        String finalstring = wraps + inputstring + "</article>";
		    Source insource = new StreamSource(new StringReader(finalstring));//));
		    StringWriter SwResult = new StringWriter();
		    StreamResult result = new StreamResult(SwResult);
		    myxsl.transform(insource, result);
		
		    /*String authors = XML.getElementsByTag("contrib").outerHtml().replace('&','\0');
			String locations = XML.getElementsByTag("aff").outerHtml();
			
		/*	XML = XML.substring(XML.indexOf('\n')+1);
			XPath xpath = XPathFactory.newInstance().newXPath();
		
	       String returnvalue = xpath.evaluate("//contrib", new InputSource(new StringReader(XML)));
	     */
			return SwResult.toString().getBytes("UTF-8");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ("Failed with : " + e.getMessage()).getBytes();
		}
	}

	
	public void getAllKey() throws InterruptedException, FileNotFoundException
	{
		File myfile = new File("D:\\FeatureSelection\\links.csv");
		PrintStream outfile = new PrintStream(new FileOutputStream(myfile));
		Session mysession = new Configuration().configure().buildSessionFactory().openSession();
	    List<Articles> listA =	mysession.createCriteria(Articles.class).list();
		for(int i=0;i<listA.size();i++)
		{
			String b = listA.get(i).getDoi();
			if(b.length()>3)
			{
				RequestDoi myrequest = new RequestDoi(b);
				System.setOut(outfile);
				System.out.println(i+','+b+','+myrequest.getPageUrl());
				
			}
		}
	}
	

}
