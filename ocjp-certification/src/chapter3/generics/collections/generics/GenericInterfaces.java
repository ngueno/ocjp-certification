package chapter3.generics.collections.generics;

public class GenericInterfaces {

	public static void main(String[] args) {

	}
}

interface Shippable<T> {
	void ship(T t);
}

// There are three ways a class can approach implementing this interface
class ShippableRobotCrate implements Shippable<Robot> {
	public void ship(Robot t) {
	}
}

abstract class ShippableAbstractCrate<U> implements Shippable<U> {
	public void ship(U t) {
	}
}

class ShippableCrate implements Shippable {
	public void ship(Object t) {
	}
}