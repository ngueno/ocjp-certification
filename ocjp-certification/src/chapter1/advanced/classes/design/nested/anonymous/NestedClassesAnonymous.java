package chapter1.advanced.classes.design.nested.anonymous;

//An anonymous inner class IS A LOCAL INNER CLASS that DOES NOT HAVE A NAME. It is declared
//and instantiated all in one statement using the new keyword. Anonymous inner classes are
//required to extend an existing class or implement an existing interface. 
//
// ATTENTION: Anonymous with abstract classes and interfaces works THE SAME WAY
// The difference between then is that abstract classes can modify the level access to methods
// In the interfaces the methods are always public
//
// There is NO WAY to implement and extends simultaneously 
public class NestedClassesAnonymous {

	public static void main(String[] args) {

		AnonInnerClass anonInnerClass = new AnonInnerClass();
		System.out.println(anonInnerClass.admission(10)); // 7

		AnonInnerInterface anonInnerInterface = new AnonInnerInterface();
		System.out.println(anonInnerInterface.admission(10)); // 7

		AnonInnerParameter anonInnerParameter = new AnonInnerParameter();
		System.out.println(anonInnerParameter.pay()); // 7
	}
}

class AnonInnerClass {

	// This class cannot be instantiated, since it is abstract
	abstract class SaleTodayOnly {
		abstract int dollarsOff();
	}

	public int admission(int basePrice) {

		// The same way that a local inner class, it will be declared inside a
		// method, but with your implementation together
		SaleTodayOnly sale = new SaleTodayOnly() {
			int dollarsOff() {
				return 3;
			}
		};
		return basePrice - sale.dollarsOff();
	}
}

class AnonInnerInterface {

	// Declaring an interface with the desired method
	interface SaleTodayOnly {
		int dollarsOff();
	}

	public int admission(int basePrice) {
		SaleTodayOnly sale = new SaleTodayOnly() {
			// Following the rule, now we have a public method from an interface
			public int dollarsOff() {
				return 3;
			}
		};
		return basePrice - sale.dollarsOff();
	}
}

class AnonInnerParameter {
	interface SaleTodayOnly {
		int dollarsOff();
	}

	public int pay() {
		// Passing the anonymous with implementation to method
		return admission(10, new SaleTodayOnly() {
			public int dollarsOff() {
				return 3;
			}
		});
	}

	// We can use the anonymous classes everywhere
	public int admission(int basePrice, SaleTodayOnly sale) {
		return basePrice - sale.dollarsOff();
	}
}