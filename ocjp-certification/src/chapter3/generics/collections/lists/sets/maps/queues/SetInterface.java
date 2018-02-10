package chapter3.generics.collections.lists.sets.maps.queues;

public class SetInterface {

	public static void main(String[] args) {

	}
}

// A HashSet stores its elements in a hash table.
// This means that it uses the hashCode() method of the objects to retrieve them more efficiently.
//
// The MAIN BENEFIT is that ADDING elements AND CHECKING if an ELEMENT IS IN the set both HAVE CONSTANT TIME.
// The TRADEOFF is that YOU LOSE THE ORDER in which you inserted the elements.
class HashSetImplementation {

}

// A TreeSet stores its elements in a sorted tree structure
//
// The MAIN BENEFIT is that the set IS ALWAYS IN SORTED ORDER.
// The TRADEOFF is that ADDING AND CHECKING if an element is present ARE BOTH O(log n)
//
// TreeSet IMPLEMENTS a SPECIAL INTERFACE called NavigableSet, which LETS YOU SLICE UP THE COLLECTION
class TreeSetImplementation {

}