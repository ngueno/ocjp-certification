package chapter2.design.pattern.principles.workout;

import java.util.Arrays;
import java.util.List;

// PROBLEM: How do we create an object that requires numerous values to be set at the time
// the object is instantiated?
// SOLUTION: The builder pattern is a creational pattern in which PARAMETERS ARE PASSED TO A
// BUILDER OBJECT, often through method chaining, and an object is generated with a final build
// call. It is OFTEN USED WITH IMMUTABLE OBJECTS, since immutable objects do not have setter
// methods and must be created with all of their parameters set, although IT CAN BE USED WITH
// MUTABLE OBJECTS AS WELL.
public class BuilderPattern {

	public static void main(String[] args) {

		AnimalBuilder duckBuilder = new AnimalBuilder();
		
		// Builder methods are commonly chained together, often callable in
		// any order
		duckBuilder
				.setAge(4)
				.setFavoriteFoods(Arrays.asList("grass","fish"))
				.setSpecies("duck");
		
		AnimalImutable duck = duckBuilder.build();
		
		AnimalImutable flamingo = new AnimalBuilder()
											.setFavoriteFoods(Arrays.asList("algae","insects"))
											.setSpecies("flamingo")
											.build();
	}
}

class AnimalBuilder {

	private String species;
	private int age;
	private List<String> favoriteFoods;

	public AnimalBuilder setAge(int age) {
		this.age = age;
		return this;
	}

	public AnimalBuilder setSpecies(String species) {
		this.species = species;
		return this;
	}

	public AnimalBuilder setFavoriteFoods(List<String> favoriteFoods) {
		this.favoriteFoods = favoriteFoods;
		return this;
	}

	public AnimalImutable build() {
		// If the Animal class did not have a
		// public constructor, programs calling it from other packages would be required to use the
		// AnimalBuilder class to create instances of Animal.
		return new AnimalImutable(species,age,favoriteFoods);
	}
}
