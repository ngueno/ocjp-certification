package chapter2.design.pattern.principles.interfaces.polymorphism;

// About cast here are some basic rules to keep in mind when casting variables:
//
// 1. Casting an object FROM A SUBCLASS to a SUPERCLASS DOESN'T REQUIRE an explicit cast.
// 2. Casting an object FROM A SUPERCLASS to a SUBCLASS REQUIRES an explicit cast.
// 3. The compiler WILL NOT ALLOW casts to UNRELATED TYPES.
// 4. Even when the code compiles without issue, AN EXCEPTION MAY BE THROWN at runtime if
//    the object being cast IS NOT ACTUALLY AN INSTANCE of that class.
//
public class CastPrinciples {

	public static void main(String[] args) {

		Lemur lemur = new Lemur();

		// 1 Rule
		Primate primate = lemur;

		// 2 Rule
		// Lemur lemur2 = primate; // DOES NOT COMPILE

		// 3 Rule
		Lemur lemur3 = (Lemur) primate;

		System.out.println(lemur3.age);

		Fish fish = new Fish();
		// 3 Rule
		// Bird bird = (Fish) bird; // DOES NOT COMPILE

		Rodent rodent = new Rodent();
		// To avoid the error in next lines, we can use instanceof before use
		// the cast to capybara
		if (rodent instanceof Capybara) {
			// It will not pass here
			System.out.println("Using INSTANCEOF");
			Capybara capybara = (Capybara) rodent;
		}

		// 4 Rule - Throws ClassCastException at runtime
		// Rodent is not an instance of capybara
		Capybara capybara = (Capybara) rodent;

	}
}

class Bird {
}

class Fish {
}

class Rodent {
}

class Capybara extends Rodent {
}