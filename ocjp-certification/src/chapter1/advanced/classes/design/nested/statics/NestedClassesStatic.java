package chapter1.advanced.classes.design.nested.statics;

import chapter1.advanced.classes.design.nested.statics.Enclosing.Nested;

//A static nested class is a static
//class defined at the member level. It can be instantiated without an object of the
//enclosing class, so it can’t access the instance variables without an explicit object of
//the enclosing class.
//
//In other words, it is like a regular class except for the following:
//■ The nesting creates a namespace because the enclosing class name must be used to refer
//to it.
//■ It can be made private or use one of the other access modifiers to encapsulate it.
//■ The enclosing class can refer to the fields and methods of the static nested class.
//
// ATTENTION: A static nested class ISN'T AN INNER CLASS
//
// We can import using:
// NORMAL IMPORT: import chapter1.advanced.classes.design.nested.statics.Enclosing.Nested;
// STATIC IMPORT: import static chapter1.advanced.classes.design.nested.statics.Enclosing.Nested;
public class NestedClassesStatic {

	public static void main(String[] args) {

		// Testing the nested INSIDE enclosing
		Enclosing enclosing = new Enclosing();
		enclosing.testNested();

		// We cannot access a static nested class from an instantiated class
		// enclosing.new Nested(); // DOES NOT COMPILE

		// But we can instantiate a static nested without enclosing
		Nested nested = new Nested();
	}

}

class Enclosing {
	static class Nested {
		private int price = 6;
	}

	public void testNested() {
		Nested nested = new Nested();
		System.out.println(nested.price);
	}
}
