package ds.stacks;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
	private List<T> items = new ArrayList<>();

	// Getter
	public List<T> getItems() {
		return this.items;
	}

	public boolean isEmpty() {
		return this.items == null || this.items.size() <= 0;
	}

	public void push(T value) {
		this.items.add(value);
	}

	public T pop() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("POP action on an empty Stack is not allowed");
		} else {
			// Remove the Last element
			int lastElementIndex = this.items.size() - 1;
			T lastElement = this.items.remove(lastElementIndex);
			return lastElement;
		}
	}
}
