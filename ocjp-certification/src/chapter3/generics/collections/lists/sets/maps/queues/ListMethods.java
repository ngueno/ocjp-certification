package chapter3.generics.collections.lists.sets.maps.queues;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Method                              Description
// void add(E element)                 Adds element to end
// void add(int index, E element)      Adds element at index and moves the rest towardthe end
// E get(int index)                    Returns element at index
// int indexOf(Object o)               Returns first matching index or -1 if not found
// int lastIndexOf(Object o)           Returns last matching index or -1 if not found
// void remove(int index)              Removes element at index and moves the rest toward the front
// E set(int index, E e)               Replaces element at index and returns original
public class ListMethods {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("SD"); // [SD]
		list.add(0, "NY"); // [NY,SD]
		list.set(1, "FL"); // [NY,FL]
		list.remove("NY"); // [FL]
		list.remove(0); // []

		list.add("OH"); // [OH]
		list.add("CO"); // [OH,CO]
		list.add("NJ"); // [OH,CO,NJ]
		String state = list.get(0); // OH
		int index = list.indexOf("NJ"); // 2

		// Looping through a list
		for (String string : list) {
			System.out.println(string);
		}

		Iterator oldIterator = list.iterator();
		while (oldIterator.hasNext()) {
			String string = (String) oldIterator.next();
			System.out.println(string);
		}

		Iterator<String> newIterator = list.iterator();
		while (newIterator.hasNext()) {
			String string = newIterator.next();
			System.out.println(string);
		}

		// Using lambda
		list.forEach(System.out::println);
	}
}
