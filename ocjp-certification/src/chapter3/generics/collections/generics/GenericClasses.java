package chapter3.generics.collections.generics;

public class GenericClasses {

	public static void main(String[] args) {

		Crate<String> crate = new Crate<>();
		crate.packCrate("lol");

		Elephant elephant = new Elephant();
		Crate<Elephant> crateForElephant = new Crate<>();
		crateForElephant.packCrate(elephant);
		Elephant inNewHome = crateForElephant.emptyCrate();

		Crate<Zebra> crateForZebra = new Crate<>();

		Robot joeBot = new Robot();
		Crate<Robot> robotCrate = new Crate<>();
		robotCrate.packCrate(joeBot);
		// ship to St. Louis
		Robot atDestination = robotCrate.emptyCrate();

		Elephant elephant2 = new Elephant();
		Integer numPounds = 15_000;
		SizeLimitedCrate<Elephant, Integer> c1 = new SizeLimitedCrate<>(elephant, numPounds);
	}
}

class Crate<T> {
	private T contents;

	public T emptyCrate() {
		return contents;
	}

	public void packCrate(T contents) {
		this.contents = contents;
	}
}

class Elephant {
	public Elephant() {

	}
}

class Zebra {
	public Zebra() {

	}
}

class Robot {
	public Robot() {

	}
}

class SizeLimitedCrate<T, U> {
	private T contents;
	private U sizeLimit;

	public SizeLimitedCrate(T contents, U sizeLimit) {
		this.contents = contents;
		this.sizeLimit = sizeLimit;
	}
}