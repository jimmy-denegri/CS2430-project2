package classes;

import java.util.*;

public class Bag {

    private UniversalSet u;                     
    private Map<String, Integer> counts;        

    // Constructor
   public Bag(UniversalSet u) {
		this.u = u;
		this.counts = new HashMap<>();
    }

    // Constructor: from map of counts
    public Bag(UniversalSet u, Map<String, Integer> initialCounts) 
    {
        counts = new HashMap(initialCounts);
        this.u = u;
    }

    // Get count of element
    public int getCount(String elementName) 
    {
        // if elementName is not in the map, return 0
        return counts.getOrDefault(elementName, 0);
    }

    // Set count of element
    public void setCount(String elementName, int count) 
    {
        if (!u.contains(elementName))
			throw new IllegalArgumentException("Element is not in universal set");

        if (count < 0)
			throw new IllegalArgumentException("Count cannot be negative");
        
        
        counts.put(elementName, count);
    }

    // Multiset Union 
    public Bag mUnion(Bag other) {
        // TODO: implement
        return null;
    }

    // Multiset Intersection 
    public Bag mIntersection(Bag other) {
        // TODO: implement
        return null;
    }

    // Multiset Difference
    public Bag mDifference(Bag other) 
    {
        List<String> uniElements = u.getElements(); // list of all elements in the universal set
        Map<String, Integer> tempMap = new HashMap<>(); // hashMap that will contain all of the elements and their counts
        int temp; // temporary int for use in math
        
        for(String element: uniElements) // for each possible element in the universal set
        {
            temp = getCount(element) - other.getCount(element); // subtract the count for the current element from the other bag from this bag
            
            if(temp<=0) // if the resulting count is less than or equal to 0, add the current element to the map with count 0
            {
                tempMap.put(element, 0);
            }
            
            else // otherwise add the current element to the map with the calculated count
            {
                tempMap.put(element, temp);
            }
            
        }
       
        return new Bag(u, tempMap); // return a new bag with the same universal set as this one, and the mappings calculated above
    }

    // Multiset Sum 
    public Bag mSum(Bag other) {
        // TODO: implement
        return null;
    }

    // Print counts
    public String toCountListing() 
    {
		StringBuilder sb = new StringBuilder();

		for (String element : u.getElements()) {
			sb.append(element).append(": ").append(getCount(element)).append("\n");
		}
		return sb.toString();
    }

    // Expanded element list
   public List<String> toExpandedElementList() 
   {
		List<String> expanded = new ArrayList<>();

		for (String element : u.getElements()) {
			int count = getCount(element);

			for (int i = 0; i < count; i++) {
				expanded.add(element);
			}
		}

		return expanded;
   }

    // Check same universe
    private void requireSameUniverse(Bag other) 
    {
		if (other == null)
			throw new IllegalArgumentException("Other bag cannot be null");

		if (this.u != other.u)
			throw new IllegalArgumentException("Both bags must use the same UniversalSet object,");
    }
    
}