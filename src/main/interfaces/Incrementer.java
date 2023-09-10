package interfaces;

import java.util.Iterator;

public class Incrementer implements Iterable<Integer> {
  int counter = 0;

  static class IncrementerIterator implements Iterator<Integer> {

    private Incrementer incrementer;

    public IncrementerIterator(Incrementer incrementer) {
      this.incrementer = incrementer;
    }

    @Override
    public boolean hasNext() {
      return this.incrementer.counter < 10;
    }

    @Override
    public Integer next() {
      return ++this.incrementer.counter;
    }
  }

  @Override
  public Iterator iterator() {
    return new IncrementerIterator(this);
  }
}

class Increment {
  public static void main(String[] args) {
    Incrementer inc = new Incrementer();

    for (int i : inc) {
      System.out.println(i);
    }
  }
}
