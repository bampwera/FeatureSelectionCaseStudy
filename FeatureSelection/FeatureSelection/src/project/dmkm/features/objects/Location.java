package project.dmkm.features.objects;

import java.util.List;

public class Location {
	
	private float Lat;
	private float Long;
	private String City;
	private String Uni;
	public String FullName;
	private List<String> Others;
	public Location()
	{
		
	}
	public Location(String name)
	{
		this.FullName = name;
	}
	


}
