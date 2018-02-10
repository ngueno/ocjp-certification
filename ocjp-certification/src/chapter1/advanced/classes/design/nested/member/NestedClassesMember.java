package chapter1.advanced.classes.design.nested.member;

import chapter1.advanced.classes.design.nested.member.Outer.Inner;

//Member Inner Classes
//
//A member inner class is defined at the member level of a class (the same
//level as the methods, instance variables, and constructors). Member inner
//classes have the following properties:
//
//■ Can be declared public, private, or protected or use default access
//■ Can EXTENDS ANY class and IMPLEMENT interfaces
//■ Can be abstract or final
//■ CANNOT declare static fields or methods
//■ CAN ACCESS MEMBERS of the outer class INCLUDING PRIVATE members
//
// ATTENTION: Member Inner Classes are define on the level of METHODS, DOESN'T INSIDE METHODS
public class NestedClassesMember {

	public static void main(String[] args) {

		Outer outer = new Outer();
		outer.callInner();

		// The inner classes are not static, so it can be accessed from an
		// instance of outer
		Inner inner = outer.new Inner();
		inner.go();

		// It does not compile because the compiler doesn't
		// know what instance of Outer corresponds the Inner
		// Outer.new Inner(); // DOES NOT COMPILE

		// Calling inner classes inside inner classes
		A a = new A();
		A.B b = a.new B();
		A.B.C c = b.new C();
		c.allTheX();
	}
}

class Outer {
	private String greeting = "Hi";

	// All the possible access modifiers
	// public class Inner
	// private class Inner {
	// class Inner
	protected class Inner {
		public int repeat = 3;
		// static int staticTest = 5; // DOES NOT COMPILE
		final int finalTest = 5;

		public void go() {
			for (int i = 0; i < repeat; i++)
				// Accessing greeting of Outer
				System.out.println(greeting);

			System.out.println();
		}
	}

	public void callInner() {
		Inner inner = new Inner();
		inner.go();
	}
}

// Inner classes can declare inner classes either
class A {
	private int x = 10;

	class B {
		private int x = 20;

		class C {
			private int x = 30;

			public void allTheX() {
				System.out.println(x); // 30 - calling from C
				System.out.println(this.x); // 30 - calling from C
				System.out.println(B.this.x); // 20 - calling from B
				System.out.println(A.this.x); // 10 - calling from A
			}
		}
	}
}

// It is possible implements an private interface declared inside the class
// That's weird but it compiles and run without problems
class CaseOfThePrivateInterface {
	private interface Secret {
		// The rule that all methods in an interface are public still applies. A
		// class that implements the interface must define that method as
		// public.
		public void shh();
	}

	class DontTell implements Secret {
		public void shh() {
		}
	}
}