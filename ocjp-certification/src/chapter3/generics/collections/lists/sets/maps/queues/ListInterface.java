package chapter3.generics.collections.lists.sets.maps.queues;

public class ListInterface {

	public static void main(String[] args) {

	}
}

// An ArrayList is like a RESIZABLE ARRAY, When YOU AREN’T SURE which collection to use, use an ArrayList
//
// The MAIN BENEFIT of an ArrayList is that YOU CAN LOOK UP ANY ELEMENT IN CONSTANT TIME.
// ADDING OR REMOVING AN ELEMENT IS SLOWER THAN ACCESSING AN ELEMENT.
//
// This makes an ArrayList a good choice WHEN YOU ARE READING MORE OFTEN THAN (or the same amount
// as) WRITING to the ArrayList .
class ArrayListImplementation {

}

// A LinkedList is special because it implements both List and Queue
// It has all of the methods of a List. It also has additional methods to facilitate adding or removing from the
// beginning and/or end of the list.
//
// The MAIN BENEFITS of a LinkedList are that YOU CAN ACCESS, ADD, AND REMOVE from the BEGINNING and END of the LIST in CONSTANT TIME
// The TRADEOFF is that DEALING with an ARBITRARY INDEX TAKES LINEAR TIME. This makes a LinkedList a good choice when you’ll be using
// it as Queue.
//
class LinkedListImplementation {

}