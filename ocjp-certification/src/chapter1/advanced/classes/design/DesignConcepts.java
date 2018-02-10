package chapter1.advanced.classes.design;

public class DesignConcepts {

	public static void main(String[] args) {

	}

	// Effective final variables are introduced in Java 8
	// It means that a variable that is DECLARED and INITIALIZED in the same
	// line
	// holds it values unchanged through the program execution
	public void isItFinal() {
		int one = 20; // In this case one is effectively final
		int two = one;
		two++; // two value is changed
		int three; // three is not initialized
		if (one == 4)
			three = 3; // three value is changed
		else
			three = 4; // three value is changed
		int four = 4;
		class Inner {
		}
		four = 5; // four valued is changed
	}
}
