package chapter3.generics.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonCollectionsMethods {

	public static void main(String[] args) {

		// Signatures:
		// boolean add(E element)
		List<String> list = new ArrayList<>();
		System.out.println(list.add("Sparrow")); // true
		System.out.println(list.add("Sparrow")); // true
		
		Set<String> set = new HashSet<>();
		System.out.println(set.add("Sparrow")); // true
		System.out.println(set.add("Sparrow")); // false // SET DOESN'T ALLOW DUPLICATES

		System.out.println();

		// Signatures:
		// boolean remove(Object object)
		List<String> birds = new ArrayList<>();
		birds.add("hawk"); // [hawk]
		birds.add("hawk"); // [hawk, hawk]
		System.out.println(birds.remove("cardinal")); // prints false
		System.out.println(birds.remove("hawk")); // prints true // REMOVES THE FIRST OCCURRENCE
		System.out.println(birds); // [hawk]

		// ATTENTION: BE AWARE OF THE METHOD SIGNATURE, for example:
		// birds.remove(100); TAKES AN INT AS ARGUMENT
		// It will throw a IndexOutOfBoundsException at runtime, because there are no birds at the index 100

		System.out.println();

		// Signatures:
		// boolean isEmpty()
		// int size()
		birds = new ArrayList<>();
		System.out.println(birds.isEmpty()); // true
		System.out.println(birds.size()); // 0
		birds.add("hawk"); // [hawk]
		birds.add("hawk"); // [hawk, hawk]
		System.out.println(birds.isEmpty()); // false
		System.out.println(birds.size()); // 2

		System.out.println();

		// Signatures:
		// void clear()
		birds = new ArrayList<>();
		birds.add("hawk"); // [hawk]
		birds.add("hawk"); // [hawk, hawk]
		System.out.println(birds.isEmpty()); // false
		System.out.println(birds.size()); // 2
		birds.clear(); // []
		System.out.println(birds.isEmpty()); // true
		System.out.println(birds.size()); // 0

		System.out.println();

		// Signatures:
		// boolean contains(Object object)
		// This method calls equals() on each element of the ArrayList to see if there are any matches
		birds = new ArrayList<>();
		birds.add("hawk"); // [hawk]
		System.out.println(birds.contains("hawk")); // true
		System.out.println(birds.contains("robin")); // false
	}

}
