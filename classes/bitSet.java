package classes;

import java.util.*;

public class bitSet {

	private UniversalSet u; // Reference to universal set
	private boolean[] bits; // Boolean array representation

	// Constructor: empty set
	public bitSet(UniversalSet u) {
		this.u = u;
		this.bits = new boolean[u.size()];
	}

	// Constructor: from boolean array
	public bitSet(UniversalSet u, boolean[] initialBits) {
		this.u = u;
		this.bits = Arrays.copyOf(initialBits, initialBits.length);
	}

	// Factory method: create from list of element names
	public static bitSet fromElements(UniversalSet u, List<String> elems) {
		int index;
		bitSet result;

		if (u == null)
			throw new IllegalArgumentException("Universal set cannot be null");

		if (elems == null)
			throw new IllegalArgumentException("Element list cannot be null");

		result = new bitSet(u);

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
	public bitSet complement() {
		boolean[] resultBits = new boolean[bits.length];

		for (int i = 0; i < bits.length; i++) {
			resultBits[i] = !bits[i];
		}
		return new bitSet(u, resultBits);
	}

	// Union
	public bitSet union(bitSet other) {
		// TODO: implement
		return null;
	}

	// Intersection
	public bitSet intersection(bitSet other) {
		// TODO: implement
		return null;
	}

	// Difference
	public bitSet difference(bitSet other) {
		// TODO: implement
		return null;
	}

	// Symmetric Difference
	public bitSet symmetricDifference(bitSet other) {
		// TODO: implement
		return null;
	}

	// Check same universe
	private void SameUniverse(bitSet other) {
		// TODO: implement
	}
}