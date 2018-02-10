package chapter3.generics.collections.generics;

import java.util.ArrayList;
import java.util.List;

// 
// A bounded parameter type is a generic type that specifies a bound for the generic
// 
// A wildcard generic type is an unknown generic type represented with a question mark
// (?). You can use generic wildcards in three ways:
// 
// Type of bound 					Syntax 				Example
// Unbounded wildcard 				? 					List<?> l = new ArrayList<String>();
// Wildcard with an upper bound 	? extends type 		List<? extends Exception> l = new ArrayList<RuntimeException>();
// Wildcard with a lower bound 		? super type 		List<? super Exception> l = new ArrayList<Object>();
public class UnboundedWildcards {

	public static void main(String[] args) {
		List<String> keywords1 = new ArrayList<>();
		keywords1.add("java");
		// printListWhitoutWildcard(keywords); // DOES NOT COMPILE // Java protecting us from ourselves
		
		List<Integer> numbers = new ArrayList<>();
		numbers.add(new Integer(42));
		// Turning to a Object List, we can put everything, like Strings with Integers
		// List<Object> objects = numbers; // DOES NOT COMPILE
		// objects.add("forty two");
		// System.out.println(numbers.get(1));

		List<String> keywords2 = new ArrayList<>();
		keywords2.add("java1");
		keywords2.add("java2");
		keywords2.add("java3");
		printList(keywords2);

		List<Integer> keywords3 = new ArrayList<>();
		keywords3.add(1);
		keywords3.add(2);
		keywords3.add(3);
		printList(keywords3);

		// ATTENTION: The compiler recognizes when a unsafe cast with lists is used
		// But with arrays it compiles without problem, throwing an exception at runtime
		Integer[] numbers2 = { new Integer(42) };
		Object[] objects = numbers2; // It doesn't change the fact that Java knows it is an Integer array
		objects[0] = "forty two"; // throws ArrayStoreException
	}

	public static void printListWhitoutWildcard(List<Object> list) {
		for (Object x : list)
			System.out.println(x);
	}

	public static void printList(List<?> list) {
		for (Object x : list)
			System.out.println(x);
	}
}
