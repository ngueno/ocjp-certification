package chapter2.design.pattern.principles.interfaces.lambda;

import java.util.function.Predicate;

public class FunctionalWithLambda {

	public static void main(String[] args) {

		// A quite simple lambda expression
		// a -> a.canHop() // it returns if the animal can hop
		// When passed a lambda expression instead of a interface, it will be
		// treated as a functional interface and it
		// will be mapped to a single method
		// boolean test(AnimalLambda a);
		FindMatchingAnimals.print(new AnimalLambda("fish", false, true), a -> a.canHop());
		FindMatchingAnimals.print(new AnimalLambda("kangaroo", true, false), a -> a.canHop());

		// Many parts of a lambda expression are optional
		// These two below are equivalent
		// a -> a.canHop()
		// (Animal a) -> { return a.canHop(); }
		// It can be consumed by a functional interface whose abstract method
		// has the same number of parameters and compatible data types

		// VALID Lambdas
		// () -> new Duck()
		// d -> {return d.quack();}
		// (Duck d) -> d.quack()
		// (Animal a, Duck d) -> d.quack()

		// () -> true // 0 parameters
		// a -> {return a.startsWith("test");} // 1 parameter
		// (String a) -> a.startsWith("test") // 1 parameter
		// (int x) -> {} // 1 parameter
		// (int y) -> {return;} // 1 parameter
		// (a, b) -> a.startsWith("test") // 2 parameters

		// (String a, String b) -> a.startsWith("test") // 2 parameters
		// (y, z) -> {int x=1; return y+10; }
		// (String s, int z) -> { return s.length()+z; }
		// (a, b, c) -> a.getName()
		
		// It is possible declare variables with different name of parameters
		// (a, b) -> { int c = 0; return 5;}

		// INVALID Lambdas
		// MISSING () in the parameters list
		// Duck d -> d.quack() // DOES NOT COMPILE
		// a,d -> d.quack() // DOES NOT COMPILE
		// Animal a, Duck d -> d.quack() // DOES NOT COMPILE

		// a, b -> a.startsWith("test") // DOES NOT COMPILE // missing ()
		// c -> return 10; // DOES NOT COMPILE // missing {} in the body method
		// a -> { return a.startsWith("test") } // DOES NOT COMPILE // missing ; after return

		// When more than 1 parameter as declared, ALL PARAMETERS MUST PROVIDE A
		// DATA TYPE
		// (int y, z) -> {int x=1; return y+10; } // DOES NOT COMPILE
		// (String s, z) -> { return s.length()+z; } // DOES NOT COMPILE
		// (a, Animal b, c) -> a.getName() // DOES NOT COMPILE

		// Inside a lambda body is not possible to declare a variable with the
		// same name of the parameter
		// (a, b) -> { int a = 0; return 5;} // DOES NOT COMPILE

		// Using Predicate to evaluate lambda, using this, the interface
		// CheckTrait can be excluded from project
		FindMatchingAnimalsPredicate.print(new AnimalLambda("fish", false, true), a -> a.canHop());
		FindMatchingAnimalsPredicate.print(new AnimalLambda("kangaroo", true, false), a -> a.canHop());
	}
}

// Test class
class AnimalLambda {
	private String species;
	private boolean canHop;
	private boolean canSwim;

	public AnimalLambda(String speciesName, boolean hopper, boolean swimmer) {
		species = speciesName;
		canHop = hopper;
		canSwim = swimmer;
	}

	public boolean canHop() {
		return canHop;
	}

	public boolean canSwim() {
		return canSwim;
	}

	public String toString() {
		return species;
	}
}

class Duck extends AnimalLambda {

	public Duck(String speciesName, boolean hopper, boolean swimmer) {
		super(speciesName, hopper, swimmer);
	}

}

// Functional interface
interface CheckTrait {
	public boolean test(AnimalLambda a);
}

class FindMatchingAnimals {
	public static void print(AnimalLambda animal, CheckTrait trait) {

		// Since checktrait is a functional interface, it can use the exclusive
		// methods to manipulate lambda
		if (trait.test(animal))
			System.out.println(animal);
	}
}

class FindMatchingAnimalsPredicate {

	// Java provide the Predicate interface to do generic tests with lambda
	// without necessity of create many interfaces to treat many type of objects
	public static void print(AnimalLambda animal, Predicate<AnimalLambda> trait) {
		if (trait.test(animal))
			System.out.println(animal);
	}
}
