package ds.graphs;

import java.util.ArrayList;
import java.util.List;

public class GNode<T> {
	public T value;
	public List<GNode<T>> adjacentNodes = new ArrayList<>();
	public boolean visited;

	public GNode() {
		this.visited = false;
	}

	public GNode(T value) {
		this.value = value;
		this.visited = false;
	}

	public GNode(T value, List<GNode<T>> adjacentNodes) {
		this.value = value;
		this.adjacentNodes = adjacentNodes;
		this.visited = false;
	}
}
