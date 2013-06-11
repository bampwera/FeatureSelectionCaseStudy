package project.dmkm.feature.Methods;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import project.dmkm.features.objects.DAO.ArticlesAuthors;

public class LastNameThreadMethod implements Runnable {
	

	private Session mysession;
	private int StartIndex;
	private int Stop;
	public LastNameThreadMethod(int StartInt, int Stop)
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		this.mysession= factory.openSession();
		this.StartIndex = StartInt;
		this.Stop = Stop;

	}

	@Override
	public void run() {
		
		try
		{ 
		   for (int i=this.StartIndex; i<this.Stop;i++)
		   {
			   Transaction tx = mysession.beginTransaction();
			   System.out.println("");
			   List employees = mysession.createQuery("FROM ArticlesAuthors where newid = :newid").setParameter("newid", i).list();	
			   for (Iterator iterator = 
	                           employees.iterator(); iterator.hasNext();){
	            ArticlesAuthors employee = (ArticlesAuthors) iterator.next(); 
	            employee.setLastname(NameMethods.getLastName(employee.getAuthor()));
	            System.out.print(employee.getAuthor() + ": " + NameMethods.getLastName(employee.getAuthor()) + " :"+ i); 
	            tx.commit();
			   }
			   tx = null;
		   }
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}

}
