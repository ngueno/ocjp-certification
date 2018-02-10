package chapter1.advanced.classes.design.enums;

public class WorkingWithEnums {

	public static void main(String[] args) {

		// Comparing enums
		Season s = Season.SUMMER;
		System.out.println(Season.SUMMER); // SUMMER
		// They are also comparable using == because they are like static final
		// constants.
		System.out.println(s == Season.SUMMER); // true

		// Printing all the values of an enum
		for (Season season : Season.values()) {
			System.out.println(season.name() + " " + season.ordinal());
		}

		// You cannot compare the enum with the final value
		// if ( Season.SUMMER == 2) {} // DOES NOT COMPILE

		// The value passed on valueOf must be EQUAL, otherwise it will throw
		// java.lang.IllegalArgumentException: No enum constant
		// enums.Season.summer
		// Season s2 = Season.valueOf("summer"); // exception
		Season s1 = Season.valueOf("SUMMER"); // SUMMER

		// Using enum with switch
		Season summer = Season.SUMMER;

		switch (summer) {
		// You don't need to use the enum to compare, the compiler understands
		// the only possible values can be those inside the enum
		case WINTER:
			System.out.println("Get out the sled!");
			break;
		case SUMMER:
			System.out.println("Time for the pool!"); // PRINTS
			break;
		default:
			System.out.println("Is it summer yet?");
		}

		// switch (summer) {
		// case 0: // DOES NOT COMPILE
		// System.out.println("Get out the sled!");
		// break;
		// }

		// Calling an enum method
		Season.SUMMER.printExpectedVisitors(); // prints High

		// The enum constructor is called only once
		OnlyOne firstCall = OnlyOne.ONCE; // prints constructing
		OnlyOne secondCall = OnlyOne.ONCE; // doesn't print anything
		System.out.println(firstCall + " calls the constructor");
		System.out.println(secondCall + " doesn't call the constructor");

		// Calling the default method
		Season3.FALL.printHours();
	}
}

enum Season {
	WINTER("Low"), SPRING("Medium"), SUMMER("High"), FALL("Medium");

	private String expectedVisitors;

	private Season(String expectedVisitors) {
		this.expectedVisitors = expectedVisitors;
	}

	public void printExpectedVisitors() {
		System.out.println(expectedVisitors);
	}
}

enum Season2 {
	WINTER {
		public void printHours() {
			System.out.println("9am-3pm");
		}
	},
	SPRING {
		public void printHours() {
			System.out.println("9am-5pm");
		}
	},
	SUMMER {
		public void printHours() {
			System.out.println("9am-7pm");
		}
	},
	FALL {
		public void printHours() {
			System.out.println("9am-5pm");
		}
	},
	// All the subclasses inside the enum must implement the method printHours
	TESTE {
		@Override
		public void printHours() {
			// TODO Auto-generated method stub

		}
	};

	// enum with an abstract method
	public abstract void printHours();
}

enum Season3 {

	// If we don't want that the other classes mandatory implements the method
	// printHours
	WINTER {
		// ATTENTION: Overriding the printHours from enum
		public void printHours() {
			System.out.println("short hours");
		}
	},
	SUMMER {
		@Override
		public void printHours() {
			System.out.println("long hours");
		}
	},
	SPRING, FALL;
	public void printHours() {
		System.out.println("default hours");
	}
}

// You can't extends enum
// enum ExtendedSeason extends Season { } // DOES NOT COMPILE

enum OnlyOne {

	ONCE(true);

	private OnlyOne(boolean b) {
		System.out.println("constructing");
	}
}