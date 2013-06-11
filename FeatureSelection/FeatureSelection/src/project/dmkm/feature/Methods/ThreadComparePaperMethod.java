package project.dmkm.feature.Methods;

import java.util.ArrayList;
import java.util.List;


public class ThreadComparePaperMethod {
	

	private int Start=0;
	List<Thread> queue = null;
	
	public ThreadComparePaperMethod(int StartInt, int EndInt, int NumberOfThread)
	{

		int Range = (EndInt-StartInt)/NumberOfThread;
		this.queue = new ArrayList<Thread>();
		for(int i=1;i<NumberOfThread+1;i++)
		{
			
			this.queue.add(new Thread(new ComparePaperMethod(i*Range, Range)));
			
		}

	}
	
	/**
	 * 
	 */
	public void start()
	{
	    for(Thread b : this.queue)
	    {
	    	
	    	b.run();
	    }
				
	}
	
	public boolean isAlive()
	{
		int count = 0;
		for(Thread b : this.queue)
	    {
	   
	    	if(!(b.isAlive()))
	    	{
	    		count++;
	    	}
	    }
		if(count==this.queue.size())
		{
			return false;
		}
		else
		{
			return true;
		}
	
	
		
	}

}



