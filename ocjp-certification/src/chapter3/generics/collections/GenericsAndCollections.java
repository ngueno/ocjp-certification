package chapter3.generics.collections;

// Naming Conventions for Generics
// A type parameter can be named anything you want. The convention is to use single
// uppercase letters to make it obvious that they aren’t real class names. The following are
// common letters to use:
// ■■ E 	   for an element
// ■■ K 	   for a map key
// ■■ V 	   for a map value
// ■■ N 	   for a number
// ■■ T 	   for a generic data type
// ■■ S, U, V, and so forth for multiple generic types

// What you can't do with generic types
//■■ Call the constructor. new T() is not allowed because at runtime it would be new
//Object().
//■■ Create an array of that static type. This one is the most annoying, but it makes sense
//because you’d be creating an array of Objects.
//■■ Call instanceof. This is not allowed because at runtime List<Integer> and
//List<String> look the same to Java thanks to type erasure.
//■■ Use a primitive type as a generic type parameter. This isn’t a big deal because you
//can use the wrapper class instead. If you want a type of int, just use Integer.
//■■ Create a static variable as a generic type parameter. This is not allowed because the
//type is linked to the instance of the class.
public class GenericsAndCollections {


	public static void main(String[] args) {

	}
}
