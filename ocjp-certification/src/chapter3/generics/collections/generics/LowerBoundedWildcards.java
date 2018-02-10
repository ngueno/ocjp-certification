package chapter3.generics.collections.generics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//  Code                                   Method compiles                 Can pass a               Can pass a 
//                                                                              List<String>             List<Object>
// public static void                      No (unbounded                   Yes                      Yes
// addSound(List<?> list)                        generics are immutable)
// {list. add("quack");}                   
// public static void                      No (upperbounded                Yes                      Yes
// addSound(List<? extends Object> list)        generics are immutable
// {list.add("quack");}      
// public static void                      Yes                             No (with generics,       Yes
// addSound(List<Object> list)                                              must pass exact match)
// {list.add("quack");}                    
// public static void                      Yes                             Yes                      Yes
// addSound(List<? super String> list) 
// {list.add("quack");}    
public class LowerBoundedWildcards {

	public static void main(String[] args) {

		List<String> strings = new ArrayList<String>();
		strings.add("tweet");

		List<Object> objects = new ArrayList<Object>(strings);

		addSound(strings);
		addSound(objects);

		GenericSupertypes.testHierarchy();
	}
	
	// COMPILES (LOWER BOUND)
	// With a lower bound, we are telling Java THAT THE LIST WILL BE a list OF STRING objects OR a
	// list of SOME OBJECTS THAT ARE A SUPERCLASS OF STRING
	public static void addSound(List<? super String> list) {
		list.add("quack");
	}

	// UNBOUNDED GENERICS ARE IMMUTABLE
	// public static void addSound(List<?> list) {
	// list.add("quack");
	// }

	// UPPERBOUNDED GENERICS ARE IMMUTABLE
	// public static void addSound(List<? extends Object> list) {
	// list.add("quack");
	// }

	// WITH GENERICS, MUST PASS EXACT MATCH
	// public static void addSound(List<Object> list) {
	// list.add("quack");
	// }
}

// When you have subclasses and superclasses, lower bounds can get tricky
class GenericSupertypes {

	public void test() {
		List<? super IOException> exceptions = new ArrayList<Exception>();
		// exceptions.add(new Exception()); // DOES NOT COMPILE
		exceptions.add(new IOException());
		exceptions.add(new FileNotFoundException());
	}

	public static void testHierarchy() {
		
		// List<? super Daughter> daughters = new ArrayList<Mother>();
		// daughters.add(new Object()); // DOESN'T COMPILE, DAUGHTERS DOESN'T ACCEPT OBJECTS

		// ATTENTION: LOOKING THE SUPERCLASS
		List<Object> objects = new ArrayList<Object>();
		testFamily(objects);

		// ATTENTION: LOOKING THE SUPERCLASS
		List<Mother> mothers = new ArrayList<Mother>();
		testFamily(mothers);

		// ATTENTION: LOOKING THE SUPERCLASS
		List<GrandMother> grandmothers = new ArrayList<GrandMother>();
		testFamily(grandmothers);

		List<? super Daughter> daughters = new ArrayList<Mother>();
		daughters.add(((Daughter) new Object())); // COMPILE, CASTING TO DAUGHTER, CLASSCASTEXCEPTION AT RUNTIME
	}

	private static void testFamily(List<? super Daughter> daughters) {

	}
}

class GrandMother {
	
}

class Mother extends GrandMother {

}

class Daughter extends Mother {

}