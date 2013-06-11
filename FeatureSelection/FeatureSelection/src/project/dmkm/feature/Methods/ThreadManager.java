package project.dmkm.feature.Methods;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThreadManager {
	
	private List<Thread> ThreadQue = new ArrayList<Thread>();
	public ThreadManager(int Start, int End, int ThreadNumbers)
	{
		int Range = End - Start;
		int Allocation = Range/ThreadNumbers;
		for (int i=0;i<ThreadNumbers; i++)
		{
			LastNameThreadMethod b = new LastNameThreadMethod(Start+(i*Allocation), Start+(i+1)*Allocation);
			this.ThreadQue.add(new Thread(b));
		}
		
	}
	public ThreadManager(List<String> names, int Start, int End, int ThreadNumbers)
	{
		int Range = End - Start;
		int Allocation = Range/ThreadNumbers;
		for (int i=0;i<ThreadNumbers; i++)
		{
			List<String> namestoprocess = names.subList(Start+(i*Allocation), Start+(i+1)*Allocation);
			WriteComparionThreadManager b = new WriteComparionThreadManager(namestoprocess);
			this.ThreadQue.add(new Thread(b));
			namestoprocess = null;
			b=null;
		}
	}

	public void runAll()
	{
		for(Iterator mythread=this.ThreadQue.iterator(); mythread.hasNext(); )
		{
			Thread d = (Thread)mythread.next();
			d.start();
			d= null;
		}
	}

	public boolean areAlive()
	{
		int count = this.ThreadQue.size();
		int dq=0;
		for(Iterator mythread=this.ThreadQue.iterator(); mythread.hasNext(); )
		{
			Thread d = (Thread)mythread.next();
			if(!(d.isAlive()))
			{
				dq++;
			}
			d = null;
		}
		if(dq==count)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	

}
