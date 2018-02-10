package chapter2.design.pattern.principles.interfaces;

import java.util.List;

public class InterfaceDesign {

	public static void main(String[] args) {

		// Limited multiple inheritance
		Frog frog = new Frog();

		// Both swim and hop accept frog
		InterfaceDesign.testHop(frog);
		InterfaceDesign.testSwim(frog);
	}

	public static void testSwim(Swim swim) {
		System.out.println("Test swim");
	}

	public static void testHop(Hop hop) {
		System.out.println("Test hop");
	}
}

interface Fly {
	public static final int MAX_SPEED = 100;

	// REMEMBER: if not declared the modifiers, the variable will be ALWAYS
	// PUBLIC STATIC FINAL
	/* public static final */int MAX_SPEED_EXAMPLE = 100;

	public int getWingSpan() throws Exception;

	// Interfaces can declare a method with body using DEFAULT annotation
	public default void land() {
		System.out.println("Animal is landing");
	}

	// Can also declare public static methods
	public static double calculateSpeed(float distance, double time) {
		return distance / time;
	}
}

class Eagle implements Fly {

	// Implicit @Override
	public int getWingSpan() {
		return 15;
	}

	// There is NO NECESSITY of OVERRIDE a DEFAULT method
	// The block below can be commented if desired
	public void land() {
		System.out.println("Eagle is diving fast");
	}
}

interface Walk {

	// Implicit modifier public
	boolean isQuadruped();

	abstract double getMaxSpeed();
}

// An interface can extends another
interface Run extends Walk {
	public abstract boolean canHuntWhileRunning();

	// Overriding from Walk
	abstract double getMaxSpeed();
}

// IMPORTANT: The implementer class must me explicit declare the PUBLIC
// modifier, otherwise it will not compile
class Lion implements Run {

	// Overriding from Walk
	public boolean isQuadruped() {
		return true;
	}

	// Overriding from Run
	public boolean canHuntWhileRunning() {
		return true;
	}

	// Overriding from Run
	public double getMaxSpeed() {
		return 100;
	}
}

// An interface CANNOT extends a class
// public interface Sleep extends Lion {} // DOES NOT COMPILE

// A class CANNOT extends an interface
// public class Tiger extends Walk {} // DOES NOT COMPILE

// With interface we can provide a limited multiple inheritance
interface Swim {
}

interface Hop {
}

// The frog implements both Swim and Hop, can be passed a parameter using
// polymorphism
class Frog implements Swim, Hop {
}

// Mock Class
class Animal {
}

class Tortoise extends Animal {
}

class Hare extends Animal {
}

class Kangaroo extends Animal {
}

interface RaceManager {
	public Animal getWinner(List<Animal> animals);
}

// Simple mock implementation
class MockRaceManager implements RaceManager {

	public Animal getWinner(List<Animal> animals) {
		return animals == null || animals.size() == 0 ? null : animals.get(0);
	}

}