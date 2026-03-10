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
    public Bag(UniversalSet u, Map<String, Integer> initialCounts) {
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
    public Bag mDifference(Bag other) {
        // TODO: implement
        return null;
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