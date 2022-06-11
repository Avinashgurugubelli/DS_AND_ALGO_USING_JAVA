package ds.graphs;

import ds.queue.Queue;
import ds.stacks.Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph<T> {

	public List<T> BFS(GNode<T> StartNode) throws Exception {
		List<T> traversal = new ArrayList<>();
		Queue<GNode<T>> q = new Queue<>();
		q.enqueue(StartNode);
		while (!q.isEmpty()) {
			GNode<T> currentNode = q.dequeue();
			currentNode.visited = true;
			traversal.add(currentNode.value);
			for (GNode<T> node : currentNode.adjacentNodes) {
				if (!node.visited) {
					node.visited = true;
					q.enqueue(node);
				}
			}
		}
		return traversal;
	}

	public List<T> DFS(GNode<T> startNode, List<T> traversal) throws Exception {
		if (startNode != null) {
			startNode.visited = true;
			traversal.add(startNode.value);
			for (GNode<T> node : startNode.adjacentNodes) {
				if (!node.visited) {
					this.DFS(node, traversal);
				}
			}
		}
		return traversal;
	}
}
