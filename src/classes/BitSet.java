package classes;

import java.util.*;

public class BitSet {

    private UniversalSet u;   // Reference to universal set
    private boolean[] bits;   // Boolean array representation

    // Constructor: empty set
    public BitSet(UniversalSet u) {
        // TODO: implement
    }

    // Constructor: from boolean array
    public BitSet(UniversalSet u, boolean[] initialBits) {
        // TODO: implement
    }

    // Factory method: create from list of element names
    public static BitSet fromElements(UniversalSet u, List<String> elems) {
        // TODO: implement
        return null;
    }

    // Convert to bit string
    public String toBitString() {
        // TODO: implement
        return "";
    }
    
    public boolean[] getBoolBits()
    {
        return bits.clone();
    }

    // Convert to element listing
    public String toElementListing() {
        // TODO: implement
        return "";
    }

    // Complement
    public BitSet complement() {
        // TODO: implement
        return null;
    }

    // Union
    public BitSet union(BitSet other) {
        // TODO: implement
        return null;
    }

    // Intersection
    public BitSet intersection(BitSet other) {
        // TODO: implement
        return null;
    }

    // Difference
    public BitSet difference(BitSet other) {
        // TODO: implement
        return null;
    }

    // Symmetric Difference
    public BitSet symmetricDifference(BitSet other) {
        // TODO: implement
        return null;
    }

    // Check same universe
    private void SameUniverse(BitSet other) {
        // TODO: implement
    }
}