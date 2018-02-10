package chapter1.advanced.classes.design.nested.local;

// Local Inner Classes
//
//A local inner class is a nested class defined within a method. Like local variables, a local
//inner class declaration does not exist until the method is invoked, and it goes out of scope
//when the method returns. This means that you can create instances only from within the 
//method. Those instances can still be returned from the method. This is just how local variables
//work. Local inner classes have the following properties:
//
// ■ They DO NOT HAVE an access specifier.
// ■ They CANNOT BE DECLARED STATIC and CANNOT DECLARE STATIC FIELDS OR METHODS.
// ■ They have access to all fields and methods of the enclosing class.
// ■ They DO NOT HAVE ACCESS TO LOCAL VARIABLES of a method UNLESS those variables are FINAL
//or EFFECTIVELY FINAL. More on this shortly.
//
// ATTENTION: Local Inner Classes are defined INSIDE METHODS
public class NestedClassesLocal {

	public static void main(String[] args) {

	}
}

class Outer {
	private int length = 5;

	public void calculate() {
		final int width = 20;
		class Inner {
			public void multiply() {
				// Accessing the final variable WIDTH and effectively final
				// LENGTH
				System.out.println(length * width);
			}
		}
		Inner inner = new Inner();
		inner.multiply();
	}
}