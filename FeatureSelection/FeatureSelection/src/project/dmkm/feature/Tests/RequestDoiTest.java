package project.dmkm.feature.Tests;

import static org.junit.Assert.*;

import java.awt.print.Paper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import project.dmkm.features.requests.RequestDoi;
import project.dmkm.features.objects.DAO.Articles;

public class RequestDoiTest {
	
	private RequestDoi mydoi = new RequestDoi("10.3897/zookeys.69.739");
	File hconfig = new File("src/hibernate.cfg.xml");
	SessionFactory fact = new Configuration().configure().buildSessionFactory();
	Session mysession = fact.openSession();
;
    

	@Test
	public void testGetAuthors() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPage() {
		//assertEquals("A new relictual and highly troglomorphic species of Tomoceridae (Collembola) from a deep Croatian cave  - Pensoft",mydoi.getPageUrl());
	}
	
	@Test
	public void  testGetUrl() throws UnsupportedEncodingException
	{
		assertEquals("asdfasd",project.dmkm.features.objects.Paper.getXmlAuthors(mydoi.processZooKeys()));
	}
	@Test
	public void CombineDOIget()
	{
		for(int i= 0;i<100;i++)
		{
	
			Articles myarticle = (Articles) mysession.get(Articles.class, i);
			//System.out.println(myarticle.getDoi());
			assertEquals("1",myarticle.getDoi());
		}	
			
			//RequestDoi newdoi = new RequestDoi(myarticle.getDoi());
		
	}
	@Test
	public void FullList() throws InterruptedException, FileNotFoundException
	{
		
	}


}
