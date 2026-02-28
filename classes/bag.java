package classes;

import java.util.*;

public class bag {

    private UniversalSet u;                     
    private Map<String, Integer> counts;        

    // Constructor
    public bag(UniversalSet u) {
        // TODO: implement
    }

    // Constructor: from map of counts
    public bag(UniversalSet u, Map<String, Integer> initialCounts) {
        // TODO: implement
    
    }

    // Get count of element
    public int getCount(String elementName) {
        // TODO: implement
        return 0;
    }

    // Set count of element
    public void setCount(String elementName, int count) {
        // TODO: implement
    }

    // Multiset Union 
    public bag mUnion(bag other) {
        // TODO: implement
        return null;
    }

    // Multiset Intersection 
    public bag mIntersection(bag other) {
        // TODO: implement
        return null;
    }

    // Multiset Difference
    public bag mDifference(bag other) {
        // TODO: implement
        return null;
    }

    // Multiset Sum 
    public bag mSum(bag other) {
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
    private void requireSameUniverse(bag other) {
        // TODO: implement
    }
}