package project.dmkm.feature.Methods;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WriteComparionThreadManager implements Runnable  {
	
	
	private List<WritePaperComparision> queue= null;
	public WriteComparionThreadManager(List<String> names)
	{
		this.queue = new ArrayList<WritePaperComparision>();
		for(int i=0;i<names.size();i++)
		{
			WritePaperComparision b = new WritePaperComparision(names.get(i));
			queue.add(b);
		}
		
	}
	
	public void Start()
	{
		for(Iterator mythread=this.queue.iterator(); mythread.hasNext(); )
		{
			WritePaperComparision d = (WritePaperComparision)mythread.next();
			d.run();
			d=null;
		}
	}
	
	public boolean areAlive()
	{
		int count = this.queue.size();
		int dq=0;
		for(Iterator mythread=this.queue.iterator(); mythread.hasNext(); )
		{
			WritePaperComparision d = (WritePaperComparision)mythread.next();
			if(!(d.isAlive()))
			{
				dq++;
			}
		}
		if(dq==count)
		{
			this.queue = null;
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public void run() {
	
		
		Start();
		
	}

}
