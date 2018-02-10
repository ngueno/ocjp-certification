package chapter2.design.pattern.principles.workout;

// PROBLEM: How do we write code that creates objects in which the precise type of the object
// may not be known until runtime?
// SOLUTION: The factory pattern, sometimes referred to as the factory method pattern, is a
// creational pattern based on the idea of using a factory class to produce instances of objects
// based on a set of input parameters. It is similar to the builder pattern, ALTHOUGH IT IS FOCUSED
// ON SUPPORTING CLASS POLYMORPHISM.
public class FactoryPattern {

	public static void main(String[] args) {

		// We don’t care about the particular
		// type of food that we get, as long as it implements the Food interface
		final Food food = FoodFactory.getFood("polar bear");
		food.consumed();
	}
}

abstract class Food {

	private int quantity;

	public Food(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public abstract void consumed();
}

class Hay extends Food {

	public Hay(int quantity) {
		super(quantity);
	}

	public void consumed() {
		System.out.println("Hay eaten: " + getQuantity());
	}
}

class Pellets extends Food {

	public Pellets(int quantity) {
		super(quantity);
	}

	public void consumed() {
		System.out.println("Pellets eaten: " + getQuantity());
	}
}

class Fish extends Food {

	public Fish(int quantity) {
		super(quantity);
	}

	public void consumed() {
		System.out.println("Fish eaten: " + getQuantity());
	}
}

class FoodFactory {

	// Depending on the value of animalName, we return different types of food for use in our
	// factory.
	public static Food getFood(String animalName) {
		switch (animalName) {
		case "zebra":
			return new Hay(100);
		case "rabbit":
			// First of all, different animals
			// can share the same food, such as goat and rabbit both eating pellets but with varying
			// quantities.
			return new Pellets(5);
		case "goat":
			return new Pellets(30);
		case "polar bear":
			return new Fish(10);
		}
		// Good practice to throw an exception if no matching subclass could be found
		throw new UnsupportedOperationException("Unsupported animal: " + animalName);
	}
}
