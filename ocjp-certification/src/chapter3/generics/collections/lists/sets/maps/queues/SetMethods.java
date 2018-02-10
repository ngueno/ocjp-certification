package chapter3.generics.collections.lists.sets.maps.queues;

import java.util.HashSet;
import java.util.Set;

// Sets behave with respect to the traditional Collection methods
public class SetMethods {

	public static void main(String[] args) {

		Set<Integer> set = new HashSet<>();

		boolean b1 = set.add(66); // true
		boolean b2 = set.add(10); // true
		boolean b3 = set.add(66); // false // We have already added a 66 to this set
		boolean b4 = set.add(8); // true

		for (Integer integer: set) System.out.print(integer + ","); // 66,8,10,

		// Remember that the equals() method IS USED TO DETERMINE EQUALITY.
		// The hashCode() method IS USED TO KNOW WHICH BUCKET to look in so that Java doesn’t have to look through the whole
		// set to find out if an object is there.
	}
}
