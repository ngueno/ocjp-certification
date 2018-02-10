package chapter2.design.pattern.principles.workout;

// PROBLEM: How do we create an object in memory only once in an application and have it
// shared by multiple classes?
// SOLUTION: The singleton pattern is a creational pattern focused on CREATING ONLY ONE
// INSTANCE of an object in memory within an application, sharable by all classes and threads
// within the application.
public class SingletonPattern {

	public static void main(String[] args) {

	}

}

class HayStorage {
	private int quantity = 0;

	// By marking the constructors private, we HAVE IMPLICITY marked the class final
	private HayStorage() {
		// By doing this, we can't have subclasses of a singleton
	}

	private static final HayStorage instance = new HayStorage();

	public static HayStorage getInstance() {
		return instance;
	}

	public synchronized void addHay(int amount) {
		quantity += amount;
	}

	public synchronized boolean removeHay(int amount) {
		if (quantity < amount)
			return false;
		quantity -= amount;
		return true;
	}

	public synchronized int getHayQuantity() {
		return quantity;
	}
}

// One thing to keep in mind is that there might be multiple llama trainers at the zoo
// but ONLY ONE FOOD STORAGE LOCATION.
class LlamaTrainer {

	public boolean feedLlamas(int numberOfLlamas) {
		int amountNeeded = 5 * numberOfLlamas;

		// Get the only instance of HayStorage running
		HayStorage hayStorage = HayStorage.getInstance();

		if (hayStorage.getHayQuantity() < amountNeeded) {
			hayStorage.addHay(amountNeeded + 10);
		}

		boolean fed = hayStorage.removeHay(amountNeeded);

		if (fed)
			System.out.println("Llamas have been fed");

		return fed;
	}
}

// The following example creates a singleton using a static initialization block when
// the class is loaded.
class StaffRegister {
	private static final StaffRegister instance;

	// Instantiation using a static block
	static {
		instance = new StaffRegister();
		// Perform additional steps
	}

	private StaffRegister() {
	}

	public static StaffRegister getInstance() {
		return instance;
	}
}

// Lazy instantiation
// Lazy instantiation reduces memory usage and improves performance when an application
// starts up. In fact, without lazy instantiation, most operating systems and applications that you
// run would take significantly longer to load and consume a great deal more memory, perhaps
// more memory than is even available on your computer. The downside of lazy instantiation is
// that users may see a noticeable delay the first time a particular type of resource is needed.
class VisitorTicketTrackerNotThreadSafe {
	private static VisitorTicketTrackerNotThreadSafe instance;

	private VisitorTicketTrackerNotThreadSafe() {
	}

	public static VisitorTicketTrackerNotThreadSafe getInstance() {

		// This method delay creation of the singleton until the first time the
		// getInstance() method is called
		if (instance == null) {
			// Thread safety is the property of an object that guarantees safe execution by multiple
			// threads at the same time
			instance = new VisitorTicketTrackerNotThreadSafe(); // NOT THREAD-SAFE!
		}
		return instance;
	}

}

class VisitorTicketTrackerThreadSafe {
	private static VisitorTicketTrackerThreadSafe instance;

	private VisitorTicketTrackerThreadSafe() {
	}

	// The method of the above class wasn't thread-safe, applying the synchronized modifiers guarantees a safe execution by many threads
	// ATTENTION: Because of synchronized method, this can be costly and can impact performance, in this case, the DOUBLE CHECKED LOCKING
	// can help
	public static synchronized VisitorTicketTrackerThreadSafe getInstance() {

		// This method delay creation of the singleton until the first time the
		// getInstance() method is called
		if (instance == null) {
			// Thread safety is the property of an object that guarantees safe execution by multiple
			// threads at the same time
			instance = new VisitorTicketTrackerThreadSafe(); // BECAUSE OF SYNCHRONIZED MODIFIER NOW THIS IS THREAD-SAFE
		}
		return instance;
	}
}

// The solution is to use double‐checked locking, a design pattern in which we first test if
// synchronization is needed before actually acquiring any locks
class VisitorTicketTrackerDoubleChecked {

	// As you may have noticed, we added the volatile modifier to our singleton object
	// This keyword prevents a subtle case where the compiler tries to optimize the code such that
	// that the object is accessed before it is finished being constructed.
	private static volatile VisitorTicketTrackerDoubleChecked instance;

	private VisitorTicketTrackerDoubleChecked() {

	}

	public static VisitorTicketTrackerDoubleChecked getInstance() {
		if (instance == null) {
			synchronized (VisitorTicketTrackerDoubleChecked.class) {
				if (instance == null) {
					instance = new VisitorTicketTrackerDoubleChecked();
				}
			}
		}
		return instance;
	}
}
