package chapter3.generics.collections.generics;

public class GenericMethods {

	public static void main(String[] args) {

		Box box = new Box();

		box.<String> ship("123");
		box.<String[]> ship(new String[] { "123", "12345", "dsfok" });
	}

	public static <T> Crate<T> ship(T t) {
		System.out.println("Preparing " + t);
		return new Crate<T>();
	}

	public static <T> void sink(T t) { }
	public static <T> T identity(T t) { return t; }
	// public static T noGood(T t) { return t; } // DOES NOT COMPILE
}

class Box {

	public static <T> Crate<T> ship(T t) {
		System.out.println("Preparing " + t);
		return new Crate<T>();
	}
}