package chapter3.generics.collections.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpperBoundedWildcards {

	public static void main(String[] args) {

		// ArrayList<Number> list = new ArrayList<Integer>(); // DOES NOT COMPILE
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(new Integer(9));
		List<Double> list2 = new ArrayList<Double>();
		list2.add(new Double(9));
		List<Float> list3 = new ArrayList<Float>();
		list3.add(new Float(9));
		List<Long> list4 = new ArrayList<Long>();
		list4.add(new Long(9));

		System.out.println(UpperBoundedWildcards.total(list1));
		System.out.println(UpperBoundedWildcards.total(list2));
		System.out.println(UpperBoundedWildcards.total(list3));
		System.out.println(UpperBoundedWildcards.total(list4));

		List<? extends Bird> birds = new ArrayList<Bird>();
		// It doesn't compile because the List could be List<Bird> or List<Sparrow>
		// birds.add(new Sparrow()); // DOES NOT COMPILE
		// birds.add(new Bird()); // DOES NOT COMPILE
		
		List<HangGlider> hangGliderList = Arrays.asList(new HangGlider(), new HangGlider(), new HangGlider());
		List<Goose> gooseList = Arrays.asList(new Goose(), new Goose(), new Goose());

		// List<Flyer> flyersHangGlider = new ArrayList<>(Arrays.asList(new HangGlider(), new HangGlider(), new HangGlider())); // IT WORKS
		// List<Flyer> flyersGoose = new ArrayList<>(Arrays.asList(new Goose(), new Goose(), new Goose())); // IT WORKS
		
		List<Flyer> flyers = new ArrayList<Flyer>();
		flyers.addAll(gooseList);
		flyers.addAll(hangGliderList);

		anyFlyer(flyers);

		// anyFlyer(hangGliderList); // DOESN'T COMPILE // Goose or HangGlider?
		groupOfFlyers(hangGliderList);

		// anyFlyer(gooseList); // DOESN'T COMPILE // HangGlider or Goose
		groupOfFlyers(gooseList);
	}

	public static long total(List<? extends Number> list) {
		long count = 0;
		for (Number number : list)
			count += number.longValue();
		return count;
	}

	public static void anyFlyer(List<Flyer> flyer) {
		flyer.forEach(Flyer::fly);
	}

	public static void groupOfFlyers(List<? extends Flyer> flyer) {

	}

}

class Sparrow extends Bird {
}

class Bird {
}

interface Flyer {
	void fly();
}

class HangGlider implements Flyer {
	public void fly() {
		System.out.println("HangGlider");
	}
}

class Goose implements Flyer {
	public void fly() {
		System.out.println("Goose");
	}
}