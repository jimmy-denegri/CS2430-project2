package classes;

import java.util.*;

public class UniversalSet {
	

    // Ordered list of elements
    private List<String> elements;

    // Fast lookup map: element name -> index
    private Map<String, Integer> indexMap;
    
    // Use JUnit Tests instead
    /*public static void main(String[] args) {
		List<String> uniList = Arrays.asList("SLCC", "UVU", "BYU", "Weber", "USU", "U of U");

		UniversalSet u = new UniversalSet(uniList);
		BitSet A = BitSet.fromElements(u, Arrays.asList("SLCC", "UVU", "Weber"));

		System.out.println(uniList.toString());

		// Testing out A's bit strings and elements
		System.out.println("A bit string: " + A.toBitString());
		System.out.println("A elements: " + A.toElementListing());

		// Testing out for NOT(A)
		System.out.println("NOT(A) bit string: " + A.complement().toBitString());
		System.out.println("NOT(A) elements: " + A.complement().toElementListing());
	}*/

    /*
     * Constructor
     * Requires at least 10 elements
     * No duplicates allowed
     */
    public UniversalSet(List<String> elements) {

        if (elements.size() < 10) {
             System.out.println("Universal set must contain at least 10 elements.");
        }

        this.elements = new ArrayList<>();
        this.indexMap = new HashMap<>();

        for (int i = 0; i < elements.size(); i++) {

            String name = elements.get(i);

            if (indexMap.containsKey(name)) {
                System.out.println("Duplicate element: " + name);
            }

            this.elements.add(name);
            this.indexMap.put(name, i);
        }
    }

    // Returns number of elements
    public int size() {
        return elements.size();
    }

    // Returns list of elements 
    public List<String> getElements() {
        return new ArrayList<>(elements);
    }
    
    public Map getMap()
    {
        return new HashMap<String, Integer>(indexMap);
    }

    // Returns true if element exists in universe
    public boolean contains(String elementName) {
        return indexMap.containsKey(elementName);
    }

    // Returns index of element in universe
    public int indexOf(String elementName) {

        Integer index = indexMap.get(elementName);

        return index;
    }

    @Override
    public String toString() {
        return "U=" + elements;
    }
}