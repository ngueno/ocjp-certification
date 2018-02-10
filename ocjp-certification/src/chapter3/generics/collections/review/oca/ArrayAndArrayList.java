package chapter3.generics.collections.review.oca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAndArrayList {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>(); // empty list
		list.add("Fluffy"); // [Fluffy]
		list.add("Webby"); // [Fluffy, Webby]

		String[] array = new String[list.size()]; // empty array
		array[0] = list.get(1); // [Webby]
		array[1] = list.get(0); // [Webby, Fluffy]

		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + "-");

		String[] array2 = { "gerbil", "mouse" }; // [gerbil, mouse]

		List<String> list2 = Arrays.asList(array2); // returns fixed size list
		list2.set(1, "test"); // [gerbil, test]
		array2[0] = "new"; // [new, test]

		String[] array3 = (String[]) list2.toArray(); // [new, test]
		list2.remove(1); // throws UnsupportedOperationException
	}
}
