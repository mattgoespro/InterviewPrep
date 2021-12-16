package datastructures.customimplementations;

import java.util.NoSuchElementException;

public class QueueImpl<T> {
	static class QueueNode<T> {
		T data;
		QueueNode<T> next;
		
		public QueueNode(T data) {
			this.data = data;
		}
	}
	
	QueueNode<T> first;
	QueueNode<T> last;
	
	public void add(T item) {
		QueueNode<T> t = new QueueNode<T>(item);
		if (last != null) {
			// puts new node after current last node
			last.next = t;
		}
		// sets the last node to the new node
		last = t;
		if (first == null) {
			first = last;
		}
	}
	
	public T remove() {
		if (first == null)
			throw new NoSuchElementException();
		T data = first.data;
		// set first node to next element in queue
		first = first.next;
		if (first == null) {
			last = null;
		}
		return data;
	}
	
	public T peek() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}
	
	public boolean isEmpty() {
		return this.first == null;
	}
}
