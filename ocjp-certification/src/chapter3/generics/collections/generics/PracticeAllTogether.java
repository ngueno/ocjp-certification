package chapter3.generics.collections.generics;

import java.util.ArrayList;
import java.util.List;

public class PracticeAllTogether {

	public static void main(String[] args) {

		// Unbounded wildcard, A GENERIC TYPE CAN BE REFERENCE BY AN UNBOUNDED WILDCARD
		List<?> list1 = new ArrayList<A>();

		// A is a A, so the extends evaluate A
		List<? extends A> list2 = new ArrayList<A>();

		// A is a A, so the super evaluate A
		List<? super A> list3 = new ArrayList<A>();

		// A ISN'T A SUBCLASS OF B, so the extends DOESN'T EVALUATE TO A
		// List<? extends B> list4 = new ArrayList<A>(); // DOES NOT COMPILE
		List<? extends B> list4 = new ArrayList<C>(); // C is a subclass of B

		// A is a supertype of B, so the super evaluate to A
		List<? super B> list5 = new ArrayList<A>();

		// It doesn't compile because the compiler need to knows the instance to instantiate
		// List<?> list6 = new ArrayList<? extends A>(); // DOES NOT COMPILE
		List<?> list6 = new ArrayList<A>(); // PASSING A INSTANCE OF A
		List<?> list7 = new ArrayList<B>(); // PASSING A INSTANCE OF B
		List<?> list8 = new ArrayList<C>(); // PASSING A INSTANCE OF C

	}

	// Takes a type and accept all of that type
	// For example, if passed String it will be accept String and any subclass (String is final and do not has subclasses lol), or Number, or...
	<T> T method1(List<? extends T> list) {
		return list.get(0);
	}

	// This method doesn't have a return type, if you are writing the method, you are supposed to know the type you return
	// <T> <? extends T> method2(List<? extends T> list) { // DOES NOT COMPILE
	// return list.get(0);
	// }

	// The name of the fucking variable is B, and it is the name of a class
	// Using <B extends A>, the instance B needs to be a subclass of A, but it can return A, B or C instances.
	// and REMEMBER you little piece of shit, YOU NEED TO KNOW THE RETURN TYPE
	// <B extends A> B method3(List<B> list) {
	// return new B(); // DOES NOT COMPILE
	// }

	// Any instance of B and superclasses of B
	void method4(List<? super B> list) {
	
	}
	
	// X is a reference to a generic type, but you are mixing!
	// YOU CAN'T USE SUPER WITH A GENERIC TYPE
	// If you have this necessity, YOU MUST USE AN WILDCARD
	// <X> void method5(List<X super B> list) { // DOES NOT COMPILE
	//
	// }
	<X> void method5(List<? super B> list) { // IT COMPILES BECAUSE IT USES A WILDCARD

	}
}

class A {
}

class B extends A {
}

class C extends B {
}