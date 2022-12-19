package interfaces;

import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
class ComparableCar implements Comparable<ComparableCar> {
  int kph;
  int cost;

  @Override
  public int compareTo(ComparableCar car) {
    if (car != null) {
      int thisRating = this.kph * this.cost;
      int carRating = car.kph * car.cost;

      if (thisRating > carRating) {
        return 1;
      } else if (thisRating == carRating) {
        return 0;
      }

      return -1;
    }

    return 0;
  }
}

class ComparatorCar implements Comparator<ComparableCar> {
  @Override
  public int compare(ComparableCar car1, ComparableCar car2) {
    return car1.compareTo(car2);
  }
}

class CompareCars {
  public static void main(String[] args) {
    ComparableCar[] cars =
        new ComparableCar[] {
          new ComparableCar(100, 3000),
          new ComparableCar(100, 2),
          new ComparableCar(20, 20),
          new ComparableCar(3, 500),
          new ComparableCar(12, 20)
        };
    System.out.println(Arrays.stream(cars).toList());
    Arrays.sort(cars);
    System.out.println(Arrays.stream(cars).toList());

    ArrayList<ComparableCar> carList =
        new ArrayList<>(
            List.of(
                new ComparableCar(100, 3000),
                new ComparableCar(100, 2),
                new ComparableCar(20, 20),
                new ComparableCar(3, 500),
                new ComparableCar(12, 20)));
    System.out.println(carList);
    Collections.sort(carList, new ComparatorCar());
    System.out.println(carList);
  }
}
