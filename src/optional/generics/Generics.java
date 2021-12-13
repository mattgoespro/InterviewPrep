package optional.generics;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

class Box {
	Object[] objects;
	
	public Box(Object... objects) {
		this.objects = objects;
	}
	
	public void sortObjects() {
		// We don't know what object types we are
		// working with. 'objects' could be of any
		// class, so don't know how to sort them.
		// Result throws a ClassCastException.
		Arrays.sort(objects);
	}
}

@AllArgsConstructor
class Toy implements Comparable<Toy> {
	String name;
	int minAgeGroup;
	
	@Override
	public int compareTo(Toy toy) {
		if (toy != null) {
			return this.name.compareTo(toy.name);
		}
		
		return -1;
	}
	
	@Override
	public String toString() {
		return name;
	}
}

@Getter
class GenericBox<T> {
	T[] objects;
	
	public GenericBox(T... objects) {
		this.objects = objects;
	}
	
	public void sortObjects() {
		// All objects are of the same type 'T',
		// so we can sort them using their shared
		// sort mechanism.
		Arrays.sort(objects);
	}
}

class Delivery<E, T> {
	E transport;
	T[] items;
	
	public Delivery(E transport, T... items) {
		this.transport = transport;
		this.items = items;
	}
	
	@Override
	public String toString() {
		return transport + " delivering " + items.length + " items: " + Arrays.toString(items);
	}
	
	public E getTransport() {
		return transport;
	}
	
	public <K> void printExtraInformationFromObject(K extraInfoObject) {
		System.out.println(this + " (" + extraInfoObject + ")");
	}
}

public class Generics {
	public static void main(String[] args) {
		//@formatter:off
		Box box = new Box("Hammer", 'T', true, Integer.MAX_VALUE);
		// Below throws error, doesn't know how to compare objects of
		// different types.
		// box.sortObjects();
		
		GenericBox<Toy> toyBox = new GenericBox<Toy>(
			new Toy("YoYo", 10),
			new Toy("Lego", 5),
			new Toy("BB Gun", 14),
			new Toy("RC Car", 10),
			new Toy("Puzzle", 6)
		);
		
		toyBox.sortObjects();
		System.out.println(Arrays.toString(toyBox.getObjects()));
		
		Delivery<String, Toy> ups = new Delivery(
	"Car",
			new Toy("YoYo", 10),
			new Toy("Lego", 5),
			new Toy("BB Gun", 14),
			new Toy("RC Car", 10),
			new Toy("Puzzle", 6));
		
		ups.<String>printExtraInformationFromObject("Delivered from Cape Town");
	}
}

