package classes;

import java.util.*;

public class BitSet {

	private UniversalSet u; // Reference to universal set
	private boolean[] bits; // Boolean array representation

	// Constructor: empty set
	public BitSet(UniversalSet u) {
		this.u = u;
		this.bits = new boolean[u.size()];
	}

	// Constructor: from boolean array
	public BitSet(UniversalSet u, boolean[] initialBits) {
		this.u = u;
		this.bits = Arrays.copyOf(initialBits, initialBits.length);
	}

	// Factory method: create from list of element names
	public static BitSet fromElements(UniversalSet u, List<String> elems) {
		int index;
		BitSet result;

		if (u == null)
			throw new IllegalArgumentException("Universal set cannot be null");

		if (elems == null)
			throw new IllegalArgumentException("Element list cannot be null");

		result = new BitSet(u);

		for (String e : elems) {
			if (!u.contains(e))
				throw new IllegalArgumentException("Element list cannot be null");

			index = u.indexOf(e);
			result.bits[index] = true;
		}

		return result;
	}

	// Convert to bit string
	public String toBitString() {
		StringBuilder sb = new StringBuilder();

		for (boolean bit : bits) {
			if (bit)
				sb.append("1");
			else
				sb.append("0");
		}
		return sb.toString();
	}

	// Convert to element listing
	public String toElementListing() {
		List<String> included = new ArrayList<>();
		List<String> uniElements = u.getElements();

		for (int i = 0; i < bits.length; i++) {
			if (bits[i])
				included.add(uniElements.get(i));
		}

		return included.toString();
	}

	// Complement = NOT(A)
	public BitSet complement() {
		boolean[] resultBits = new boolean[bits.length];

		for (int i = 0; i < bits.length; i++) {
			resultBits[i] = !bits[i];
		}
		return new BitSet(u, resultBits);
	}

	// Returns the raw boolean array for direct comparison (used in tests)
	public boolean[] getBoolBits() {
		return Arrays.copyOf(bits, bits.length);
	}

	// Union = A ∪ B
	// An element is in the union if it belongs to A, B, or both.
	// For each position, the result bit is true if either bit is true (logical OR).
	public BitSet union(BitSet other) {

		// Create a new boolean array to hold the result of the union.
		// Same length as the current bit array since both sets share the same universe.
		boolean[] r = new boolean[bits.length];

		// Loop through every position in the bit array.
		// Each index corresponds to a specific element in the universal set.
		for (int i = 0; i < bits.length; i++) {

			// Union means the element must exist in AT LEAST ONE of the two sets.
			// If either bit is true, the result is true.
			// Only false if both bits are false.
			if (this.bits[i] || other.bits[i]) {
				r[i] = true;
			} else {
				r[i] = false;
			}
		}

		// Create and return a new BitSet using the same universal set
		// and the union result array calculated above.
		return new BitSet(u, r);
	}

	// Intersection
	public BitSet intersection(BitSet other) {
	    
	    // Create a new boolean array that will store the result of the intersection.
	    // It has the same length as the current bit array because every position
	    // corresponds to an element in the universal set.
	    boolean[] r = new boolean[bits.length];

	    // Loop through every position in the bit array.
	    // Each index represents a specific element in the universal set.
	    for (int i = 0; i < bits.length; i++) {
	        
	        // Intersection for ordinary sets means the element must exist in BOTH sets.
	        // If both bits are true, the result is true.
	        // If either is false, the result is false.
	    	if (this.bits[i] && other.bits[i]) {
	    	    r[i] = true;
	    	} else {
	    	    r[i] = false;
	    	}
	    }

	    // Create and return a new BitSet object using the same universal set
	    // and the result bit array we just calculated.
	    return new BitSet(u, r);
	}

	// Difference		Benjamin Shaw + Ahren
	public BitSet difference(BitSet other) {
		
		// get the other bits for difference
		boolean[] otherBits = other.getBoolBits();
		// Making a temporary array to put into a BitSet
		boolean[] difference = new boolean[bits.length];
		
		// Looping throught the arrays to get the differecne
		for (int i = 0; i < bits.length; i++) {
			if (bits[i] && otherBits[i]) {	// Getting the case when both bits are true
				difference[i] = false;
			} else {
				difference[i] = bits[i];	// All other cases just look at the bits	(a) out of (a - b)
			}
			
		}
		return new BitSet(difference);
	}

	// Symmetric Difference
	public BitSet symDifference(BitSet other) 
        {
            return difference(other).union(other.difference(this));
        }

	// Check same universe
	private void SameUniverse(BitSet other) {
		// TODO: implement
	}
}
