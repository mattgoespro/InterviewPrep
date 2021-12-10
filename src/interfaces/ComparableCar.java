package interfaces;

import java.util.Arrays;

public class ComparableCar implements Comparable {
	int kph;
	int cost;
	
	public ComparableCar(int kph, int cost) {
		this.kph = kph;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Object o) {
		if (o instanceof ComparableCar) {
			ComparableCar c = (ComparableCar) o;
			int thisRating = this.kph * this.cost;
			int cRating = c.kph * c.cost;
			
			if (thisRating > cRating) {
				return 1;
			} else if (thisRating == cRating) {
				return 0;
			}
			
			return -1;
		}
		
		return 0;
	}
	
	@Override
	public String toString() {
		return "Rating: " + this.kph * this.cost;
	}
}

class CompareCars {
	public static void main(String[] args) {
		// @formatter:off
		ComparableCar[] cars = new ComparableCar[]{
				new ComparableCar(100, 3000),
				new ComparableCar(100,2),
				new ComparableCar(20, 20),
				new ComparableCar(3, 500),
				new ComparableCar(12, 20)
		};
		System.out.println(Arrays.stream(cars).toList());
		Arrays.sort(cars);
		System.out.println(Arrays.stream(cars).toList());
	}
}
