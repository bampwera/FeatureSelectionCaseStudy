package project.dmkm.feature.Methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import project.dmkm.features.objects.DAO.ArtInstitGet;
import project.dmkm.features.objects.DAO.ArticlesAuthors;
import project.dmkm.features.objects.DAO.ArticlesInstitutions;
import project.dmkm.features.objects.DAO.Cleaninst;
import project.dmkm.features.objects.DAO.Matrix;
import project.dmkm.stores.StringArrayMap;

public class NameMethods {
	
	public static String getLastName(String FullName)
	{
	    List<String> fullname = new ArrayList<String>(Arrays.asList(FullName.split("\\s+")));
	    if(fullname.size()> 1)
	    {
	    	fullname.remove(fullname.size()-1);
	    	return fullname.toString().replace(" ", "").replace("[", "").replace("]", "").toLowerCase().replace(",", " ");
	    }
	    else
	    {
	    	System.out.println("Error Name here "+ FullName);	
	    	return FullName;
	    }
	}
	
	public static List<String> getAuthorPaperList(String FullName)
	{
		List<String> returnValue =  new ArrayList<String>();
		Session mysesion = new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = mysesion.beginTransaction(); 
		List<ArticlesAuthors> pList =	mysesion.createQuery("FROM ArticlesAuthors where author = :author").setParameter("author", FullName).list();
		for(ArticlesAuthors b  : pList)
		{
			returnValue.add(String.valueOf(b.getId()));
		}
		return returnValue;
	}
	    
	public static StringArrayMap getAuthorAdjMatrix(String Lastname)
	{
		Session mysession = new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = mysession.beginTransaction();
		List<Matrix> papers = (List<Matrix>) mysession.createQuery("FROM Matrix where author = :name").setParameter("name", Lastname).list();
		StringArrayMap returnValue = new StringArrayMap(PaperMethod.getAuthorPapers(Lastname),Lastname);
		returnValue.buildFromListMatrix(papers);
		return returnValue;
		
	}


	public static List<String> getAuthorName(Set<String> papers, String Author)
	{
		Session mysession = new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = mysession.beginTransaction();
		List<String> paperhandler = new ArrayList<String>();
		paperhandler.addAll(papers);
		List<String> returnValue = new ArrayList<String>();
		for(String paper : papers)
		{
		  	List<ArticlesAuthors> Listauthor = (List<ArticlesAuthors>)mysession.createQuery("FROM ArticlesAuthors where id = :id and lastname = :lastname").
		  			setParameter("id",Integer.valueOf(paper)).setParameter("lastname", Author).list();
		  
		  	returnValue.add(Listauthor.get(0).getAuthor());
		   System.out.println(Listauthor.get(0).getAuthor());
		}
			
		return returnValue;
	}
	
	public static  void CleaningMethod(int Start,  int End)
	{
		Session mysession = new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = mysession.beginTransaction();
		for(int i = Start;i<End+1;i++)
		{
			List<String> paperids = new ArrayList<String>();
			paperids.add(String.valueOf(i));
			List<String> other = ArtInstitGet.getInsution(String.valueOf(i));
			System.out.println(other.size());
			for(String st: other)
			{
				//System.out.println(i + ":" + st);
				write(i, st);
			}
		}
	}
	 public static void write(int f,String str)
	 {
		
		 		
		  		try
		  		{ 
		  			Session mysession = new Configuration().configure().buildSessionFactory().openSession();
			 		Transaction tx = mysession.beginTransaction();
		  			Cleaninst myinst = new Cleaninst();
		  			myinst.setNameOfInst(str);
		  			myinst.setPaper(f);
		  			mysession.save(myinst);
		  			tx.commit();
		  		}
		  		catch(Exception e)
		  		{
		  			Session mysession = new Configuration().configure().buildSessionFactory().openSession();
			 		Transaction tx = mysession.beginTransaction();
		  			Cleaninst myinst = new Cleaninst();
			  		myinst.setPaper(f);
		  			myinst.setNameOfInst("error");
		  			mysession.save(myinst);
		  			tx.commit();
		  		}
		  		//mysession.flush();
		  		
		  	
	 }
	

	
	
}
