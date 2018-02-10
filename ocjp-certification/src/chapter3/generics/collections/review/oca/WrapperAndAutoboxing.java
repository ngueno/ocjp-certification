package chapter3.generics.collections.review.oca;

import java.util.ArrayList;
import java.util.List;

//Primitive type Wrapper class Example of initializing
//
//boolean   Boolean     new Boolean(true)
//byte      Byte        new Byte((byte)   1)
//short     Short       new Short((short) 1)
//int       Integer     new Integer(1)
//long      Long        new Long(1)
//float     Float       new Float(1.0)
//double    Double      new Double(1.0)
//char      Character   new Character('c')
public class WrapperAndAutoboxing {

	public static void main(String[] args) {

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(new Integer(3));
		numbers.add(new Integer(5));
		numbers.remove(1); // HERE IS THE MOTHERFUCKER TRICK, this method takes an int as A INDEX, so it remove the Integer 3 instead of the Integer 1
		numbers.remove(new Integer(5)); // Here the Integer 5 was removed

		System.out.println(numbers); // It will print just [1]

		//Java also converts the wrapper classes to primitives via unboxing:
		int num = numbers.get(0);

	}
}
