package chapter2.design.pattern.principles.workout;

import java.util.ArrayList;
import java.util.List;

// PROBLEM: How do we create read‐only objects that can be shared and used by multiple classes?
// SOLUTION: The immutable object pattern is a creational pattern based on the idea of
// creating objects whose state does not change after they are created and can be easily shared
// across multiple classes.
//
// Immutable Strategy
// 1. Use a CONSTRUCTOR to SET ALL PROPERTIES of the object.
// 2. Mark ALL of the instance VARIABLES PRIVATE and FINAL.
// 3. DON'T DEFINE any SETTER methods.
// 4. DON'T allow referenced MUTABLE objects TO BE MODIFIED or ACCESSED DIRECTLY.
// 5. PREVENT methods from being OVERRIDDEN.
public class ImmutableObjects {

	public static void main(String[] args) {

	}

}

final class AnimalMutable {

	private final List<String> favoriteFoods;

	public AnimalMutable(List<String> favoriteFoods) {
		if (favoriteFoods == null) {
			throw new RuntimeException("favoriteFoods is required");
		}
		this.favoriteFoods = new ArrayList<String>(favoriteFoods);
	}

	public List<String> getFavoriteFoods() { // MAKES CLASS MUTABLE!
		return favoriteFoods;
	}
}

// RULE 5 - MARKING THE CLASS FINAL PREVENT CREATION OF SUBCLASSES, AND METHOD OVERRIDING
final class AnimalImutable {

	// RULE 1 - ALL PRIVATE AND FINAL
	private final String species;
	private final int age;
	private final List<String> favoriteFoods;

	public AnimalImutable(String species, int age, List<String> favoriteFoods) {
		this.species = species;
		this.age = age;
		if (favoriteFoods == null) {
			throw new RuntimeException("favoriteFoods is required");
		}

		// ATTENTION - IT IS EXTREMELLY IMPORTANT CREATE A NEW REFERENCE OF LIST
		// IF IT ISN'T CREATE, WE WILL WORK WITH THE REFERENCE PASSED THROUGH THE CONSTRUCTOR
		this.favoriteFoods = new ArrayList<String>(favoriteFoods);
	}

	// RULE 2 - NO SETTERS
	// RULE 4 - STRING IS IMUTABLE, NO PROBLEM IN RETURNING
	public String getSpecies() {
		return species;
	}

	public int getAge() {
		return age;
	}

	// RULE 3 - NO REFERENCES TO THE LIST ARE PUBLIC AVAILABLE
	public int getFavoriteFoodsCount() {
		return favoriteFoods.size();
	}

	public String getFavoriteFood(int index) {
		return favoriteFoods.get(index);
	}
}

