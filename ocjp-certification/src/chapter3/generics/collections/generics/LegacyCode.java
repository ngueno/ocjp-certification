package chapter3.generics.collections.generics;

import java.util.ArrayList;
import java.util.List;

public class LegacyCode {

	public static void main(String[] args) {
	
		LegacyUnicorns.test();
		LegacyAutoboxing.test();
	}
}

class Dragon {
}

class Unicorn {
}

class LegacyDragons {
	public static void main(String[] args) {
		List unicorns = new ArrayList();
		unicorns.add(new Unicorn());
		printDragons(unicorns);
	}

	private static void printDragons(List<Dragon> dragons) {
		for (Dragon dragon : dragons) { // ClassCastException
			System.out.println(dragon);
		}
	}
}

class LegacyUnicorns {

	public static void test() {
		List<Unicorn> unicorns = new ArrayList<>();
		LegacyUnicorns.addUnicorn(unicorns);
		Unicorn unicorn = unicorns.get(0); // ClassCastException
	}

	private static void addUnicorn(List unicorn) {
		unicorn.add(new Dragon());
	}
}

class LegacyAutoboxing {
	
	public static void test() {
		java.util.List numbers = new java.util.ArrayList();
		numbers.add(5);
		// int result = numbers.get(0); // DOES NOT COMPILE
		int result = (int) numbers.get(0);
	}
	
}