package chapter2.design.pattern.principles.interfaces.polymorphism;

public class InterfacePolymorphism {

	public static void main(String[] args) {

		Oceanographer o = new Oceanographer();

		// Dolphin and Whale implements LiveInOcean
		o.checkSound(new Dolphin());
		o.checkSound(new Whale());

		// The Lemur extends Primate and implements HasTail
		Lemur lemur = new Lemur();
		System.out.println(lemur.age);

		// Passing the reference to the HasTail interface
		HasTail hasTail = lemur;
		System.out.println(hasTail.isTailStriped());

		// Passing the reference to the super class
		Primate primate = lemur;
		System.out.println(primate.hasHair());

		// IMPORTANT: Passing the reference will restricts variables, if we want
		// we can use explicit cast
		// DOES NOT COMPILE
		// System.out.println(hasTail.age); // age is only accessible in Lemur
		// System.out.println(primate.isTailStriped()); // isTailStriped is only accessible in HasTail
		System.out.println(((Lemur) hasTail).age);
		System.out.println(((HasTail) primate).isTailStriped());
	}
}

interface LivesInOcean {
	public void makeSound();
}

class Dolphin implements LivesInOcean {
	public void makeSound() {
		System.out.println("whistle");
	}
}

class Whale implements LivesInOcean {
	public void makeSound() {
		System.out.println("sing");
	}
}

class Oceanographer {
	// We can check any animal who LivesInOcean
	// In the future we can create Fish or Lobster, and implements LivesInOcean
	// The Oceanographer will check this new objects too
	public void checkSound(LivesInOcean animal) {
		animal.makeSound();
	}
}


class Primate {
	public boolean hasHair() {
		return true;
	}
}

interface HasTail {
	public boolean isTailStriped();
}

class Lemur extends Primate implements HasTail {
	public int age = 10;

	public boolean isTailStriped() {
		return false;
	}
}
