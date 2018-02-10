package chapter3.generics.collections.review.oca;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchingAndSorting {

	public static void main(String[] args) {

		int[] numbers = { 6, 9, 1, 8 };
		Arrays.sort(numbers); // [1,6,8,9]
		System.out.println(Arrays.binarySearch(numbers, 6)); // 1 | POSITION WHERE THE NUMBER IS
		System.out.println(Arrays.binarySearch(numbers, 3)); // -2 | RETURNS THE NEGATED INDEX WHERE THE NUMBER WOULD NEED TO BE INSERTED -1 ( e.g
																// needed to be inserted at 1, the negated value is -1, adding -1, -1 + -1 = -2

		List<Integer> list = Arrays.asList(9, 7, 5, 3);
		Collections.sort(list); // [3, 5, 7, 9]
		System.out.println(Collections.binarySearch(list, 3)); // 0
		System.out.println(Collections.binarySearch(list, 2)); // -1 | Needed to be inserted at 0, negated is 0, adding -1, 0 - 1 = -1
	}
}
