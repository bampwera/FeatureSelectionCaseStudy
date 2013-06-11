package project.dmkm.feature.Methods;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import project.dmkm.features.objects.DAO.Matrix;

public class WritePaperComparision implements Runnable {
	
	
	int Count = 0;
	int PapersSize =0;
	private List<String> papers = null;
	private PaperMethod paperstoget = null; 
	public Session mysession = null;
	public WritePaperComparision(String LastName)
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		this.paperstoget = new PaperMethod(LastName);
		this.mysession = factory.openSession();
		this.papers = this.paperstoget.firstRun();
		this.PapersSize = this.papers.size();
		factory = null;
	}
	
	public void Finish()
	{
		this.paperstoget = null;
		this.mysession = null;
		this.papers = null;
	}
	
	public void ShowPapers()
	{
		int PapersSize = this.papers.size();
		for(int i=0;i<PapersSize;i++)
		{
			for(int j=0;j<PapersSize;j++)
			{
				if(j!=i)
				{
					System.out.println(this.papers.get(i) + ":" + this.papers.get(j));
				}
			}
		}
	}
	
	
	public int SavePaper()
	{
		try
		{
			Transaction tx = mysession.beginTransaction();
			if(PapersSize<1000)
			{
				System.out.println("");
				for(int i=0;i<PapersSize;i++)
				{
					for(int j=0;j<PapersSize;j++)
					{
						if(j!=i)
						{
							Matrix toadd = new Matrix(Integer.parseInt(this.papers.get(i).toString()), Integer.parseInt(this.papers.get(j).toString()), Float.parseFloat("0"),paperstoget.getNameOfAuthor());
							Count++;
							mysession.save(toadd);
							toadd = null;
						}
					}
				}
			 tx.commit();
			 mysession.close();
			 mysession =null;
			 Finish();
			}
			else
			{
				System.out.println(this.paperstoget.getNameOfAuthor() + "Not Written Fear of Memory Size");
			}
			 tx = null;
			return 1;
			
			
		}
		catch(Exception e)
		{
			return 0;
		}
	}
	
	public int Size()
	{
		return this.papers.size();
	}

	@Override
	public void run() {
		
		SavePaper();
		
	}
	
	public boolean isAlive()
	{
		int goal = (PapersSize * PapersSize)-PapersSize;
		if(Count==goal)
		{
			
			Finish();
			return false;
		}
		else
		{
			return true;
		}
		
	}
}
