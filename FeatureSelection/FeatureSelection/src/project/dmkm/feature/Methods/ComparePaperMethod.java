package project.dmkm.feature.Methods;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import project.dmkm.features.objects.DAO.ArticlesAuthors;
import project.dmkm.features.objects.DAO.ArticlesSubjects;
import project.dmkm.features.objects.DAO.Cosinesim;
import project.dmkm.features.objects.DAO.Matrix;
import project.dmkm.stores.CosimMatrix;

public class ComparePaperMethod  implements Runnable{
	
	Session mysession = null;
	int Start = 0;
	int Range = 0;
	String name ="";
	public ComparePaperMethod(int Start, int Range)
	{
		this.name = String.valueOf(Start);
		mysession = new Configuration().configure().buildSessionFactory().openSession();
		this.Start = Start;
		this.Range = Range;
	}
	
	public float GetDispDistance(int p1, int p2)
	{
		try
		{
			List<String> dipP1 = GetPaperDisp(p1);
			List<String> dipP2 = GetPaperDisp(p2);
			Transaction tx = mysession.beginTransaction();
			System.out.println("");
			String sql = "select " + CosimMatrix.getReverseColumnName(dipP1.get(0).toUpperCase()) +  " from Cosinesim where name = :disp2";
			List employees = mysession.createQuery(sql).setParameter("disp2", dipP2.get(0)).list();	
			System.out.println(this.name);
			return Float.parseFloat(employees.get(0).toString());
		}
		catch(Exception e)
		{
			System.out.print("Error on " + ":" + p1 + ":"+ p2 +":"+ this.name );
			e.printStackTrace();
			return Float.parseFloat("-0.1");
		}
		
		
	
	}
	
	public List<String> GetPaperDisp(int p1)
	{
		List<String> displ = new ArrayList<String>();
		Transaction tx = mysession.beginTransaction();
		System.out.println("");
		String sql = "select distinct(subject) from ArticlesSubjects where id = :id";
		
		List employees = mysession.createQuery(sql).setParameter("id", p1).list();	
		System.out.println(employees.size());

		 
		return employees;
		   
	}
	 
	public void SaveResults(int Start, int Range)
	{
	
			
		
				for(int i=Start;i<Start+Range;i++)
				{
					Transaction tx = mysession.beginTransaction();
					System.out.println("");
					String sql = "From Matrix where id = :id";
					Matrix employees = (Matrix)mysession.createQuery(sql).setParameter("id", i).uniqueResult();
					if(employees !=null)
					{
						int p1,p2=0;
						try 
						{
							
							p1 = employees.getPaper1();
							p2 = employees.getPaper2();
						}
						catch(Exception e)
						{
							p2=8;
							p1=948;
						}
						float answer = GetDispDistance(p1,p2);
						employees.setDiscplinedistance(answer);
						tx.commit();
					}
				}
				
	
	}
	
	public float GetKeyWordDistance()
	{
		return Float.parseFloat("1");
	}

	@Override
	public void run() {
	
		SaveResults(this.Start,this.Range);
		
	}
}
