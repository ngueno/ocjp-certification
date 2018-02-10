package chapter2.design.pattern.principles.interfaces;

// Java defines a functional interface as an interface that contains a single abstract method.
// Functional interfaces are used as the basis for lambda expressions in functional programming.
// A lambda expression is a block of code that gets passed around, like an anonymous method.
public class FunctionalInterface {

	public static void main(String[] args) {

	}
}

// @FunctionalInterface
// Spring is a functional interface because it have only ONE ABSTRACT METHOD
interface Sprint {

	// Yeah buddy, i'm the only abstract method
	public void sprint(Animal animal);
}

class Tiger implements Sprint {
	public void sprint(Animal animal) {
		System.out.println("Animal is sprinting fast! " + animal.toString());
	}
}

// VALID FUNCTIONAL INTERFACE, it inherits the only ABSTRACT METHOD of Sprint
interface RunSprint extends Sprint {
}

// VALID FUNCTIONAL INTERFACE, it overrides the signature of the abstract method
interface SprintFaster extends Sprint {
	public void sprint(Animal animal);
}

// VALID FUNCTIONAL INTERFACE, it inherits the abstract from Sprint, declares a
// default and static, but not another abstract
interface Skip extends Sprint {
	public default int getHopCount(Kangaroo kangaroo) {
		return 10;
	}

	public static void skip(int speed) {
	}
}

// Now a collection of INVALIDS
// INVALID FUNCTIONAL INTERFACE, it don't declare any abstract method
// @FunctionalInterface // DOES NOT COMPILE
interface WalkInvalidFunctional {
}

// INVALID FUNCTIONAL INTERFACE, because inheriting from Spring, it assumes TWO
// ABSTRACT METHODS
// @FunctionalInterface // DOES NOT COMPILE
interface Dance extends Sprint {
	public void dance(Animal animal);
}

// INVALID FUNCTIONAL INTERFACE, because it have TWO ABSTRACT METHODS
// @FunctionalInterface // DOES NOT COMPILE
interface Crawl {
	public void crawl();

	public int getCount();
}
