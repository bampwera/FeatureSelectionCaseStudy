package project.dmkm.features.objects.DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.apache.lucene.search.spell.JaroWinklerDistance;


public class ArtInstitGet {

	// Building Instution List
	//select distinct(d1) from ArticlesInstitution where id =0
	// aggregate by each d2 and return List<String> with each Institute
	// Jaro Winkler Distance for names
	public static List<String> getInsution(String paperID)
	{
		List<String> fullreturnValues = new ArrayList<String>();
		List<Integer> returnvalues = new ArrayList<Integer>();
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		returnvalues = (List<Integer>) session.createQuery("select distinct(d1) from ArticlesInstitutions where id = :id ").setParameter("id", Integer.valueOf(paperID)).list();
	    
		for(Integer intd : returnvalues)
		{
		  List<String> instValues = (List<String>)	session.createQuery("select distinct(institution) from ArticlesInstitutions  where id = :id and d1 =:d1 ").setParameter("id", Integer.valueOf(paperID)).setParameter("d1", intd).list();
		  StringBuilder outstrings = new StringBuilder();
		  for(String par : instValues)
		  {
				//  System.out.println();
				  outstrings.append(" ");
				  outstrings.append(removeStopWords(par));  
		  }
		  //System.out.println(outstrings.toString());
		  fullreturnValues.add(outstrings.toString());
		}
		
		return fullreturnValues;
	}
	
	public static Map<String, Integer> getInstitueCount(List<String> insts)
	{
		HashMap<String, Integer> returnValue =  new HashMap<String, Integer>();
		for(String uni : insts)
		{
			if(returnValue.containsKey(uni))
			{
				returnValue.put(uni, returnValue.get(uni)+1);
			}
			else
			{
				returnValue.put(uni, 1);
			}
		}
		return returnValue;
	}
	
	public static <K extends Comparable,V extends Comparable> Map<K,V> sortByValues(Map<K,V> map){
	        List<Map.Entry<K,V>> entries = new LinkedList<Map.Entry<K,V>>(map.entrySet());
	      
	        Collections.sort(entries, new Comparator<Map.Entry<K,V>>() {

	            @Override
	            public int compare(Entry<K, V> o1, Entry<K, V> o2) {
	                return o1.getValue().compareTo(o2.getValue());
	            }
	        });
	      
	        //LinkedHashMap will keep the keys in the order they are inserted
	        //which is currently sorted on natural ordering
	        Map<K,V> sortedMap = new LinkedHashMap<K,V>();
	      
	        for(Map.Entry<K,V> entry: entries){
	            sortedMap.put(entry.getKey(), entry.getValue());
	        }
	      
	        return sortedMap;
	    }

	public static Map<String,Integer> getFullInstution(List<String> paperids )
	{
		List<String> Ints = new ArrayList<String>();
		for(String id :paperids)
		{
			for(String insta : getInsution(id))
			{
				if(!(Ints.contains(insta)))
				{
					Ints.add(insta);
				}
			}
		}
		return	thresHoldMap(getInstitueCount(Ints), Float.parseFloat("0.8"));
	}

	public static Map<String,Integer> thresHoldMap(Map<String,Integer> map, float f)
	{
		List<String> worklist = new ArrayList<String>();
		
		JaroWinklerDistance b = new JaroWinklerDistance();
		Map<String, Integer> returnValue = map;
		worklist.addAll(returnValue.keySet());
		for (String uni: worklist)
		{
			
			for(String bKey : returnValue.keySet())
			{
				
				
				if(b.getDistance(bKey, uni)>f)
				{
					returnValue.put(bKey,returnValue.get(bKey)+1);
					//System.out.println("Key" + bKey);
				}
				else
				{
					returnValue.put(uni, 1);
					//System.out.println("Key" + bKey);
				}
				
			}
		}
	
		return sortByValues(returnValue);
	}
	
	public static Map<String,Integer> thresHoldMapInt(Map<String,Integer> map, int f)
	{
		Map<String, Integer> returnValue= new HashMap<String, Integer>();
		for(Entry<String, Integer> ent : map.entrySet())
		{
		 if(map.get(ent.getKey())>1)
		 {
			 returnValue.put(ent.getKey(), ent.getValue());
		 }
		
		
		}
	
		return sortByValues(returnValue);
	}
	
	private static String removeStopWords(String par)
	{
		par.toLowerCase();
		String outstring = par.toLowerCase().replace("univ", "").replace("lab", "").replace("sch", "").replace("fac", "").replace("dept", "").replace("ctr","").replace("ecole", "").trim();
		return outstring;

		
	}

	public static List<String> getFullInstution2(List<String> paperids )
	{
		List<String> Ints = new ArrayList<String>();
		for(String id :paperids)
		{
			for(String insta : getInsution(id))
			{
				if(!(Ints.contains(insta)))
				{
					Ints.add(insta);
				}
			}
		}
		return	Ints;
	}

	public static String BuildName(Map<String, Integer> map)
	{
		StringBuilder name = new StringBuilder();
		for (Entry<String, Integer> ent : map.entrySet())
		{
			name.append(" ");
			name.append(ent.getKey());
		}
		return name.toString().trim();
	}


}
