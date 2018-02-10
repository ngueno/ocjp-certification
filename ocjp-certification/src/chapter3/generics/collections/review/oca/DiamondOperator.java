package chapter3.generics.collections.review.oca;

import java.util.ArrayList;
import java.util.List;

public class DiamondOperator {

	public static void main(String[] args) {

		// Before Java 5 - hope that programmers remembered that you wanted only String objects in there
		List names1 = new ArrayList();

		// In Java 5
		List<String> names2 = new ArrayList<String>();

		// In Java 7
		List<String> names3 = new ArrayList<>();
	}
}

class Doggies {
	List<String> names;

	Doggies() {
		names = new ArrayList<>(); // matches instance variable declaration
	}

	public void copyNames() {
		ArrayList<String> copyOfNames;
		copyOfNames = new ArrayList<>(); // matches local variable declaration
	}
}