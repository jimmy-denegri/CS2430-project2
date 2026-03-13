package classes;

import java.util.*;

public class Bag {

    private UniversalSet u;                     
    private Map<String, Integer> counts;        

    // Constructor
    public Bag(UniversalSet u) {
        // TODO: implement
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
    public String toCountListing() {
        // TODO: implement
        return "";
    }

    // Expanded element list
    public List<String> toExpandedElementList() {
        // TODO: implement
        return null;
    }

    // Check same universe
    private void requireSameUniverse(Bag other) {
        // TODO: implement
    }
}