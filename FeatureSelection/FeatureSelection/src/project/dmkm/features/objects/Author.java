package project.dmkm.features.objects;

import java.util.ArrayList;
import java.util.List;

public class Author 
{

	public String Name;
	public String EmailAddress;
	public String Website;
	public List<Location> homeUni;
	public Author()
	{
		
	}
	public Author(String gName)
	{
		this.Name = gName;
		this.homeUni = new ArrayList<Location>();
	}
	
	
	
}
