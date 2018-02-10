package chapter2.design.pattern.principles.design.classes;

public class ClassDesign {


}

// Applying the Is‐a Relationship
// The fundamental result of the is‐a principle is that IF A IS-A B, THEN ANY
// INSTANCE OF A CAN BE TRATEAD LIKE AN INSTANCE OF B. This holds true for a child that is a
// subclass of any parent,
// be it a direct subclass or a distant child. As we discussed with
// polymorphism, objects can take many different forms.
class IsARelationship {

	// Cat extends Pet
	// Good design—A Cat is‐a Pet, because Cat extends Pet.

	// Cat and Tiger extends Pet
	// Poor design—A Tiger is‐a Pet, because Tiger extends Pet.

	// Pet extends Feline, Cat and Dog extends Pet (what is not true of course)
	// Still poor design—All Pets are now Felines

	// Feline extends Animal, Cat and Tiger extends Feline
	// Dog extends Animal, Cat and Dog implements the PET INTERFACE
	// Good design—Pet is now an interface.

}

// In object‐oriented design, we often want to test whether an object contains a
// particular
// property or value. We refer to the has‐a relationship as the property of an
// object having a
// named data object or primitive as a member. The has‐a relationship is also
// known as the
// object composition test, described in the next section.
class HasARelationship {

	// Bird HAS-A Beak
}

class IsAHasAExample {

	public class Tail {
	}

	public class Primate {
		protected Tail tail;
	}

	public class Monkey extends Primate { // Monkey has-a Tail since it is-a
		// Primate
	}

	public class Chimpanzee extends Primate { // Chimpanzee has-a Tail since it
		// is-a Primate
	}

	// ATTENTION: Every child of Primate will have the Tail attribute
	// Examining individually, it can have any sense, but, in the real world
	// Chimpanzee doesn't have a Tail
	// The data model will be incorrect
}

// In object‐oriented design, we refer to object composition as the property of
// constructing a
// class using references to other classes in order to reuse the functionality
// of the other classes.
// In particular, the class contains the other classes in the has‐a sense and
// may delegate
// methods to the other classes.
class Composition {

	public class Flippers {
		public void flap() {
			System.out.println("The flippers flap back and forth");
		}
	}

	public class WebbedFeet {
		public void kick() {
			System.out.println("The webbed feet kick to and fro");
		}
	}

	// The penguin can have Flippers and WebbedFeet
	// ATTENTION: Now we can use the same objects (Flippers and WebbedFeet) in a
	// unrelated object, like a
	// Dolphin for example, or a Bird
	public class Penguin {
		private final Flippers flippers;
		private final WebbedFeet webbedFeet;

		public Penguin() {
			this.flippers = new Flippers();
			this.webbedFeet = new WebbedFeet();
		}

		public void flap() {
			this.flippers.flap();
		}

		public void kick() {
			this.webbedFeet.kick();
		}
	}

}