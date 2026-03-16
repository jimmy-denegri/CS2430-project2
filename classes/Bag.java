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

    // Multiset Union = A ∪ B
    // For each element, the multiplicity in the union is the MAXIMUM count between the two bags.
    // Example: A: apple(3), B: apple(5) → Union: apple(5)
    public Bag mUnion(Bag other) {

        requireSameUniverse(other);

        // Get the full list of elements from the universal set so we can
        // compare counts for every possible element, not just ones with nonzero counts.
        List<String> uniElements = u.getElements();

        // Temporary map to hold the resulting multiplicity for each element.
        // Will be used to construct the returned Bag.
        Map<String, Integer> tempMap = new HashMap<>();

        // Loop through every element in the universal set.
        for (String element : uniElements) {

            // Get how many times this element appears in this bag.
            int thisCount = this.getCount(element);

            // Get how many times this element appears in the other bag.
            int otherCount = other.getCount(element);

            // In a multiset union, the multiplicity of each element is the
            // MAXIMUM count between the two bags.
            // An element not present in one bag contributes a count of 0 for that bag.
            int resultCount = Math.max(thisCount, otherCount);

            // Store the result count mapped to this element.
            tempMap.put(element, resultCount);
        }

        // Create and return a new Bag using the same universal set
        // and the maximum-count mappings calculated above.
        return new Bag(u, tempMap);
    }

    // Multiset Intersection 
    public Bag mIntersection(Bag other) {
        
        requireSameUniverse(other);

        // Get a list of all possible elements from the universal set.
        // We iterate through the entire universe so we can compare counts
        // for every possible element.
        List<String> uniElements = u.getElements();

        // Temporary map that will store the resulting counts for the intersection.
        // This will eventually be used to construct the resulting Bag.
        Map<String, Integer> tempMap = new HashMap<>();

        // Loop through every element in the universal set
        for (String element : uniElements) {

            // Get how many times this element appears in the current bag (this)
            int thisCount = this.getCount(element);

            // Get how many times this element appears in the other bag
            int otherCount = other.getCount(element);

            // In a multiset intersection, the multiplicity of each element
            // is the MINIMUM count between the two bags.
            // Example: A: apple(3),B: apple(1)
            // Intersection: apple(1)
            int resultCount = Math.min(thisCount, otherCount);

            // Store the result count in the temporary map
            // The key is the element name, and the value is the calculated multiplicity
            tempMap.put(element, resultCount);
        }

        // Create and return a new Bag object that uses the same universal set and the counts that were calculated in tempMap.
        return new Bag(u, tempMap);
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

    // Multiset Sum		Benjamnin Shaw
    public Bag mSum(Bag other) {
    	Map<String, Integer> mSum = new HashMap<>();	// The stored sum of the two Maps in the Bags
    	for (String el : u.getElements()) {		// Looping through the elements
    		
    		mSum.put(el, getCount(element) + other.getCount(element)); 
    	}
        return new Bag(u, mSum);
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
