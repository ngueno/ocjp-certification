package chapter1.advanced.classes.design.virtual.methods;

public class VirtualMethodInvocation {

	public static void main(String[] args) {

		Cow cow = new Cow();
		cow.feed();

		Bird bird = new Bird();
		bird.feed();

		Lion lion = new Lion();
		lion.feed();

		/*
		 * This approach has a huge advantage. The feedAnimal() method doesn’t
		 * need to change when we add a new Animal subclass.
		 */
		feedAnimal(cow);
		feedAnimal(bird);
		feedAnimal(lion);

		/*
		 * This approach prints ???, defined on the Animal class, the virtual
		 * invocation works ONLY for methods
		 */
		Animal animalLion = new Lion();
		System.out.println(animalLion.name); // prints ???

		/*
		 * Java looks for overridden methods, and it sees that Lion implements
		 * play.
		 * 
		 * It would print "pet animal" when the subclasses do not implement the
		 * play() method
		 */
		animalLion.careFor(); // toss in meat
	}

	public static void feedAnimal(Animal animal) {
		animal.feed();
	}
}

/*
 * The Animal class is abstract, and it requires that any concrete Animal
 * subclass have a feed() method
 */
abstract class Animal {

	/*
	 * Notice how this technique is called virtual method invocation. Instance
	 * variables don’t work this way.
	 */
	String name = "???";

	public abstract void feed();

	public void careFor() {
		play();
	}

	public void play() {
		System.out.println("pet animal");
	}
}

/*
 * The three subclasses that we defined have a one‐line feed() method that
 * delegates to the class‐specific method.
 */
class Cow extends Animal {
	public void feed() {
		addHay();
	}

	private void addHay() {
		System.out.println("feeding cow with hay");
	}
}

class Bird extends Animal {
	public void feed() {
		addSeed();
	}

	private void addSeed() {
		System.out.println("feeding bird with seeds");
	}
}

class Lion extends Animal {

	/* If called from an Animal instance, it will print ??? */
	String name = "Lion";

	public void feed() {
		addMeat();
	}

	private void addMeat() {
		System.out.println("feeding lion with meat");
	}

	public void play() {
		System.out.println("toss in meat");
	}
}
