package project.dmkm.feature.Methods;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import project.dmkm.features.objects.DAO.ArticlesAuthors;

public class PaperMethod implements Runnable {
	
	private Session mysession;
	private String authorLastName;
	public PaperMethod(String LastName)
	{	
		this.mysession = new Configuration().configure().buildSessionFactory().openSession();
		this.authorLastName = LastName;
	}
	
	public static List<String> getAuthorPapers(String LastName)
	{
		PaperMethod mypaper = new PaperMethod(LastName);
		return mypaper.firstRun();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public List<String> firstRun()
	{
			List<String> returnValue = new ArrayList<String>();
			Transaction tx = mysession.beginTransaction();
			  System.out.println("");
			   List employees = mysession.createQuery("FROM ArticlesAuthors where  lastname = :lastname").setParameter("lastname", authorLastName).list();	
			   for (Iterator iterator = 
	                         employees.iterator(); iterator.hasNext();){
	          ArticlesAuthors employee = (ArticlesAuthors) iterator.next(); 
	          System.out.println(employee.getId());
	          returnValue.add(employee.getId().toString());
			  }
			 return returnValue;
	}
	
	public String getNameOfAuthor()
	{
		return this.authorLastName;
	}
	
	public static List<String> getAllLastName()
	{
		Session mysession = new Configuration().configure().buildSessionFactory().openSession();
		List<String> returnValue = new ArrayList<String>();
		Transaction tx = mysession.beginTransaction();
		String myquery = "select distinct(lastname) from ArticlesAuthors";
		
		  System.out.println("");
		   List employees = mysession.createQuery(myquery).list();	
		   for(int i=0; i < employees.size(); i++)
		   {
			   System.out.println(employees.get(i));
			   returnValue.add(employees.get(i).toString());
		   }
		 return returnValue;
	}


	public static List<String> getAllNames(List<String> papers, String Lastname)
	{
		Session mysession = new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = mysession.beginTransaction();
		
		List<String> returnValue = new ArrayList<String>();
		for(String paper : papers)
		{
		  	List<ArticlesAuthors> namevalues = mysession.createQuery("FROM ArticlesAuthors where  lastname = :lastname and id = :id").setParameter("lastname", Lastname)
		  	.setParameter("id", Integer.parseInt(paper)).list();
		  	for(ArticlesAuthors b : namevalues)
		  	{
		  		String toadd = b.getAuthor();
		  		if(!(returnValue.contains(toadd)))
		  		{
		  			Float probality = Float.parseFloat(Integer.toString(returnValue.size()))/Float.parseFloat(Integer.toString(papers.size()));
		  			returnValue.add(toadd + "(" + probality + ")" );
		  		}
		  	}
		}
		return returnValue;
	}
}
