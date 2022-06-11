package ds.queue;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
	private List<T> items = new ArrayList<>();

	// Getter
	public List<T> getItems() {
		return this.items;
	}

	public boolean isEmpty() {
		return this.items == null || this.items.size() <= 0;
	}

	public void enqueue(T value) {
		this.items.add(value);
	}

	public T dequeue() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("dequeue action on an empty queue is not allowed");
		} else {
			// Remove the first element.
			T firstElement = this.items.remove(0);
			return firstElement;
		}
	}
}
