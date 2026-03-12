package classes;

import java.util.*;

public class bag {

	private UniversalSet u;
	private Map<String, Integer> counts;

	// Constructor
	public bag(UniversalSet u) {
		this.u = u;
		this.counts = new HashMap<>();
	}

	// Constructor: from map of counts
	public bag(UniversalSet u, Map<String, Integer> initialCounts) {
		this.u = u;
		this.counts = new HashMap<>();

	}

	// Get count of element
	public int getCount(String elementName) {
		return counts.getOrDefault(elementName, 0);
	}

	// Set count of element
	public void setCount(String elementName, int count) {
		if (!u.contains(elementName))
			throw new IllegalArgumentException("Element is not in universal set");

		if (count < 0)
			throw new IllegalArgumentException("Count cannot be negative");

		if (count == 0)
			counts.remove(elementName);
		else
			counts.put(elementName, count);

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
		StringBuilder sb = new StringBuilder();

		for (String element : u.getElements()) {
			sb.append(element).append(": ").append(getCount(element)).append("\n");
		}
		return sb.toString();
	}

	// Expanded element list
	public List<String> toExpandedElementList() {
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
	private void requireSameUniverse(bag other) {
		if (other == null)
			throw new IllegalArgumentException("Other bag cannot be null");

		if (this.u != other.u)
			throw new IllegalArgumentException("Both bags must use the same UniversalSet object,");
	}
}